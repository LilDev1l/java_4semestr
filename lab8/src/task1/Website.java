package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Website {
    URL tut;

    public Website(String url) throws MalformedURLException {
        tut = new URL(url);
    }

    public void printHTML() throws IOException {
        try(BufferedReader d = new BufferedReader(new InputStreamReader(tut.openStream()))) {
            String line = "";
            while((line = d.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
