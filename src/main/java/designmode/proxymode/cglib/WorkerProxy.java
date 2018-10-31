package designmode.proxymode.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangyadong
 * 2018/10/31 11:28
 */
public class WorkerProxy implements MethodInterceptor {

    /**
     * 代理的业务对象
     */
    private Object target;

    public Object getProxyInstance(Object obj){
        this.target = obj;
        Enhancer enhancer = new Enhancer();//加强器
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行代理类预处理。。。");
        methodProxy.invokeSuper(o,null);
        System.out.println("完成代理类预处理。。。");
        return null;
    }
}
