package designmode.factorymode;

/**
 * @author wangyadong
 * 2018/10/31 14:50
 */
public class Chicken extends Animal{
    public Chicken(){
        this.leg = 2;
    }
    @Override
    public String call() {
        return "ge,ge,ge,ge,geda...";
    }
}
