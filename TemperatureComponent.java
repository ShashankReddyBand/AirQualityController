package AirQualityController;

public class TemperatureComponent {
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_RESET = "\u001B[0m";

	private Double TargetTemperature = 76.0;

	private TempSensor tempSensor = new TempSensor();

	public boolean SetTemperature(Double setTemperature) {
		this.TargetTemperature = setTemperature;
		return true;
	}

	public int getTempLevel(Double inVolt) {
		int level = 0;
		if(this.tempSensor.getTemp(inVolt) > this.TargetTemperature){
			System.out.println(ANSI_RED_BACKGROUND + "Temperature : " + tempSensor.getTemp(inVolt) + ANSI_RESET);
			level = 1;
			return level;
		}
		System.out.println(ANSI_GREEN_BACKGROUND + "Temperature : " + tempSensor.getTemp(inVolt) + ANSI_RESET);
		return level;
	}

}
