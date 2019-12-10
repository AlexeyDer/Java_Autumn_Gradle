package Lab10.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) throws IOException {
        byte[] data = "Hello Vika".getBytes();
        InetAddress addr = InetAddress.getByName("192.168.43.121");

//
//        DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
//        ds.receive(dp);

        for (int i = 0; i < 10000; i++) {
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    DatagramPacket packet = new DatagramPacket(data, data.length, addr, 19000);
                    DatagramSocket ds = null;
                    try {
                        ds = new DatagramSocket();
                    } catch (SocketException e) {
                        e.printStackTrace();
                    }
                    try {
                        ds.send(packet);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            };
            Thread t = new Thread(run);
            t.start();

        }
    }

//        System.out.println(new String(dp.getData()));

}


