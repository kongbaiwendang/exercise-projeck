package designmode.singlemode;

/**
 * @author wangyadong
 * 2018/10/31 11:47
 * 线程安全且简单的单例模式
 */
public class SingleMode {
    private SingleMode(){}
    public static SingleMode getSingleInstance(){
        return innerSingle.singleMode;
    }
    private static class innerSingle{
        public final static SingleMode singleMode = new SingleMode();
    }
}
