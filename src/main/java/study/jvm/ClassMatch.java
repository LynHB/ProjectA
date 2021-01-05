package study.jvm;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @description:
 * @date: 14:36 2020/10/9
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class ClassMatch {

    /**
     * 读取jar包类的class路径，不返回内部类和结尾的.class
     * @param:
     * @return:
     * @author: Huang Bing
     * @date: 2020/10/9 16:23
     */
    public static List<String> readJarClass(String jarPath) throws IOException {
        List<String> classNames = new ArrayList<>();
        ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
        for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
            if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                String className = entry.getName().replace('/', '.');
                if(!className.contains("$")){
                    classNames.add(className.substring(0, className.length() - ".class".length()));
                }
            }
        }
        return classNames;
    }

    public static List<String> readWarClass(String warPath) throws IOException {
        List<String> classNames = new ArrayList<String>();
        ZipInputStream zip = new ZipInputStream(new FileInputStream(warPath));
        for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
            if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                String className = entry.getName().replace('/', '.');
                className =  className.split("WEB-INF.classes.")[1];
                if(!className.contains("$")){
                    classNames.add(className.substring(0, className.length() - ".class".length()));
                }
            }
        }
        return classNames;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = readWarClass("D:\\apache-tomcat-8.5.57-windows-x64\\apache-tomcat-8.5.57\\webapps\\unified_monitor-1.17.0.war");
        String regex = "com.nd.sdp.umonitor.common.*.faultsolver.*";
        List<String> res = list.stream().filter($ -> $.matches(regex)).collect(Collectors.toList());
        // readJarClass("D:\\IDEA_Project\\pinpoint\\agent\\target\\pinpoint-agent-1.8.3\\pinpoint-bootstrap-1.8.3.jar");

        List<Integer> nums = Lists.newArrayList(1,2,3,1,10,2,3,10,10);

        try{
            Map<Integer,Integer> map2 =  nums.stream().map(num -> {
                return new ImmutablePair<Integer,Integer>(num,1);
            }).collect(Collectors.toMap(pair -> pair.left,pair -> pair.right));
            System.out.println(map2);
        }catch (Exception ex){

        }


        return;
    }
}
