package Demo06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @version 1.0
 * @author: jiazhihao
 * @date: 2021-05-18 15:44
 */
public class SelectorServiceDemo {


    public static void main(String[] args) throws Exception {
        int port = 8000;
        // 通过open（）方法找到selector
        Selector seletor = Selector.open();
        //打开服务器的通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //服务器配置为非阻塞
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);
        // 进行服务的绑定
        serverSocket.bind(address);
        //注册到selector，等待连接
        serverSocketChannel.register(seletor, SelectionKey.OP_ACCEPT);
        System.out.println("服务器运行，端口：" + port);
        // 数据缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            if ((seletor.select()) > 0) {
                //  选择一组键 并且相应的通道已经准备就绪
                //取出全部生成的key
                Set<SelectionKey> selectedkeys = seletor.selectedKeys();
                Iterator<SelectionKey> iter = selectedkeys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    if (key.isAcceptable()) {
                        acceptable(key, byteBuffer, seletor);
                    } else if (key.isReadable() && key.isValid()) {
                        readable(seletor, byteBuffer, key);
                    } else if (key.isWritable() && key.isValid()) {
                        writable(seletor, byteBuffer, key);
                    }
                }

                selectedkeys.clear();
            }
        }
    }


    public static void writable(Selector selector, ByteBuffer byteBuffer, SelectionKey key)


            throws IOException, ClosedChannelException {
        SocketChannel client = (SocketChannel) key.channel();

        byteBuffer.clear();
        // 向缓冲区设置内容
        byteBuffer.put(("欢迎学习NIO教程").getBytes());
        byteBuffer.flip();
        // 输出内容
        client.write(byteBuffer);
        client.register(selector, SelectionKey.OP_READ);
    }

    public static void readable(Selector selector, ByteBuffer byteBuffer, SelectionKey key)
            throws IOException, ClosedChannelException {
        SocketChannel client = (SocketChannel) key.channel();
        byteBuffer.clear();
        // 读取内容到缓冲区
        int readsize = client.read(byteBuffer);
        if (readsize > 0) {
            System.out.println("服务器接受客户点数据：" + new String(byteBuffer.array(), 0, readsize));
            client.register(selector, SelectionKey.OP_WRITE);

        }
    }

    public static void acceptable(SelectionKey key, ByteBuffer byteBuffer, Selector selector)
            throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        //接收新连接 和BIO写法类都是accept
        SocketChannel client = server.accept();
        // 配置为非阻塞
        client.configureBlocking(false);
        byteBuffer.clear();
        // 像缓冲区设置内容
        byteBuffer.put(("当前的时间为：" + new Date()).getBytes());
        byteBuffer.flip();
        // 输出内容
        client.write(byteBuffer);
        client.register(selector, SelectionKey.OP_READ);
    }


}



