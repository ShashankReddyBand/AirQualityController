package AirQualityController;

public class AQIComponent {
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_RESET = "\u001B[0m";

	private Double TargetAQI = 50.0;

	private AQISensor aQISensor = new AQISensor();

	public boolean SetAQI(Double setAQI) {
		TargetAQI = setAQI;
		return true;
	}

	public int getAOILevel(Double aqiVolt) {
		int level = 0;
		if (aQISensor.getAQI(aqiVolt) > TargetAQI) {
			System.out.println(ANSI_RED_BACKGROUND + "AQI: " + aQISensor.getAQI(aqiVolt) + ANSI_RESET);
			level = 1;
			return level;
		}
		System.out.println(ANSI_GREEN_BACKGROUND + "AQI: " + aQISensor.getAQI(aqiVolt) + ANSI_RESET);
		return level;
	}

}
