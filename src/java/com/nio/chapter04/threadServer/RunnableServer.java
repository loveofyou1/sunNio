package com.nio.chapter04.threadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description RunnableServer
 * @Author sunlei19
 * @Date 2020/9/8 16:03
 * @Version 1.0
 */
public class RunnableServer {
    private ServerSocket serverSocket;

    private Executor executor;

    public RunnableServer(int port, int poolSize) {
        try {
            serverSocket = new ServerSocket(port);
            executor = new ThreadPoolExecutor(poolSize, 100, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.CallerRunsPolicy());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startService() {
        try {
            for (; ; ) {
                Socket socket = serverSocket.accept();
                executor.execute(new ReadRunnable(socket));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RunnableServer runnableServer = new RunnableServer(8088, 10);
        runnableServer.startService();
    }
}
