package designmode.factorymode;

/**
 * @author wangyadong
 * 2018/10/31 14:48
 */
public class Pig extends Animal {
    public Pig(){
        this.leg = 4;
    }
    @Override
    public String call() {
        return "eng,eng,eng...";
    }
}
