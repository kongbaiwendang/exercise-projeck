package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ParamX {
    /**
     * 定义运算中的第一位
     * @return
     */
    int value();
}
