package Lab3.Multi.user.chat.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyTread implements Runnable{
    private Socket clientDialog;
    private InputStream inStream;
    private OutputStream outStream;
    private Scanner in;
    private PrintWriter out;


    public MyTread(Socket client) throws IOException {
        this.clientDialog = client;

        inStream = client.getInputStream();
        outStream = client.getOutputStream();
        in = new Scanner(inStream);
        out = new PrintWriter(outStream);
    }

    @Override
    public void run() {
        String word;
        try {
            while (!clientDialog.isClosed()) {

                word = in.nextLine();
                send(word);

//                Server.hist.getStorage().add(word);
                System.out.println(word);


                if (word.equalsIgnoreCase("quit")) {
                    System.out.println("Client initialize connections suicide ...");
                    out.write("Server reply: " + word + " - OK");
                    Thread.sleep(3000);
                    break;
                }

//                for (MyTread vr: Server.serverList) {
//                    vr.send(word);
//                }

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

