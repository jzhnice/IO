package Demo03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-13 17:31
 */

//实现文件的赋值
public class Demo02 {
    public static void main(String[] args) {

        FileInputStream fi = null;
        FileOutputStream fo = null;

        try {
            // 1：准备输入输出流
            fi = new FileInputStream("E:\\python-3.9.4-amd64.exe");
            fo = new FileOutputStream("E:\\hhhhhhhggggqqqqAA123213Ss.exe");
            // 文件在穿之前不能有

            int len = 0;
            byte[] b = new byte[1024];
            long starTime =System.currentTimeMillis();
            while ((len = fi.read(b)) != -1) {
                ;
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime-starTime);
            // 用时47毫秒
        } catch (IOException e) {
            System.out.println("文件路径不存在");
        }
        try {
            fi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
