package annotation;

import org.junit.jupiter.api.Test;

public class AboutAnnotation {

    @Test
    public void testAnnotation() throws IllegalAccessException {
        HelperAnnotation.analysisMethodAnnotation(UseAnnotation.class);
        UseAnnotation useAnnotation = new UseAnnotation();
        HelperAnnotation.analysisMyannotation(useAnnotation);
        System.out.println("new 出的对象中的desc属性值被注解赋值为: "+useAnnotation.getDesc());
    }

    @Test
    public void testSimpleCaculate() throws IllegalAccessException {
        CalculateUseAnnotation calculateUseAnnotation = new CalculateUseAnnotation();
        HelperAnnotation.analysisCaculate(calculateUseAnnotation);
        System.out.println("The annotation caculate result is :" + calculateUseAnnotation.getResult());
    }
}
