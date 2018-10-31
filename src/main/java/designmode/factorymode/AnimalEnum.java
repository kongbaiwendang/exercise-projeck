package designmode.factorymode;

/**
 * @author wangyadong
 * 2018/10/31 14:52
 */
public enum AnimalEnum {
    CHICKEN(1,"鸡"),
    PIG(2,"猪");
    private int type;
    private String desc;

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    private AnimalEnum(int type, String desc){
        this.type = type;
        this.desc = desc;
    }
}
