package AirQualityController;

import AirQualityController.util.List;

public class Controller {

	private AQIComponent aQIComponent;

	private TemperatureComponent temperatureComponent;

	private HumidityComponent humidityComponent;

	private COComponent cOComponent;

	private Alarm alarm;

	private ACSwitch aCSwitch;

	private HumidifierSwitch humidifierSwitch;

	private AirPurifierSwitch airPurifierSwitch;

	public boolean ACOnOff(int tempHiLow) {
		return false;
	}

	public boolean HumidifierOnOff(int humidityHiLow) {
		return false;
	}

	public boolean AirFileterOnOff(int AQIHiLow) {
		return false;
	}

	public int checkTemp() {
		return 0;
	}

	public int checkHumidity() {
		return 0;
	}

	public int checkAQI() {
		return 0;
	}

	public int checkCOLevel() {
		return 0;
	}

	public boolean soundAlarm(boolean COLevel) {
		return false;
	}

	public static void main(String[] args) {
		System.out.println("this is working!!!");
	}
}
