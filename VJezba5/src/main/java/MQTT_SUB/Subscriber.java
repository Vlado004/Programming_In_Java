package MQTT_SUB;

import org.eclipse.paho.client.mqttv3.*;

public class Subscriber implements MqttCallback {

    private MqttClient client;

    public void connectionLost(Throwable cause) {
        System.out.println("Connection lost because: " + cause);
        System.exit(2);
    }

    public void messageArrived(String topic, MqttMessage message) {
        System.out.println(String.format("[%s] %s", topic, new String(message.getPayload())));
    }

    public void run() {
        /*try {
            client = new MqttClient("tcp://localhost:1883", "Subscriber_Test");
            client.setCallback(this);
            client.connect();
            client.subscribe("#", 1);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }*/
        GUI g = new GUI();
        g.create();
    }

    //Nepotrebno ali jer je interface moramo declare-at
    public void deliveryComplete(IMqttDeliveryToken Token) {
    }
}
