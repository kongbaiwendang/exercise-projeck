package genericity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DriverGenericity {

    @Test
    public void testGenericity(){
        AboutGenericity<Integer> testGenericityEntry = new AboutGenericity<>();
        testGenericityEntry.setElement(new Integer(111));

        Integer[] intArr = new Integer[10];
        intArr[0] = 1;
        intArr[1] = 2;
        testGenericityEntry.setEleArray(intArr);

        System.out.println(testGenericityEntry.getElement());
        System.out.println(Arrays.toString(testGenericityEntry.getEleArray()));
        System.out.println(testGenericityEntry.getEleArray().length);
    }
}
