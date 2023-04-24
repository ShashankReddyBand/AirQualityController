package AirQualityController;

public class Controller {

	private AQIComponent aQIComponent = new AQIComponent();

	private TemperatureComponent temperatureComponent = new TemperatureComponent();

	private HumidityComponent humidityComponent = new HumidityComponent();

	private COComponent cOComponent = new COComponent();

	private Alarm alarm = new Alarm();

	private ACSwitch ACSwitch = new ACSwitch();

	private HumidifierSwitch humidifierSwitch = new HumidifierSwitch();

	private AirPurifierSwitch airPurifierSwitch = new AirPurifierSwitch();

	public boolean ACOnOff(int tempHiLow, int round) {
		if(tempHiLow > 0){
			ACSwitch.switchOn(round+1);
			return true;
		}
		else{
			ACSwitch.switchOff();
			return true;
		}
	}

	public boolean HumidifierOnOff(int humidityHiLow, int round) {
		if(humidityHiLow > 0){
			humidifierSwitch.switchOn(round+1);
			return true;
		}
		else{
			humidifierSwitch.switchOff();
			return true;
		}
	}

	public boolean AirFileterOnOff(int AQIHiLow, int round) {
		if(AQIHiLow > 0 && airPurifierSwitch.getState() == false){
			airPurifierSwitch.switchOn(round+1);
			return true;
		}
		else{
			airPurifierSwitch.switchOff();
			return true;
		}
	}

	public int checkTemp(String tempString) {
		return temperatureComponent.getTempLevel(Double.parseDouble(tempString));
	}

	public int checkHumidity(String humidString) {
		return humidityComponent.getHumidityLevel(Double.parseDouble(humidString));
	}

	public int checkAQI(String aqiString) {
		return aQIComponent.getAOILevel(Double.parseDouble(aqiString));
	}

	public boolean checkCOLevel(String coString) {
		return cOComponent.getCOLevel(Double.parseDouble(coString))==1;
	}

	public boolean soundAlarm(boolean COLevelHigh) {

		alarm.SoundAlarm(COLevelHigh);
		return true;
	}


	public static void main(String[] args) {
		System.out.println("this is working!!!");
		Controller controller = new Controller();
		Readings readings = new Readings();
		for (int i = 0; i < 15; i++) {
			System.out.println("-----Round " + i + "-----");

			// System.out.println(readings.getTempString(i+1));

			int airOnOff = controller.checkAQI(readings.getAQIString(i+1));
			int ACOnOff = controller.checkTemp(readings.getTempString(i+1));
			int HumidifierOnOff = controller.checkHumidity(readings.gethumidString(i+1));
			Boolean alarmOnOff = controller.checkCOLevel(readings.getCOString(i+1));

			// controller.AirFileterOnOff(airOnOff);
			controller.ACOnOff(ACOnOff, i+1);
			controller.HumidifierOnOff(HumidifierOnOff, i+1);
			// controller.soundAlarm(alarmOnOff);

			System.out.println("-----Round " + i + "-----");
		}
		
	}
}
