package Lab3.Multi.user.chat.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket client;
    private String nameUser;
    private InputStream inStream;
    private OutputStream outStream;
    private Scanner in;
    private PrintWriter out;


    private static int PORT = 19000;

    public Client() throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваше имя");
        String userName = sc.nextLine();

        this.client = new Socket("localhost", PORT);

        inStream = client.getInputStream();
        outStream = client.getOutputStream();
        in = new Scanner(inStream);
        out = new PrintWriter(outStream);



        Runnable r = new ReadMsg(client);
        Thread t = new Thread(r);

        Runnable r2 =  new WriteMsg(client, userName);
        Thread t2 = new Thread(r2);

        t.start();
        t2.start();

    }

    public static void main(String[] args) throws IOException {
        Client userObj = new Client();
    }



    public void setIn(Scanner in) {
        this.in = in;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    public Scanner getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }
}
