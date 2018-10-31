package designmode.factorymode;

/**
 * @author wangyadong
 * 2018/10/31 14:44
 * 工厂类
 */
public class AnimalFactory {

    public static Animal getAnimalFactory(AnimalEnum type){
        switch (type){

            case CHICKEN:
                return new Chicken();
            case PIG:
                return new Pig();
                default:
                    return null;
        }

    }
}
