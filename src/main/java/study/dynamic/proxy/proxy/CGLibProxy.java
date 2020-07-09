package study.dynamic.proxy.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class CGLibProxy implements MethodInterceptor {
    private Object target;


    public Object createProxyObject(Object obj) {
        this.target = obj;
        Enhancer enhancer = new Enhancer();
        //这一步就是告诉cglib，生成的子类需要继承哪个类
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxyObj = enhancer.create();
        // 返回代理对象
        //第一步、生成源代码
        //第二步、编译成class文件
        //第三步、加载到JVM中，并返回被代理对象
        return proxyObj;
    }
    @Override
    public Object intercept(Object proxy, Method method, Object[] args,MethodProxy methodProxy) throws Throwable {
        Object obj = null;
        if (method.getName().equals("hungry")){
            log.info("has some time no eat");
        }
        obj = method.invoke(target, args);
        //这个obj的引用是由CGLib给我们new出来的
        //cglib new出来以后的对象，是被代理对象的子类（继承了我们自己写的那个类）
        //OOP, 在new子类之前，实际上默认先调用了我们super()方法的，
        //new了子类的同时，必须先new出来父类，这就相当于是间接的持有了我们父类的引用
        //子类重写了父类的所有的方法
        //我们改变子类对象的某些属性，是可以间接的操作父类的属性的
        //proxy.invokeSuper(obj, args);
        return obj;
    }
}
