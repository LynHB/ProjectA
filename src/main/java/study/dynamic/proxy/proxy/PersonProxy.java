package study.dynamic.proxy.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author LynHB
 * @Description : 代理类
 * @Date 23:53 2020/7/8
 **/
@Slf4j
public class PersonProxy implements InvocationHandler {
    private Object target;

    public void setTarget(Object o){
        this.target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("invoke {} function",method.getName());
        return method.invoke(target,args);
    }

    /**
     * @Description : 生产代理类
     * @Date 0:01 2020/7/9
     * @return java.lang.Object
     **/
    public Object createProxyObj(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
