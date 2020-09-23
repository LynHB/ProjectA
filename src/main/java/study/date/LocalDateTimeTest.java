package study.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @description:
 * @date: 9:17 2020/9/23
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class LocalDateTimeTest {
    public static void main(String[] args){

        /*
            LocalDate为日期处理类
         */
        System.out.println("LocalDate演示：");
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate打印:"+localDate);
        System.out.println("LocalDate获取年:"+localDate.getYear());
        System.out.println("LocalDate获取月："+localDate.getMonthValue());
        System.out.println("LocalDate获取日："+localDate.getDayOfMonth());
        System.out.println("LocalDate获取周几："+localDate.getDayOfWeek().getValue());
        System.out.println("LocalDate获取周（英文）："+localDate.getDayOfWeek().name());

        /*
            LocalTime为时间处理类
         */
        System.out.println("LocalTime演示：");
        LocalTime localTime = LocalTime.now();
        System.out.println("LocalTime获取小时："+localTime.getHour());
        System.out.println("LocalTime获取分钟："+localTime.getMinute());
        System.out.println("LocalTime获取秒："+localTime.getSecond());

        /*
            LocalDateTime等同于LocalDate+LocalTime
         */
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime演示：");
        System.out.println("LocalDateTime获取年："+localDateTime.getYear());
        System.out.println("LocalDateTime获取月："+localDateTime.getMonthValue());
        System.out.println("LocalDateTime获取日："+localDateTime.getDayOfMonth());
        System.out.println("LocalDateTime获取周几："+localDateTime.getDayOfWeek().getValue());
        System.out.println("LocalDateTime获取周（英文）："+localDateTime.getDayOfWeek().name());
        System.out.println("LocalDateTime获取小时："+localDateTime.getHour());
        System.out.println("LocalDateTime获取分钟："+localDateTime.getMinute());
        System.out.println("LocalDateTime获取秒："+localDateTime.getSecond());

        /*
            Instant对象
         */
        Instant instant = Instant.now();
        System.out.println("Instant演示：");
        System.out.println("Instant获取秒数："+instant.getEpochSecond());
        System.out.println("Instant获取毫秒数："+instant.toEpochMilli());


        /*
            针对LocalDateTime进行
         */
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("针对LocalDateTime进行修改转换：");
        System.out.println("LocalDateTime减少一年："+localDateTime1.minus(1, ChronoUnit.YEARS));
        System.out.println("LocalDateTime增加一月："+localDateTime1.plusMonths(1));
        System.out.println("LocalDateTime修改成固定年2011："+localDateTime1.withYear(2011));

        /*
            字符串转LocalDateTime
         */
        String dateStr = "2020-01-02 11:11:11";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        localDateTime = LocalDateTime.parse(dateStr,dtf);
        System.out.println("LocalDateTime针对20200101字符串进行格式化成时间：");
        /*
            LocalDateTime转字符串
         */
        dateStr = localDateTime.format(dtf);

        /*
            LocalDateTime 转 Date
         */
        localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneOffset.ofHours(8)).toInstant());

        /*
            localDateTime 转 时间戳
         */
        localDateTime = LocalDateTime.now();
        long timestamp = localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();

        /*
            时间戳 转 LocalDateTime
         */
        timestamp = System.currentTimeMillis();
        localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        /*
            localDate 转 localDateTime
         */
        localDateTime = LocalDateTime.of(localDate,LocalTime.MIN);
    }
}
