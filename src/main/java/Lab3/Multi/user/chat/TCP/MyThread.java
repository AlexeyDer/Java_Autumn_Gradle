package Lab3.Multi.user.chat.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyThread implements Runnable {
    private Socket clientDialog;

    private InputStream inStream;
    private OutputStream outStream;

    private Scanner in;
    private PrintWriter out;


    public MyThread(Socket client) throws IOException {
        this.clientDialog = client;

        inStream = client.getInputStream();
        outStream = client.getOutputStream();
        in = new Scanner(inStream);
        out = new PrintWriter(outStream);
    }

    @Override
    public void run() {
        String word;

        if (!Server.socketsList.isEmpty()) {
            var lastElem = Server.socketsList.size() - 1;
            var histStorage = Server.hist.getStorage();

            for (int i = 0; i < histStorage.size(); i++)
                Server.socketsList.get(lastElem).send(histStorage.get(i));
        }

        try {
            while (!clientDialog.isClosed()) {

                word = in.nextLine();
                System.out.println(word);

                if (word.equalsIgnoreCase("quit")) {
                    System.out.println("Client initialize connections suicide ...");
                    out.write("Server reply: " + word + " - OK");
                    Thread.sleep(3000);
                    break;
                }

                for (MyThread vr : Server.socketsList) {
                    vr.send(word);
                }
                Server.hist.addMsg(word);

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

