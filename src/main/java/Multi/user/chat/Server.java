package Multi.user.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            Socket client = server.accept();
            System.out.print("Connection accepted.");
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();
            Scanner sc = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            out.println("hello");
            out.flush();
            client.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
