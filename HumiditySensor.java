package AirQualityController;

public class HumiditySensor extends Sensor {

	public Double getHumidity(Double inVolt) {
		Double Vmax = 5.0;
		return ((inVolt/Vmax)-0.16)/0.0062;
	}

}
