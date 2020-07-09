package study.dynamic.proxy.main;

import study.dynamic.proxy.entity.Baby;
import study.dynamic.proxy.entity.IPerson;
import study.dynamic.proxy.proxy.CGLibProxy;
import study.dynamic.proxy.proxy.PersonProxy;

public class CGLibMain {
    public static void main(String[] args){
        CGLibProxy cgLibProxy = new CGLibProxy();
        IPerson baby =(IPerson) cgLibProxy.createProxyObject(new Baby());
        baby.hungry();
        baby.eat("watermelon");

    }
}
