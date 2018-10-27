package annotation;

import com.sun.deploy.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HelperAnnotation {
    public static void analysisMethodAnnotation(Class cls){
        Method[] methods = cls.getMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(annotation.Method.class)){
                annotation.Method label = method.getAnnotation(annotation.Method.class);
                System.out.println("The class has method: "+method.getName()+
                        " The method desc is:"+label.value());
            }
        }
    }

    public static void analysisMyannotation(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.isAnnotationPresent(MyAnnotation.class)){
                System.out.println("The class has MyAnnotation field is: "+field.getName());
                MyAnnotation anno = field.getAnnotation(MyAnnotation.class);
                System.out.println("The field annotation desc is : "+ anno.desc());
                field.setAccessible(true);
                field.set(obj,anno.desc());
            }
        }
    }

    public static void analysisCaculate(Object obj) throws IllegalAccessException {

        Field[] fields = obj.getClass().getDeclaredFields();
        int x=0,y=0;
        String label = null;
        Field resultField = null;
        for(Field field : fields){
            if(field.isAnnotationPresent(ParamX.class)){
                ParamX paramX = field.getAnnotation(ParamX.class);
                x = paramX.value();
            }
            if(field.isAnnotationPresent(ParamY.class)){
                ParamY paramY = field.getAnnotation(ParamY.class);
                y = paramY.value();
            }
            if(field.isAnnotationPresent(Label.class)){
                Label lab = field.getAnnotation(Label.class);
                label = lab.value();
                if(label != null && !"+".equals(label) && !"-".equals(label)
                        && !"*".equals(label) && !"/".equals(label)){
                    throw new IllegalArgumentException("the label \""+label+"\" is unsupport!");
                }else if(label == null){
                    throw new IllegalArgumentException("the label  is null !");
                }
            }
            if(field.isAnnotationPresent(Result.class)){
                resultField = field;
            }
        }
        if(resultField == null){
            throw new IllegalArgumentException("The result annotation is undefined");
        }
        if("+".equals(label)){
            resultField.setAccessible(true);
            resultField.set(obj,x+y);
        }else if("-".equals(label)){
            resultField.setAccessible(true);
            resultField.set(obj,x-y);
        }else if("*".equals(label)){
            resultField.setAccessible(true);
            resultField.set(obj,x*y);
        }else if("-".equals(label)){
            resultField.setAccessible(true);
            resultField.set(obj,x/y);
        }
    }
}
