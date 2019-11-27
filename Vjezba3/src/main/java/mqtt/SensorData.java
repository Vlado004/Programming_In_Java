package mqtt;

import java.util.Random;

class SensorData {
    private int factor;
    private double rangeStart;
    private double rangeEnd;
    //int value; cini se da netriba

    SensorData(double rStart, double rEnd, int fact) {
        factor = fact;
        rangeStart = rStart;
        rangeEnd = rEnd;
    }

    String createPayload() {
        Random random = new Random();
        double value = random.nextInt((int)(rangeEnd - rangeStart)) + ((int) rangeStart);
        value = value / factor;
        String payload = value + "\n";
        return payload;
    }
}
