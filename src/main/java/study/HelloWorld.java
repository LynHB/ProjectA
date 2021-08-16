package study;


import java.lang.invoke.LambdaMetafactory;

public class HelloWorld {

    public static void main(String[] args) {
        Runnable runnable = ()-> System.out.println("Hello lambda");
        runnable.run();
    }
}
