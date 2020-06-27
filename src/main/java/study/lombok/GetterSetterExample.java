package study.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author LynHB
 * @Description : Getting Setting方法demo
 * @Date 22:48 2020/6/24
 **/
public class GetterSetterExample {
    @Getter
    @Setter
    private int age = 10;
    @Setter(AccessLevel.PROTECTED) private String name;

    @Override public String toString() {
        return String.format("%s (age: %d)", name, age);
    }
}
