package task2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetClient {
    public static void main(String[] args) throws IOException {

            Socket socket = new Socket(InetAddress.getLocalHost(), 7068);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream output = new PrintStream(socket.getOutputStream());
        try {
            new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                while (!socket.isClosed()) {
                    String message = sc.nextLine();
                    output.println(message);
                    if(message.equals("stop")) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(() -> {
                while (!socket.isClosed()) {
                    try {
                        String message = input.readLine();
                        System.out.println(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
