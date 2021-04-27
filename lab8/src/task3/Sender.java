package task3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Sender {
    public static void send(String data, InetAddress ip, int port) throws IOException {
        byte[] buf = data.getBytes();
        DatagramSocket datagramSocket = new DatagramSocket();

        DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, port);
        datagramSocket.send(packet);
    }
}
