package Lab3.Multi.user.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {

    private static Socket clientSocket;
    public static History hist = new History();
    public static int PORT = 19000;
    public static LinkedList<MyTread> serverList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Сервер запущен!");

        try {
            while (true) {
                Socket client = server.accept();

                try {
                    serverList.add(new MyTread(client));
                } catch (Exception e) {
                    e.printStackTrace();
                    client.close();
                }
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            server.close();
        }

    }


}
