package AirQualityController;

public class TempSensor extends Sensor {

	public Double getTemp(Double inVolt) {
		return ((inVolt-500)/10)*1.8+32;
	}

}
