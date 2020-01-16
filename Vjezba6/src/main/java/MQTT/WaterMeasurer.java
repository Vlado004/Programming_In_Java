package MQTT;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

class WaterMeasurer {
    private String brookerURL;
    private SensorData[] sensors;
    private MqttClient client;

    MqttClient ClientStart(){
        MqttClient client = null;
        String clientId = "Client";
        try
        {
            client = new MqttClient(brookerURL, clientId);
            client.connect();
        }
        catch (MqttException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return client;
    }

    void run() {
        client = ClientStart();

        for (int i = 0; i < sensors.length; i++) {
            sensors[i].setup(this);
            sensors[i].start();
        }
    }

    void sendMessage(String topicName, byte[] mess) {
        MqttMessage message = new MqttMessage(mess);

        try {
            client.publish(topicName, message);
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
            System.exit(1);
        }
    }

    //Setter functions
    void setBrookerURL(String str) {
        brookerURL = str;
    }

    void setSensors(SensorData[] sen) {
        sensors = sen;
    }
}
