package designmode.proxymode.jdk;


/**
 * @author wangyadong
 * 2018/10/31 10:00
 */
public class AboutDynamicProxy {
    public static void main(String[] args) {
        ProxyRole proxyRole = new ProxyRole();
        People worker = (People)proxyRole.getRealInstance(new Worker());
        worker.walk();
        worker.speak();
        System.out.println("程序退出！！");
    }
}
