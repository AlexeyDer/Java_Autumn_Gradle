package Lab3.Multi.user.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyTread implements Runnable {
    private Socket clientDialog;

    public MyTread(Socket client) {
        this.clientDialog = clientDialog;
    }

    @Override
    public void run() {

        try {
            OutputStream outStream = clientDialog.getOutputStream();
            InputStream inStream = clientDialog.getInputStream();


            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);

            while (!clientDialog.isClosed()) {
                String entry = in.nextLine();
                System.out.println("READ from clientDialog message - " + entry);

                if (entry.equalsIgnoreCase("quit")) {
                    System.out.println("Client initialize connections suicide ...");
                    out.write("Server reply: " + entry + " - OK");
                    Thread.sleep(3000);
                    break;
                }

                System.out.println("Server try writing  to channal");
                out.write("Server reply - " + entry + " - OK");
                System.out.println("Server Wrote message to clientDialog.");
                out.flush();
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


}
