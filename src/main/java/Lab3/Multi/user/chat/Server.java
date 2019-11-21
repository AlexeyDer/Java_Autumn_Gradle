package Lab3.Multi.user.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Server {

    private static Socket clientSocket;

    public static void main(String[] args) {
        Socket client;
        try {
            ServerSocket server = new ServerSocket(4004);
            System.out.println("Сервер запущен!");

            try {
                try {
                   client = server.accept();
                   Runnable r = new MyTread(client);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.print("Connection accepted.");


                InputStream inStream = client.getInputStream();
                OutputStream outStream = client.getOutputStream();

                Scanner sc = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream);

                while (true) {
                    System.out.println("Ждем пока клиент что-то напишет...");
                    String word = sc.nextLine();
                    if ("q" == word) {
                        System.exit(0);
                    }
                    System.out.println(word);
                }
//                out.write("Привет, брат! Подтверждаю, вы написали : " + word + "\n");
//                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Клиент закрыт");
                client.close();
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
