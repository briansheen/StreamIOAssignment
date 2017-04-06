import java.io.Serializable;

/**
 * Created by bsheen on 4/6/17.
 */
public class Child implements Serializable{

    private String name;
    private int age;
    private transient int max;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", max=" + max +
                '}';
    }
}
