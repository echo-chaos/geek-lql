package org.lql.netty.servers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author: lql
 * @date: 2021/5/23 23:07
 * @description: 后端服务
 */
public class BackendServer {
    /**
     * 后台服务端口
     */
    private static final int BACKEND_PORT = 8801;
    /**
     * 运行标志位
     */
    public static final AtomicBoolean RUNNING_FLAG = new AtomicBoolean(true);
    public static volatile boolean initialized = true;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        final ServerSocket serverSocket = new ServerSocket(BACKEND_PORT);
        //RUNNING_FLAG.get()
        while (initialized) {
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> service(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 循环退出之后关闭服务
        serverSocket.close();
        executorService.shutdown();
    }

    private static void service(Socket socket) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[8 * 1024];
            int len = inputStream.read(buffer);
            outputStream.write(buffer, 0, len);
            //
            byte[] input = outputStream.toByteArray();
            String inputContent = new String(input, "UTF-8");
            System.out.println("BackendServer收到请求:\n" + inputContent);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        try {
            Thread.sleep(20);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println("queen:hula");
            String body = "hello,nio";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.flush();
            printWriter.close();
            //socket.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
