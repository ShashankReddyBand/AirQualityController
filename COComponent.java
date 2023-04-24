package AirQualityController;

public class COComponent {
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_RESET = "\u001B[0m";

	private Double targetCOLevel = 35.0;

	private COSensor cOSensor = new COSensor();

	public int getCOLevel(Double inVolt) {
		int level = 0;
		if(cOSensor.getCOLevel(inVolt) > targetCOLevel){
			level = 1;
			System.out.println(ANSI_RED_BACKGROUND + "CO Level: " + cOSensor.getCOLevel(inVolt) + ANSI_RESET);
			return level;
		}
		System.out.println(ANSI_GREEN_BACKGROUND + "CO Level: " + cOSensor.getCOLevel(inVolt) + ANSI_RESET);
		return level;
	}

}
