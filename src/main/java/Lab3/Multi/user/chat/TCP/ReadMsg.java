package Lab3.Multi.user.chat.TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ReadMsg extends Thread{
    private Socket clientDialog;
    private InputStream inStream;
    private OutputStream outStream;
    private Scanner in;
    private PrintWriter out;


    public ReadMsg(Socket client) throws IOException {
        this.clientDialog = client;

        inStream = client.getInputStream();
        outStream = client.getOutputStream();
        in = new Scanner(inStream);
        out = new PrintWriter(outStream);
        start();
    }

    @Override
    public void run() {
        String word;

        try {
            while (true) {
                word = in.nextLine();
                System.out.println(word);
                if (word.equals("quit")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
