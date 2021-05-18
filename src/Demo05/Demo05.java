package Demo05;

import org.w3c.dom.ls.LSOutput;

import java.io.*;


/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-17 08:19
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("E:\\123455.txt"));
        //  输入流
        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\hhhhhhhggggqqqqAA123213Ss.txt"));
        // 输出流

        int len ;

        char[] buffer = new char[1024];   //  缓冲数组
        long start = System.currentTimeMillis() ;
        // 获取程序执行前的时间戳
        while ((len = reader.read(buffer)) != -1) {
            //  int  read(byte[] b)  将数据读取到字节数组中
            writer.write(buffer, 0, len);
            //  int write(  byte [] b,    int off,   int len)  将从off位置开始的长度为len的字节数据输出到输出流中
        }


        writer.flush ();   //  刷新一下
        long end = System.currentTimeMillis();
        // 结束时间戳
        System.out.println("时间："+(end-start));
        //  获取程序运行时间
        reader.close();
        writer.close();


    }
}
