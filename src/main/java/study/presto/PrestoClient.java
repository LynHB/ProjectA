package study.presto;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.*;

/**
 * @description:
 * @date: 9:33 2021/1/12
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class PrestoClient {
    public static void main(String[] args) throws Exception {
        Class.forName("com.facebook.presto.jdbc.PrestoDriver");
        //String location = "jdbc:presto://192.168.19.107:38080/hive/insight"; // URL格式说明：jdbc:presto://ip:port/catalog/database，参数根据实际情况变动
        //String location = "jdbc:presto://192.168.19.107:38080/hive/log_analyzer"; // URL格式说明：jdbc:presto://ip:port/catalog/database，参数根据实际情况变动
        String location = "jdbc:presto://debug-ark-hdp1.bdi.sdp:38080/hive/log_analyzer"; // URL格式说明：jdbc:presto://ip:port/catalog/database，参数根据实际情况变动
        //String location = "jdbc:presto:///longong-ctl.lg.dscc.99.com:38080/hive/log_analyzer"; // URL格式说明：jdbc:presto://ip:port/catalog/database，参数根据实际情况变动

        String user = "log_analyzer"; // 测试用户名，参数根据实际情况变动
        //String password = "log_analyzer"; // 测试密码，参数根据实际情况变动
        String password = ""; // 测试密码，参数根据实际情况变动

        //ResultSet rs = statement.executeQuery("SELECT distinct_id FROM event_1 LIMIT 10"); // event_3 表必须存在于insight数据库中
        String sql = "SELECT * FROM nginx_access where dt = '20190716'  LIMIT 10";
        String sql2 = "select row_number() over (order by env) from environment_desc ";
        String sql3 = "WITH data0 AS ( SELECT upper_app, upper_id, lower_app, lower_id FROM app_latency_relation WHERE dt >= '20190711' AND dt <= '20190716' GROUP BY upper_app, upper_id, lower_app, lower_id ), data1 AS ( SELECT upper_app AS app_name, upper_id AS app_id FROM data0 UNION SELECT lower_app AS app_name, lower_id AS app_id FROM data0 ), data2 AS ( SELECT a.app_name, a.app_id, b.upper_app AS upper_app, c.lower_app AS lower_app FROM data1 a LEFT JOIN data0 b ON a.app_name = b.lower_app LEFT JOIN data0 c ON a.app_name = c.upper_app ) SELECT app_name, app_id, count(DISTINCT upper_app) AS upper_app_cnt, count(DISTINCT lower_app) AS lower_app_cnt FROM data2 GROUP BY app_name, app_id";
        String sql4 = "select upper_app as app_name, upper_id as app_id, latency_times from (select upper_app, upper_id, sum(latency_times) as latency_times from app_latency_relation where dt >='20190711' and dt <='20190716' and lower_app = 'auxo-gateway' group by upper_app, upper_id ) a order by latency_times desc";
        String sql5 = "select lower_app as app_name, lower_id as app_id, b.creator_name, latency_times from (select lower_app, lower_id, sum(latency_times) as latency_times from app_latency_relation where dt >='20190711' and dt <='20190716' and upper_app = 'auxo-exam-service' group by lower_app, lower_id ) a join portal_app b on a.lower_id = b.app_id order by latency_times desc";
        String param = "8 or 1=1";
        String sql6 = "select * from environment_desc where env = " + param;
        int param2 = 8;
        String param3 = "product";
        String sql7 = "select * from environment_desc where env = ? and env_desc = ?";

        String sql8="select * from (With data0 as (select * from portal_app) select count(1) from data0) a where 1=1";

        String sql9="select * from log_analyzer.various_dimension_tb    where dt = '20200428' limit 10 ";

        Connection connection = DriverManager.getConnection(location, user, password);
//        Statement statement = connection.createStatement();
//        ResultSet rs = statement.executeQuery(sql6); // event_3 表必须存在于insight数据库中
        Statement statement = connection.createStatement();
//        statement.setObject(1, param2);
//        statement.setObject(2, param3);
        //String rsq = ((JDBC4PreparedStatement)statement).asSql();
        //System.out.println(statement.toString());
        ResultSet rs = statement.executeQuery(sql9);
//        while (rs.next()) {
//            System.out.println(rs.getRow());
//            System.out.println(rs.getString("http_host")); // distinct_id为event_3已存在的列
//           // System.out.println(rs.getString("distinct_id")); // distinct_id为event_3已存在的列
//        }
        List<Map<String, Object>> result = handle(rs);
        System.out.println(result);
        rs.close();
        statement.close();
        connection.close();
    }

    private static final String SQL_ALIAS_DELIMITER = ".";

    public static List<Map<String, Object>> handle(ResultSet rs) throws SQLException {
        if (rs == null) {
            return Collections.emptyList();
        }
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        ResultSetMetaData rsmd = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
        int columnCount = rsmd.getColumnCount(); // 返回此 ResultSet 对象中的列数
        while (rs.next()) {
            HashMap<String, Object> data = new HashMap<String, Object>();
            for (int i = 1; i <= columnCount; i++) {
                String column = rsmd.getColumnName(i);
                if (column.contains(SQL_ALIAS_DELIMITER)) {
                    String[] splited = StringUtils.split(column, SQL_ALIAS_DELIMITER);
                    column = new LinkedList<String>(Arrays.asList(splited)).getLast();
                }
                if (rsmd.getColumnType(i) == Types.ARRAY && rs.getArray(i) != null) {
                    data.put(column, (Object[]) (rs.getArray(i).getArray()));
                } else {
                    data.put(column, rs.getObject(i));
                }

            }
            list.add(data);
        }
        return list;

    }
}
