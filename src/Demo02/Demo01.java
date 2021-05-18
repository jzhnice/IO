package Demo02;

import java.io.File;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-13 16:57
 */
public class Demo01 {
    public static void main(String[] args) {
      File f = new File("d:/demo01");
      printTree(f,0);
    }
    public static void printTree(File f,int llevel){
        for (int i = 0; i < llevel; i++) {
//            System.out.println("\t");
        }
        System.out.println(f.getAbsolutePath());
        if(f.isDirectory()){
            llevel++;
            File[] strs = f.listFiles();
            for (int i = 0; i < strs.length; i++) {
              File fo=  strs[i] ;
              printTree(fo,llevel+1);
            }
        }
    }


}
