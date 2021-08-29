package study.asm;

public class HelloWorld {

    private String name;
    private int age;

    public HelloWorld(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void test(long idCard, Object obj) {
        int hashCode = 0;
        hashCode += name.hashCode();
        hashCode += age;
        hashCode += (int) (idCard % Integer.MAX_VALUE);
        hashCode += obj.hashCode();
        hashCode = Math.abs(hashCode);
        System.out.println("Hash Code is " + hashCode);
        if (hashCode % 2 == 1) {
            throw new RuntimeException("illegal");
        }
    }

    public static void main(String[] args){
        System.out.println("Hello World");
    }
}
