package Lab10.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(19000);

        while (true) {
            DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
            ds.receive(dp);

            String str = dp.getData().toString();
            str.toUpperCase();

            byte[] data = str.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, dp.getAddress(), dp.getPort());


            System.out.println(new String(dp.getData()));
        }
    }
}
