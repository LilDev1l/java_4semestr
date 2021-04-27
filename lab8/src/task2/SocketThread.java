package task2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketThread extends Thread {
    private Socket socket;
    private PrintStream output;
    private BufferedReader input;

    public SocketThread(Socket socket) throws IOException {
        this.socket = socket;
        output = new PrintStream(socket.getOutputStream());
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {

        try {
            while (!socket.isClosed()) {
                String message = input.readLine();
                if (message.equals("stop")) {
                    break;
                }
                System.out.println(message);
                send(message);
            }

        } catch (IOException e) {
            System.err.println("Disconnect");
        } finally {
            try {
                System.out.println("user disconnected from " + socket.getInetAddress());
                NetServer.socketThreads.remove(socket);
                socket.close();
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void send(String message) throws IOException {
        for (var socketThread : NetServer.socketThreads) {
            socketThread.output.println(message);
        }
    }
}
