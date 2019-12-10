package Lab3.Multi.user.chat.TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static History hist = new History();
    public static int PORT = 19000;
    public static LinkedList<MyThread> socketsList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Сервер запущен!");

        ExecutorService threadpool = Executors.newFixedThreadPool(10);

            while (true) {
                Socket client = null;
                try {
                    client = server.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                MyThread newThread = new MyThread(client);
                threadpool.submit(newThread);
                socketsList.add(newThread);
            }

    }


}
