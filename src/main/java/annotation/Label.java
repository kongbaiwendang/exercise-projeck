package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Label {
    /**
     * 运算符号，仅限+ - * / 四种
     * @return
     */
    public String value();
}
