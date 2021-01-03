package study;

import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.*;

public class HelloWorld {

    int a = 0;
    boolean flag = false;

    public void write(){
        a = 2;
        flag = true;
    }

    public int read(){
        int res = -1;
        if(flag){
            res = a*a;
        }
        return res;
    }

    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap<Integer, Integer>();
        for(int i =0;i<1000000;i++){
            HelloWorld helloWorld = new HelloWorld();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    helloWorld.write();
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    if(helloWorld.read()==0){
                        System.out.println("0");
                    }

                }
            });
            thread.start();
            thread2.start();
        }

        return;

    }
}
