package study.asm;

public class HelloWorld {
    public static void main(String[] args){
        if(Long.parseLong(args[0])>Long.parseLong(args[1])){
            System.out.println("aaa");
        }else{
            System.out.println("bbb");
        }
        System.out.println("Hello World");
    }
}
