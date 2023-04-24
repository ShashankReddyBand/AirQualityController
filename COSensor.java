package AirQualityController;

public class COSensor extends Sensor {

	public Double getCOLevel(Double inVolt) {
		Double Voff = 5.0;
		Double sensitivity = 0.03;
		return ( inVolt - Voff)/sensitivity;
	}

}
