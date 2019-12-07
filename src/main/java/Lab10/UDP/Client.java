package Lab10.UDP;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        byte[] data = "hello".getBytes();
        InetAddress addr = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(data, data.length, addr, 19000);

        DatagramSocket ds = new DatagramSocket();

        ds.send(packet);
    }
}
