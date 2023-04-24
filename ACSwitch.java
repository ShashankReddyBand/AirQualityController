package AirQualityController;

public class ACSwitch extends Switch {

    public Void switchOn(int round) {
        System.out.println("AC: ON");
        Readings readings = new Readings();
        readings.updateReadings(round, 2, -5.0);
        return null;
    }
    
    public Void switchOff() {
        System.out.println("AC: OFF");
        return null;
    }
}
