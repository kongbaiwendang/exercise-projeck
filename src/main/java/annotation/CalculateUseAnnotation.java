package annotation;

public class CalculateUseAnnotation {
    @ParamX(10)
    private int a;
    @ParamY(50)
    private int b;
    @Label("+")
    private String label;
    @Result
    private int result;

    public int getResult() {
        return result;
    }
}
