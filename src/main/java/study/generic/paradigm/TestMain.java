package study.generic.paradigm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @date: 14:46 2020/12/22
 * @author: Huang Bing
 * @modified by:
 * @modified cause:
 * @modified time:
 */
public class TestMain {
    static int countLegs (List<? extends Animal > animals ) {
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    static int countLegs1 (List< Animal > animals ){
        int retVal = 0;
        for ( Animal animal : animals )
        {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        // 不会报错
        countLegs( dogs );
        // 报错
        // countLegs1(dogs);
    }
}
