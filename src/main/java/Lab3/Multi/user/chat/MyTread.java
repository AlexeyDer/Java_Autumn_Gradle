package Lab3.Multi.user.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyTread extends Thread{
    private Socket clientDialog;
    private InputStream inStream;
    private OutputStream outStream;
    private Scanner in;
    private PrintWriter out;

    public MyTread(Socket client) throws IOException {
        this.clientDialog = client;

        inStream = client.getInputStream();
        outStream =client.getOutputStream();
        in = new Scanner(inStream);
        out = new PrintWriter(outStream);
        start();
    }

    @Override
    public void run() {
        String word;
        try {

            while (!clientDialog.isClosed()) {

                word = in.nextLine();
                Server.hist.getStorage().add(word);
                System.out.println(word);


                if (word.equalsIgnoreCase("quit")) {
                    System.out.println("Client initialize connections suicide ...");
                    out.write("Server reply: " + word + " - OK");
                    Thread.sleep(3000);
                    break;
                }

                for (MyTread vr: Server.serverList) {
                    vr.send(word);
                }

            }

            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");

            in.close();
            out.close();

            clientDialog.close();


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void send(String word) {
        try {
            out.write(word + "\n");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

