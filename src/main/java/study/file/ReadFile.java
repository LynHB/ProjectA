package study.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringJoiner;
import java.util.regex.Pattern;

/**
 * @Description
 * @Date 13:36 2021/4/15
 * @Author Huang Bing
 */
public class ReadFile {
    public static void main(String[] args){
        String pathName = "D:\\桌面\\part-00000";
        String queryAppId = "5db935557cea8200101a7644";
        try(FileReader reader = new FileReader(pathName);
            BufferedReader br = new BufferedReader(reader)){
            String line;
            System.out.println("应用ID\t秒级时间戳\t总PV\t统计生效PV(去除组件内，豁免)\t总5xx\t统计生效5xx\t组件外总慢请求\t统计生效慢请求（去除组件内，豁免）\t可用性");
            Double sum = 0.0;
            while ((line = br.readLine()) != null){
                String[] lines = line.split("\\s+");
                String appId = lines[0];

                StringJoiner stringJoiner = new StringJoiner("\t");
                stringJoiner.add(lines[0]).add(lines[2]).add(lines[12]).add(lines[11]).add(lines[13]).add(lines[3]).add(lines[8]).add(lines[4]).add(lines[15]);
                if(queryAppId.equals(appId) && Long.parseLong(lines[2])>=1619076600 && Long.parseLong(lines[2])<=1619078100){
                    sum+=100;



                }else if(queryAppId.equals(appId)){
                    sum+=Double.parseDouble(lines[15]);
                }

            }
            System.out.println(sum/288);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
