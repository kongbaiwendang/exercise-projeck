package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ParamY {
    /**
     * 定义运算中的第二位
     * @return
     */
    int value();
}
