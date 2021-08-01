package study;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.regex.Pattern;

public class HelloWorld {

    public static void main(String[] args) throws ParseException {

        LocalDate localDate = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String thirtyDay = localDate.minusDays(30).format(dtf);
        System.out.println(thirtyDay);

        Map<String, HashMap<String,String>> map = new HashMap();

    }


}
