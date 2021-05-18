package Demo05;

import java.io.*;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-17 10:29
 */

//OSI  模型
    // 中继器   无线的传输  信号中转转
//    集线器    有好多跟网线插在上面


/**
 * tesr1
 * OSI模型
 * 应用层
 * 表示层
 * 会话层
 * <p>
 * <p>
 * 传输层   ：  四层交换机、
 * 网络层
 * 数据链路层
 * 物理层
 * <p>
 * <p>
 * <p>
 * <p>
 * TCP/IP五层模型
 * 应用层
 * 传输层
 * 网络层
 * 数据链路层
 * 物理层
 *
 * @author jzh
 * @date 2021/05/17
 */
public class tesr1 {
    public static void main(String[] args) throws Exception {

        //  序列化
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("temp"));
        User1 user1 = new User1("小艾",18);
        oos.writeObject(user1);


        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp"));
        User1 u1 = (User1) ois.readObject();
        System.out.println(u1);
    }
}
