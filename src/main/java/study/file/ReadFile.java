package study.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description
 * @Date 13:36 2021/4/15
 * @Author Huang Bing
 */
public class ReadFile {
    public static void main(String[] args){
        String pathName = "D:\\桌面\\user-disk-sla.txt";

        Double sum = 0.0;
        try(FileReader reader = new FileReader(pathName);
            BufferedReader br = new BufferedReader(reader)){
            String line;
//           按行读取数据
            while ((line = br.readLine()) != null){
                if(Double.parseDouble(line.split("\\s+")[4])<99.5){
                    System.out.println(line);
                }
                sum += Double.parseDouble(line.split("\\s+")[4]);
            }
            System.out.println(sum/288);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
