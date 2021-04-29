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


        System.out.println( "select " +
                "app,env,minute_timestamp," +
                "status_5xx_pv," +
                "gt_one_s," +
                "outside_status_5xx_pv,outside_status_4xx_pv,outside_status_404_pv,outside_gt_one_s,outside_gt_five_s,outside_total_pv," +
                "total_pv ,all_total_pv,all_status_5xx_pv,all_outside_gt_one_s, "
                + "round((1 - (if(total_pv != 0,if(status_5xx_pv + gt_one_s > total_pv, 1, (status_5xx_pv + gt_one_s)/total_pv),0)))*100, 4) as five_minute_sla "
                +" from "
                + " (select "
                + "httpHost as app,"
                + "env,"
                + "minute_timestamp, "
                + "COUNT(case when status like '5%' and statistic = 0 and component_inside = 0 then 1 else null END) as status_5xx_pv,"
                + "COUNT(case when request_time > 1 and statistic = 0 and component_inside = 0 then 1 else null END) as gt_one_s,"
                + "COUNT(case when status like '5%' and component_inside = 0 then 1 else null END) as outside_status_5xx_pv,"
                + "COUNT(case when status like '4%' and component_inside = 0 then 1 else null END) as outside_status_4xx_pv,"
                + "COUNT(case when status = '404' and component_inside = 0 then 1 else null END) as outside_status_404_pv,"
                + "COUNT(case when nginx_request_time > 1 and  component_inside = 0 then 1 else null END) as outside_gt_one_s,"
                + "COUNT(case when nginx_request_time > 5 and component_inside = 0 then 1 else null END) as outside_gt_five_s,"
                + "COUNT(case when component_inside = 0 then 1 else null END) as outside_total_pv,"
                + "COUNT(case when statistic = 0 and component_inside = 0 then 1 else null END ) as total_pv,"
                + "COUNT(1) as all_total_pv,"
                + "COUNT(case when status like '5%' then 1 else null END) as all_status_5xx_pv,"
                + "COUNT(case when nginx_request_time > 1 and  component_inside = 0 then 1 else null END) as all_outside_gt_one_s"
                + " from ( "
                + " select httpHost, env, status, floor(localTimestamp/300)*300 as minute_timestamp,"
                + " if(slowFlag = '0', upstreamResponseTime, null) as request_time,"
                + " if(slowFlag = '0', requestTime, null) as nginx_request_time,"
                + " statistic, componentInside as component_inside"
                + " from sla_tmp"
                + " ) a "
                + " group by httpHost, env, minute_timestamp ) b");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date beginDate = sdf.parse("20210301");
        Date endDate = sdf.parse("20210415");
        long oneDate = 3600L*1000L*24;
        for(long i = endDate.getTime();i>=beginDate.getTime();i=i-oneDate){
            Date date = new Date(i);
            System.out.println(sdf.format(date));
        }


        String aaa  = "Waf/2.9.16 WafClient/elearning-library-gateway WafClient/elearning-library-gateway";
        String[] userAgentArr = aaa.split("/");
        System.out.println(userAgentArr[userAgentArr.length-1].trim());

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
