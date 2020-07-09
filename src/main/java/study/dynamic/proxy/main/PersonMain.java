package study.dynamic.proxy.main;

import study.dynamic.proxy.entity.Baby;
import study.dynamic.proxy.entity.IPerson;
import study.dynamic.proxy.proxy.PersonProxy;

public class PersonMain {
    public static void main(String[] args){
        // 创建原始对象
        IPerson baby = new Baby();

        // 设置代理类，将原始对象传入
        PersonProxy personProxy = new PersonProxy();
        personProxy.setTarget(baby);

        // 从代理类中获取对应的对象，进行方法调用
        IPerson person = (IPerson) personProxy.createProxyObj();
        person.hungry();
        person.eat("watermelon");

    }
}
