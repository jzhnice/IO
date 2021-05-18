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
 * OSI模型  七层
 * 应用层            为应用程序提供服务
 * 表示层               数据格式转化，
 * 会话层           建立 管理和维护会话
 * <p>
 * <p>
 * 传输层   ：  四层交换机、                  建立 股那里和维护端到端的链接      TCP   UDP
 * 网络层   ： 路由器                 IP选址及路由选择                  IP   ICMP   RIP
 * 数据链路层   网桥 以太网交换机            提供介质的访问和链路管理               ARP  RARP
 * 物理层   中继器  集线网  双绞线               物理设备
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
