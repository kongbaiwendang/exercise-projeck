package designmode.proxymode.cglib;

import designmode.proxymode.jdk.People;
import designmode.proxymode.jdk.Worker;

/**
 * @author wangyadong
 * 2018/10/31 11:40
 */
public class AboutCglibProxy {
    public static void main(String[] args) {
        WorkerProxy workerProxy = new WorkerProxy();
        People people = new Worker();
        People proxy = (People) workerProxy.getProxyInstance(people);
        proxy.walk();
        proxy.speak();
    }
}
