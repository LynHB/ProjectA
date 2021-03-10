package study.hbase;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @date: 10:57 2020/11/23
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
@Slf4j
public class HbaseConnector {
    public static Configuration sourceConfig;
    public static Connection sourceConnection;


    public static Configuration destinationConfig;
    public static Connection destinationConnection;

    static{
        sourceConfig = HBaseConfiguration.create();
        //sourceConfig.set("hbase.master","debug-clpp-hdp1.bdi.sdp:60000");
        sourceConfig.set("hbase.zookeeper.quorum", "debug-clpp-hdp1.bdi.sdp:2181") ;

        destinationConfig = HBaseConfiguration.create();
        //destinationConfig.set("hbase.master","debug-clpp-hdp1.bdi.sdp:60000");
        destinationConfig.set("hbase.zookeeper.quorum", "debug-clpp-hdp1.bdi.sdp:2181") ;

        try {
            sourceConnection = ConnectionFactory.createConnection(sourceConfig);
            destinationConnection = ConnectionFactory.createConnection(destinationConfig);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * 仅保留2个月的数据
     */
    public static Long TWO_MONTH_AGO = System.currentTimeMillis() - 60L * 60L * 1000L * 24L * 30L * 2L;

    public static ConcurrentHashMap<String,Long> agentLastStartTime = new ConcurrentHashMap<>();


    private static String getAgentId(byte[] agentId){
        int zeroIndex = 0;
        for(int i=0;i<agentId.length;i++){
            if(agentId[i]==0){
                zeroIndex = i;
                break;
            }
        }
        return Bytes.toString(agentId,0,zeroIndex);

    }


    public void extract() throws IOException {


        /*
         * 共抽取4张表
         * ApiMetaData StringMetaData SqlMetaData_Ver2 AgentInfo
         */
        String[] strings = new String[]{"ApiMetaData","StringMetaData","AgentInfo"};
        String sourceNameSpace = "";
        String destinationNameSpace = "ns_hbtest:";
        Arrays.stream(strings).parallel().forEach(s->{
            Long jobBeginTime = System.currentTimeMillis();
            try (Table destinationTable = destinationConnection.getTable(TableName.valueOf(destinationNameSpace+s));
                 Table table = sourceConnection.getTable(TableName.valueOf(sourceNameSpace+s))) {
                long count = 0L;
                long scanCount = 0L;
                //创建scan对象
                Scan scan = new Scan();
                //进行全表扫描
                ResultScanner scanner = table.getScanner(scan);
                for (Result result : scanner) {
                    //log.info("rowkey: "+ Bytes.toString(result.getRow()));
                    ByteBuffer byteBuffer = ByteBuffer.wrap(result.getRow());
                    if(!"AgentInfo".equals(s)){
                        byteBuffer.get();
                    }
                    byte[] agentId = new byte[48];
                    byteBuffer.get(agentId,0,agentId.length);

                    //log.info("agent name:"+Bytes.toString(agentId));
                    byte[] timestamp = new byte[8];
                    byteBuffer.get(timestamp,0,timestamp.length);

                    long beginTime = Long.MAX_VALUE-Bytes.toLong(timestamp);
                    //log.info("agent begin time:"+beginTime);
                    scanCount+=result.rawCells().length;
                    if(beginTime<TWO_MONTH_AGO){
                        continue;
                    }

                    // 创建put对象
                    Put put = new Put(result.getRow());

                    // 给Put对象赋值
                    for(Cell cell: result.rawCells()){
                        put.addColumn(CellUtil.cloneFamily(cell),CellUtil.cloneQualifier(cell), CellUtil.cloneValue(cell));
                    }
                    // 插入数据
                    destinationTable.put(put);
                    count += result.rawCells().length;
                    if(count%10000==0){
                        log.info("表：{} 已抽取cell数为:{},已扫描rowkey:{}",s,count,scanCount);
                    }

                }
                log.error("表：{} 抽取总cell数为:{},耗时:{}ms",s,count,System.currentTimeMillis()-jobBeginTime);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }




    public void printCells(Cell[] cells) {
        for (Cell cell : cells) {
            if(Bytes.toString(CellUtil.cloneQualifier(cell)).equals("endTimeStamp")){
                System.out.println("aaa");
            }
            log.info("列族: "+Bytes.toString(CellUtil.cloneFamily(cell)));
            log.info("列: "+Bytes.toString(CellUtil.cloneQualifier(cell)));
            log.info("值: "+Bytes.toString(CellUtil.cloneValue(cell)));
        }
    }


    public static void main(String[] args) throws IOException {
        HbaseConnector hbaseConnector = new HbaseConnector();
        hbaseConnector.extract();
    }
}
