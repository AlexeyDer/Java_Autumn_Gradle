package Lab3.Multi.user.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fabrica {

    static ExecutorService executIt = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(19000);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Server socket created, command console reader for listen to server commands");

            while (!server.isClosed()) {
                if (br.ready()) {
                    System.out.println("Main Server found any messages in channel, let's look at them.");

                    String serverCommand = br.readLine();

                    if (serverCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Main Server initiate exiting...");
                        server.close();
                        break;
                    }
                }

                Socket client = server.accept();

                executIt.execute(new MyTread(client));
                System.out.print("Connection accepted.");
            }

            executIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    public Fabrica() throws IOException {
    }
}
