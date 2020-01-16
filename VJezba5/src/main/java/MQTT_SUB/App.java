package MQTT_SUB;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String args[]) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        Subscriber sub = mapper.readValue(new File(".\\config.json"), Subscriber.class);
        sub.run();
    }
}
