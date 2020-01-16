package MQTT;

import java.util.Random;

class SensorData extends Thread {
    public String topicName;
    public int factor;
    public double rangeStart;
    public double rangeEnd;
    public String unit;
    public WaterMeasurer parent;
    private Random random = new Random();

    public byte[] createMessage() {
        double value = random.nextInt((int)(rangeEnd - rangeStart)) + ((int) rangeStart);
        String payload = (value / factor) + " " + unit + "\n";
        return payload.getBytes();
    }

    public void setup(WaterMeasurer client) {
        parent = client;
    }

    public void run() {
        while(true) {
            byte[] message = createMessage();
            parent.sendMessage(topicName, message);
            try {
                Thread.sleep((random.nextInt((int)(40)) + 10) * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
