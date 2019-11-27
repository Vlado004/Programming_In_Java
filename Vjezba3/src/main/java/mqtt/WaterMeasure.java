package mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import sun.management.Sensor;

class WaterMeasure {
    void run() throws InterruptedException {
        SensorData temperature = new SensorData(-32668, 32668, 10);
        SensorData pressure = new SensorData(0, 65336, 1000);
        SensorData consumption = new SensorData(0, 65336, 1);
        SensorData consumptionCubic = new SensorData(0, 65336, 10);

        WaterStatisticsPublisher publisher = new WaterStatisticsPublisher();
        MqttClient client = publisher.ClientStart();
        String payload;

        while(true){
            payload = temperature.createPayload() + "\n";
            publisher.Publish(client, payload);
            payload = pressure.createPayload() + "\n";
            publisher.Publish(client, payload);
            payload = consumption.createPayload() + "\n";
            publisher.Publish(client, payload);
            payload = consumptionCubic.createPayload() + "\n";
            publisher.Publish(client, payload);

            Thread.sleep(2000);
        }
    }
}
