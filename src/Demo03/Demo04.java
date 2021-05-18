package Demo03;

import java.io.*;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-13 18:23
 */
public class Demo04 {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("E:\\GitHubDesktopSetup-x64.exe") ;
        Writer writer = new FileWriter("E:\\hhhhhhhggggqqqqAA123213Ss.exe") ;

        int len = 0;
        char[] buffer = new char[1024];
        while((len = reader.read(buffer)) !=-1){
            writer.write(buffer,0,len);
        }
        reader.close();
        writer.close();



    }
}
