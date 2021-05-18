package Demo05;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-17 09:15
 */
public class Demo06 {
    public static void main(String[] args) throws IOException {
        // 1  ：  用输入流指向硬盘文件
        BufferedInputStream fi = new BufferedInputStream(new FileInputStream("a.Properties"));
        // 2：工具类
        Properties pro=new Properties();
        // 3： jdk中的工具类和输入流挂钩
        pro.load(fi);
        fi.close();
        // 4:访问其中的值
        for (Map.Entry<Object, Object> e:pro.entrySet()) {
            System.out.println(e);
        }

        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("a.Properties",false));
        pro.setProperty("height","188");
        pro.store(bos,"新添加了身高");
        bos.close();
    }
}
