package study.date;

import java.lang.management.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

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
        //PretenureSizeThreshold
        MemoryMXBean memorymbean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memorymbean.getHeapMemoryUsage();
        System.out.println("INIT HEAP: " + usage.getInit());
        System.out.println("MAX HEAP: " + usage.getMax());
        System.out.println("USE HEAP: " + usage.getUsed());
        System.out.println("\nFull Information:");
        System.out.println("Heap Memory Usage: "
                + memorymbean.getHeapMemoryUsage());
        System.out.println("Non-Heap Memory Usage: "
                + memorymbean.getNonHeapMemoryUsage());

        List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        System.out.println("===================java options=============== ");
        System.out.println(inputArguments);



        System.out.println("=======================通过java来获取相关系统状态============================ ");
        int i = (int)Runtime.getRuntime().totalMemory()/1024;//Java 虚拟机中的内存总量,以字节为单位
        System.out.println("总的内存量 i is "+i);
        int j = (int)Runtime.getRuntime().freeMemory()/1024;//Java 虚拟机中的空闲内存量
        System.out.println("空闲内存量 j is "+j);
        System.out.println("最大内存量 is "+Runtime.getRuntime().maxMemory()/1024);

        System.out.println("=======================OperatingSystemMXBean============================ ");
        OperatingSystemMXBean osm = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
//    System.out.println(osm.getFreeSwapSpaceSize()/1024);
//    System.out.println(osm.getFreePhysicalMemorySize()/1024);
//    System.out.println(osm.getTotalPhysicalMemorySize()/1024);

        //获取操作系统相关信息
        System.out.println("osm.getArch() "+osm.getArch());
        System.out.println("osm.getAvailableProcessors() "+osm.getAvailableProcessors());
        //System.out.println("osm.getCommittedVirtualMemorySize() "+osm.getCommittedVirtualMemorySize());
        System.out.println("osm.getName() "+osm.getName());
        //System.out.println("osm.getProcessCpuTime() "+osm.getProcessCpuTime());
        System.out.println("osm.getVersion() "+osm.getVersion());
        //获取整个虚拟机内存使用情况
        System.out.println("=======================MemoryMXBean============================ ");
        MemoryMXBean mm=(MemoryMXBean)ManagementFactory.getMemoryMXBean();
        System.out.println("getHeapMemoryUsage "+mm.getHeapMemoryUsage());
        System.out.println("getNonHeapMemoryUsage "+mm.getNonHeapMemoryUsage());
        //获取各个线程的各种状态，CPU 占用情况，以及整个系统中的线程状况
        System.out.println("=======================ThreadMXBean============================ ");
        ThreadMXBean tm=(ThreadMXBean)ManagementFactory.getThreadMXBean();
        System.out.println("getThreadCount "+tm.getThreadCount());
        System.out.println("getPeakThreadCount "+tm.getPeakThreadCount());
        System.out.println("getCurrentThreadCpuTime "+tm.getCurrentThreadCpuTime());
        System.out.println("getDaemonThreadCount "+tm.getDaemonThreadCount());
        System.out.println("getCurrentThreadUserTime "+tm.getCurrentThreadUserTime());

        //当前编译器情况
        System.out.println("=======================CompilationMXBean============================ ");
        CompilationMXBean gm=(CompilationMXBean)ManagementFactory.getCompilationMXBean();
        System.out.println("getName "+gm.getName());
        System.out.println("getTotalCompilationTime "+gm.getTotalCompilationTime());

        //获取多个内存池的使用情况
        System.out.println("=======================MemoryPoolMXBean============================ ");
        List<MemoryPoolMXBean> mpmList=ManagementFactory.getMemoryPoolMXBeans();
        for(MemoryPoolMXBean mpm:mpmList){
            System.out.println("getUsage "+mpm.getUsage());
            System.out.println("getMemoryManagerNames "+mpm.getMemoryManagerNames().toString());
        }
        //获取GC的次数以及花费时间之类的信息
        System.out.println("=======================MemoryPoolMXBean============================ ");
        List<GarbageCollectorMXBean> gcmList=ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean gcm:gcmList){
            System.out.println("getName "+gcm.getName());
            System.out.println("getMemoryPoolNames "+gcm.getMemoryPoolNames());
        }
        //获取运行时信息
        System.out.println("=======================RuntimeMXBean============================ ");
        RuntimeMXBean rmb=(RuntimeMXBean)ManagementFactory.getRuntimeMXBean();
        System.out.println("getClassPath "+rmb.getClassPath());
        System.out.println("getLibraryPath "+rmb.getLibraryPath());
        System.out.println("getVmVersion "+rmb.getVmVersion());

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

        System.out.println("LocalTime.MIN()演示：");
        System.out.println("LocalTime获取小时："+LocalTime.MIN.getHour());
        System.out.println("LocalTime获取分钟："+LocalTime.MIN.getMinute());
        System.out.println("LocalTime获取秒："+LocalTime.MIN.getSecond());


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
