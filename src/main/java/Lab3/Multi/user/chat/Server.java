package Lab3.Multi.user.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

public class Server {

    private static Socket clientSocket;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(19000);
            System.out.println("Сервер запущен!");

            Socket client = server.accept();

            System.out.print("Connection accepted.");


            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();

            Scanner sc = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);

            while (true) {
                System.out.println("Ждем пока клиент что-то напишет...");
                String word = sc.nextLine();
                if ("q" == word) {
                    System.out.println("Клиент закрыт");
                    client.close();
                    System.exit(0);
                }
                System.out.println(word);

                out.write("Привет, брат! Подтверждаю, вы написали : " + word + "\n");
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
