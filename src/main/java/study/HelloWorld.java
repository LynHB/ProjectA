package study;

import com.sun.javafx.binding.StringFormatter;
import org.apache.commons.lang3.time.DateUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.regex.Pattern;

public class HelloWorld {

    public static void main(String[] args) throws ParseException {


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate occurLocalDate = LocalDate.parse("2021-11-12 12:00:12",dtf);
        System.out.println(occurLocalDate.getDayOfMonth());

        System.out.println(LocalDateTime.now().minusDays(45).atZone(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
        System.out.println(String.format("查询oncall接口调用异常！%s(%d)", "dsa",1));
        System.out.println("dsjjkjj kd".replaceAll("\\s+","").replaceAll("'","").replaceAll("\"",""));
        System.out.println(LocalDate.now().atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli());
        Character character = 1;
        System.out.println(character);
        // 创建一个 HashMap
        HashMap<String, Integer> prices = new HashMap<>();

        // 往HashMap中添加映射项
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("HashMap: " + prices);

        // 计算 Shirt 的值
        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Price of Shirt: " + shirtPrice);

        // 输出更新后的HashMap
        System.out.println("Updated HashMap: " + prices);


        StringJoiner executionDependIds = new StringJoiner(",");
        System.out.println(executionDependIds.toString());
        executionDependIds.add("a").add("b");
        System.out.println(executionDependIds.toString());
        String[] split = executionDependIds.toString().split(",");
        for(String s: split){
            System.out.println(s);
        }

        LocalDate local = LocalDate.now().minusDays(1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        System.out.println(local.format(dateTimeFormatter));

        double d = 0.1415926;
        DecimalFormat df = new DecimalFormat("#.#####");
        Double get_double = Double.parseDouble(df.format(d));
        System.out.println(get_double);

        LocalDate localDate = LocalDate.now();
        long timestamp = LocalDate.now().atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter dateTimeHourFormatter = DateTimeFormatter.ofPattern("yyyyMMddHH");
        System.out.println(localDateTime.format(dateFormatter));
        System.out.println(localDateTime.format(dateTimeHourFormatter));



        String s = "1234";
        change(s,(String str)->{
            return Integer.parseInt(str);
        });
    }

    public static void change(String s, Function<String,Integer> fun){
        Integer i = fun.apply(s);
        System.out.println(i);
    }
}
