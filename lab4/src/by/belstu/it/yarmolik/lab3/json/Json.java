package by.belstu.it.yarmolik.lab3.json;

import by.belstu.it.yarmolik.lab3.сontrol.Client;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Json {
    public static void serialize(Object obj, String path) throws IOException, IOException {
        FileWriter fileWriter = new FileWriter(path, false);
        ObjectMapper mapper = new ObjectMapper();
        fileWriter.write(mapper.writeValueAsString(obj));
        fileWriter.close();
    }
    public static Client[] deserialize(String path) throws IOException, IOException {
        FileReader fileReader = new FileReader(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fileReader, Client[].class);
    }
}
