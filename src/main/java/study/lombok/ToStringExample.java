package study.lombok;

import lombok.ToString;

import java.awt.*;

/**
 * @Author LynHB
 * @Description : ToString注解测试
 * @Date 13:26 2020/6/25
 **/
@ToString
public class ToStringExample {
    private static final int STATIC_VAR = 10;
    private String name;
    private Shape shape = new Square(5, 10);
    private String[] tags;
    @ToString.Exclude private int id;

    public String getName() {
        return this.name;
    }

    public static class Shape{

    }

    @ToString(callSuper=true, includeFieldNames=true)
    public static class Square extends Shape {
        private final int width, height;

        public Square(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
