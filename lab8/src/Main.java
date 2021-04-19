import task1.Website;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws IOException {
        Website web = new Website("http://www.belstu.by");
        web.printHTML();
    }
}
