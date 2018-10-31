package designmode.proxymode.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangyadong
 * 2018/10/30 19:10
 */
public class ProxyRole implements InvocationHandler {

    private People people;
    public Object getRealInstance(People object){
        this.people = object;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),new Worker().getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理对象开始运行，AOP基于代理实现");
        System.out.println("代理对象可以对原对象进行加工处理，改变原始逻辑。");
        method.invoke(people,null);
        System.out.println("代理对象执行完成...");
        return null;
    }
}
