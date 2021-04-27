package task3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Recipient {
    public static void receive(int port) throws IOException {
        byte[] buf = new byte[9];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        DatagramSocket datagramSocket = new DatagramSocket(port);

        while (true) {
            datagramSocket.receive(packet);
            System.out.println(new String(buf));
        }
    }
}
