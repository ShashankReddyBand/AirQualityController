package AirQualityController;

import com.apple.laf.resources.aqua;

import AirQualityController.util.List;

public class Controller {

	private AQIComponent aQIComponent = new AQIComponent();

	private TemperatureComponent temperatureComponent = new TemperatureComponent();

	private HumidityComponent humidityComponent = new HumidityComponent();

	private COComponent cOComponent = new COComponent();

	private Alarm alarm = new Alarm();

	private ACSwitch ACSwitch = new ACSwitch();

	private HumidifierSwitch humidifierSwitch = new HumidifierSwitch();

	private AirPurifierSwitch airPurifierSwitch = new AirPurifierSwitch();

	public boolean ACOnOff(int tempHiLow) {
		if(tempHiLow > 0){
			ACSwitch.switchOn();
			return true;
		}
		else{
			ACSwitch.switchOff();
			return true;
		}
	}

	public boolean HumidifierOnOff(int humidityHiLow) {
		if(humidityHiLow > 0){
			humidifierSwitch.switchOn();
			return true;
		}
		else{
			humidifierSwitch.switchOff();
			return true;
		}
	}

	public boolean AirFileterOnOff(int AQIHiLow) {
		if(AQIHiLow > 0){
			airPurifierSwitch.switchOn();
			return true;
		}
		else{
			airPurifierSwitch.switchOff();
			return true;
		}
	}

	public int checkTemp() {
		return temperatureComponent.getTempLevel();
	}

	public int checkHumidity() {
		return humidityComponent.getHumidityLevel();
	}

	public int checkAQI() {
		return aQIComponent.getAOILevel();
	}

	public int checkCOLevel() {
		return cOComponent.getCOLevel();
	}

	public boolean soundAlarm(boolean COLevelHigh) {

		alarm.SoundAlarm(COLevelHigh);
		return true;
	}

	public static void main(String[] args) {
		System.out.println("this is working!!!");


	}
}
