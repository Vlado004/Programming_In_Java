package mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

class WaterStatisticsPublisher {

    private static final String WATER_STATISTIC = "WATER_STATISTIC";

    MqttClient ClientStart(){
        final String BROKER_URL = "tcp://localhost:1883";
        MqttClient client = null;
        String clientId = "Client";
        try
        {
            client = new MqttClient(BROKER_URL, clientId);
        }
        catch (MqttException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return client;
    }

    void Publish(MqttClient client, String payload){

        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(payload.getBytes());
        try {
            client.connect();
            client.publish(WATER_STATISTIC, mqttMessage);
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
