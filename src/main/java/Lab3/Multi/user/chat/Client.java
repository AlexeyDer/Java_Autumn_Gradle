package Lab3.Multi.user.chat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private static Socket clientSocket;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваше имя");
        String user = sc.nextLine();

        clientSocket = new Socket("localhost", 4004);
        try {
            InputStream inStream = clientSocket.getInputStream();
            OutputStream outStream = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            PrintWriter out = new PrintWriter(outStream);

            out.write(user + "подключился!\n");
            out.flush();
            while (true) {
                System.out.println("Написать сообщение?");
                String word = sc.nextLine();
                if ("q" == word) {
                    System.exit(0);
                }
                out.write(user + "пишет: " + word + "\n");
                out.flush();
//
//                String serverWord = reader.readLine();
//                System.out.println(serverWord);
            }



        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Клиент был закрыт...");
            clientSocket.close();
        }
    }
}
