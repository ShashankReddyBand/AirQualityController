package AirQualityController;

public class HumidifierSwitch extends Switch {
    public Void switchOn(int round) {
        System.out.println("Humidifier: ON");
        Readings readings = new Readings();
        readings.updateReadings(round, 3, -0.05);
        return null;
    }
    
    public Void switchOff() {
        System.out.println("Humidifer: OFF");
        return null;
    }
}
