package MQTT_SUB;

import jdk.jfr.StackTrace;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Subscriber implements MqttCallback {

    private MqttClient client;

    public void connectionLost(Throwable cause) {
        System.out.println("Connection lost because: " + cause);
        System.exit(2);
    }

    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println(String.format("[%s] %s", topic, new String(message.getPayload())));
    }

    public void run() {
        try {
            client = new MqttClient("tcp://localhost:5654", "Subscriber_Test");
            client.subscribe("#");
        } catch (MqttException e) {
            System.out.println(StackTrace);
            System.exit(1);
        }
    }

    //Nepotrebno ali jer je interface moramo declare-at
    public void deliveryComplete(IMqttDeliveryToken Token) {
    }
}
