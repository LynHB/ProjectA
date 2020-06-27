package study.lombok;

import lombok.*;

/**
 * @Author LynHB
 * @Description : Lombok @NonNull注解测试
 * @Date 20:23 2020/6/24
 **/
public class NonNullExample {

    @Getter
    @Setter
    @Data
    public static class Person{

        @NonNull
        private String name;
        private int age;
    }

    public void testPersonIsNull(Person person){
        System.out.println(person.getName());
    }

    public static void  main(String[] args){
        NonNullExample nonNullAnnotation = new NonNullExample();
        Person person = new Person(null);
        nonNullAnnotation.testPersonIsNull(person);
    }
}
