package task3;

import java.io.IOException;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            try {
                Recipient.receive(5000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            Sender.send("message " + i, InetAddress.getLocalHost(), 5000);
        }
    }
}
