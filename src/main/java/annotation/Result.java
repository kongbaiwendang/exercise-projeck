package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Result {
    /**
     * 运行结果
     * @return
     */
    public int value() default 0;
}
