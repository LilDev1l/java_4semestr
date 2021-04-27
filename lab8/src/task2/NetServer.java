package task2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class NetServer {
    public static ArrayList<SocketThread> socketThreads = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(7068)) {
            System.out.println("initialized...");
            while (true) {
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected");

                SocketThread socketThread = new SocketThread(socket);
                socketThreads.add(socketThread);
                socketThread.start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
