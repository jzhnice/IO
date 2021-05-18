package Demo05;

import java.io.*;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-17 10:16
 */
public class Demo01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setName("张三");
        user.setAge(23);

        System.out.println(user);
        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
        oos.writeObject(user);

        //反序列化
        InputStream in;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tempFile"));
        Object u  = (User)ois.readObject();
        System.out.println(u);
    }
}
