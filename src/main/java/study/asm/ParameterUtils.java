package study.asm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ParameterUtils {
    private static final DateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void printValueOnStack(Object value) {
        if (value == null) {
            System.out.println("    " + value);
        }
        else if (value instanceof String) {
            System.out.println("    " + value);
        }
        else if (value instanceof Date) {
            System.out.println("    " + fm.format(value));
        }
        else if (value instanceof char[]) {
            System.out.println("    " + Arrays.toString((char[])value));
        }
        else {
            System.out.println("    " + value.getClass() + ": " + value.toString());
        }
    }

    public static void printText(String str) {
        System.out.println(str);
    }
}
