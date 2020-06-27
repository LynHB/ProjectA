package study;

public class HelloWorld {
    public static void main(String[] args){
        int a = 10;
        int b = 5;
        // 1 ^ 0 = 1   1 ^ 0 = 1
        // 1 ^ 0 = 1   1 ^ 1 = 0

        // a ^ b ^ b = a
        a = a ^ b;
        // b = a ^ b ^ b
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }
}
