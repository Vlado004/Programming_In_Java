package Vjezba7.Vjezba7;

import org.eclipse.paho.client.mqttv3.MqttException;

public interface IMqttService {
    String publishMessage(MqttRequest request) throws MqttException;
}
