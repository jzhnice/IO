package Demo05;

import java.beans.Transient;
import java.io.Serializable;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-17 10:11
 */

public class User implements Serializable {
    private  static  final long serialVersionUID = 1L;
    private  String name;
//    @Transient
    public int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
    

    @Override
    public String toString() {
        return "Serializable{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
