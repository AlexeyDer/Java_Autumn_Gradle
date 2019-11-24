package Lab3.Multi.user.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class WriteMsg extends Thread{
    private Socket clientDialog;
    private String nameUser;
    private OutputStream outStream;
    private PrintWriter out;

    public WriteMsg(Socket client, String nameUser) throws IOException {
        this.clientDialog = client;
        this.nameUser = nameUser;

        outStream = client.getOutputStream();
        out = new PrintWriter(outStream);
        start();
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        out.write(getNameUser() + " подключился!\n");
        out.flush();
        while (true) {
            String userWord;
            try {
//                System.out.println("Написать сообщение: ");
                userWord = sc.nextLine(); // сообщения с консоли
                if (userWord.equals("quit")) {
                    out.write("quit" + "\n");
                    break; // выходим из цикла если пришло "stop"
                } else {
                    out.write(nameUser + " пишет: " +  userWord + "\n"); // отправляем на сервер
               //     Server.hist.addMsg(nameUser + " пишет: " +  userWord);
                }
                out.flush(); // чистим
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getNameUser() {
        return nameUser;
    }
}
