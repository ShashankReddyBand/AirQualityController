package AirQualityController;

public class AQIComponent {

	private int TargetAQI = 100;

	private AQISensor aQISensor = new AQISensor();

	public boolean SetAQI(int setAQI) {
		TargetAQI = setAQI;
		return true;
	}

	public int getAOILevel() {
		int level = 0;
		if(aQISensor.getAQI() < TargetAQI){
			level = 1;
		}
		return level;
	}

}
