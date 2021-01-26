package study;

import org.apache.commons.lang3.time.DateUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.*;

public class HelloWorld {
    public static void main(String[] args){
        LocalDate local = LocalDate.now();
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




    }
}
