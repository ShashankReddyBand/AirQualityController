package AirQualityController;

public class HumidityComponent {
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_RESET = "\u001B[0m";

	private Double TargetHumidity = 100.0;

	private HumiditySensor humiditySensor = new HumiditySensor();

	public boolean SetHumidity(Double setHumidity) {
		this.TargetHumidity = setHumidity;
		return true;
	}

	public int getHumidityLevel(Double inVolt) {
		int level = 0;
		if(this.humiditySensor.getHumidity(inVolt) > this.TargetHumidity){
			System.out.println(ANSI_RED_BACKGROUND + "Humidity level: " + humiditySensor.getHumidity(inVolt) + ANSI_RESET);
			level = 1;
			return level;
		}
		System.out.println(ANSI_GREEN_BACKGROUND + "Humidity level: " + humiditySensor.getHumidity(inVolt) + ANSI_RESET);
		return level;
	}

}
