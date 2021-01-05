package study.jvm;

import java.lang.reflect.Field;
import java.util.Vector;

/**
 * @description:
 * @date: 16:45 2020/10/9
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class ClassLoad {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ClassLoader classLoad = Thread.currentThread().getContextClassLoader();

        System.out.println(    System.getProperty("java.class.path"));
        Field f =  ClassLoader.class.getDeclaredField("classes");
        f.setAccessible(true);
        Vector<Class> classes = (Vector) f.get(classLoad);

        for(Class clazz : classes){
            System.out.println(clazz.getName());
        }
        return;
    }
}
