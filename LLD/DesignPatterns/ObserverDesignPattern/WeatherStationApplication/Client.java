package LLD.DesignPatterns.ObserverDesignPattern.WeatherStationApplication;
/*
UseCase: We want to notify various displays whenever the weather conditions change.
WeatherStation acts as the subject that notifies observers (WeatherDisplay) when the weather conditions change.
WeatherDisplay class implements the observer interface to update its display whenever it receives new weather data
from the weather station.
 */
public class Client {
    public static void main(String []args){
        WeatherStation weatherStation=new WeatherStation();

        WeatherDisplay weatherDisplay1=new WeatherDisplay();
        WeatherDisplay weatherDisplay2=new WeatherDisplay();

        weatherStation.registerObserver(weatherDisplay1);
        weatherStation.registerObserver(weatherDisplay2);

        //Simulate Weather Changes
        weatherStation.setWeatherData(75,60,30);
        weatherStation.setWeatherData(55,120,30);
    }
}
