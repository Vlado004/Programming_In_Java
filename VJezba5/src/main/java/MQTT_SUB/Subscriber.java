package MQTT_SUB;

import org.eclipse.paho.client.mqttv3.*;

public class Subscriber implements MqttCallback {

    private MqttClient client;
    private String[] hostList;
    private String[] topics;
    private GUI gui;

    public void connectionLost(Throwable cause) {
        System.out.println("Connection lost because: " + cause);
        System.exit(2);
    }

    public void messageArrived(String topic, MqttMessage message) {
        gui.addMessage(String.format("[%s] %s", topic, new String(message.getPayload())));
    }

    public void run() {
            gui = new GUI(this);
            gui.create(hostList, topics);

    }

    public void connect(String serverURI, String topic) {
        try {
            if (client != null) {
                if (client.isConnected()) {
                    client.disconnect();
                }
            }
            client = new MqttClient(serverURI, "Subscriber_Test");
            client.setCallback(this);
            client.connect();
            client.subscribe(topic, 1);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void setHostList(String[] values) {
        hostList = values;
    }

    public void setTopics(String[] values) {
        topics = values;
    }

    //Nepotrebno ali jer je interface moramo declare-at
    public void deliveryComplete(IMqttDeliveryToken Token) {
    }
}
