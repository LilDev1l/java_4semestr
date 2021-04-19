package task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Website web = new Website("http://www.belstu.by");
        web.printHTML();
    }
}
