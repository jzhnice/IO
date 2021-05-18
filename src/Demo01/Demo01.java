package Demo01;

import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-12 11:00
 */
public class Demo01 {

//    让虚拟机处理一场
    public static void main(String[] args) throws IOException {
       File file =new File("E:\\classthree.txt");
        //  第一个斜杠  转移   第二个斜杠才是创建
        File file1= new File("e:/ three.txt");
        File File= new File("e:/demo02/demo01");
        File File3= new File("e:/ch010");

        try {
            file1.mkdirs();
            /*file.createNewFile();
            file1.createNewFile();
            File.mkdirs();  //  创建多层文件夹
            File3.mkdir();//  创建一层文件夹
            file1.delete();  //  删除一个文件
            File.delete();  // 删除为空的 那一级文件夹
            File3.renameTo(new File("e:/ch00000000000000000000000000010"));   修该文件路径*/
            System.out.println(file.exists());
            System.out.println(file.isFile());
            System.out.println(file1.isDirectory());
            System.out.println(file1.getParent());

        }catch (Exception e){
            e.printStackTrace();
        }



    }




//自己抛异常

//    public static void main(String[] args)  {
//        File file =new File("E:\\classthree.txt");
//        //  第一个斜杠  转移   第二个斜杠才是创建
//        new File("e:/ three.txt");
//        try {
//            file.createNewFile();
//        }catch (Exception e){
//            e.printStackTrace();
//        }



    }

