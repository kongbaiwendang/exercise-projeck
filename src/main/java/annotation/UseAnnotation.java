package annotation;

public class UseAnnotation {
    @MyAnnotation(desc="使用注解描述赋值")
    private String desc;


    @Method("方法描述")
    public int calculate(int a,int b){
        return a+b;
    }

    public String getDesc() {
        return desc;
    }
}
