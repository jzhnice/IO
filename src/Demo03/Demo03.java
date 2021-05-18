package Demo03;

import java.io.*;
import java.util.Date;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-13 17:31
 */


//实现文件的赋值
public class Demo03 {
    public static void main(String[] args) {

        BufferedInputStream fi = null;
        BufferedOutputStream fo = null;

        try {
            // 1：准备输入输出流
            fi = new BufferedInputStream(new FileInputStream("E:\\GitHubDesktopSetup-x64.exe"));
            fo = new BufferedOutputStream(new FileOutputStream("E:\\hh.exe"));
            // 文件在穿之前不能有

            int len = 0;
            byte[] b = new byte[1024];
            long starTime =System.currentTimeMillis();
            while ((len = fi.read(b)) != -1) {
                fo.write(b);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime-starTime);
            // 用时17毫秒
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
