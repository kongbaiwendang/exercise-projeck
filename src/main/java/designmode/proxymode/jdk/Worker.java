package designmode.proxymode.jdk;

/**
 * @author wangyadong
 * 2018/10/30 19:01
 * 定义work对象
 *
 */
public class Worker implements People {
    private String name;
    private int age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void walk() {
        System.out.println("worker 走路上班。。");
    }

    @Override
    public String speak() {
        System.out.println("worker 说我不能迟到！");
        return "worker说我要发言。";
    }
}
