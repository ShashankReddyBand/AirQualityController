package AirQualityController;

public class COComponent {

	private int targetCOLevel = 5;

	private COSensor cOSensor;

	public int getCOLevel() {
		int level = 0;
		if(cOSensor.getCOLevel() > targetCOLevel){
			level = 1;
		}
		return level;
	}

}
