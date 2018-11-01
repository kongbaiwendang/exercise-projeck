package designmode.factorymode;

import java.util.concurrent.locks.Condition;

/**
 * @author wangyadong
 * 2018/10/31 15:03
 */
public class AboutFactoryMode {
    public static void main(String[] args) {
        Animal animal = AnimalFactory.getAnimalFactory(AnimalEnum.CHICKEN);
        System.out.println("the animal leg is "+animal.leg+", and call is "+animal.call());
        animal = AnimalFactory.getAnimalFactory(AnimalEnum.PIG);
        System.out.println("the animal leg is "+animal.leg+", and call is "+animal.call());
    }
}
