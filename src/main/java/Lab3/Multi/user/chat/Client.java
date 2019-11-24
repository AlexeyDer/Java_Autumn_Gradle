package Lab3.Multi.user.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
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

        printStory(Server.hist.getStorage());

        new WriteMsg(client, userName);
        new ReadMsg(client);
    }

    public static void main(String[] args) throws IOException {
        if (!Server.hist.getStorage().isEmpty()) {
            for (int i = 0; i < Server.hist.getStorage().size(); i++) {
                System.out.println(Server.hist.getStorage().get(i));
            }
        }

        Client userObj = new Client();

    }

    public void printStory(List<String> hist ){
        for (int i = 0; i < hist.size(); i++)
            System.out.println(hist.get(i));
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
