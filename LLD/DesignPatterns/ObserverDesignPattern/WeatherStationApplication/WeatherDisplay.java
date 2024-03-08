package LLD.DesignPatterns.ObserverDesignPattern.WeatherStationApplication;

public class WeatherDisplay implements WeatherObserver{
    @Override
    public void update(int temperature, int humidity, int pressure) {
        System.out.println("Weather Display - Temperature: " + temperature +
                " Humidity: " + humidity + " Pressure: " + pressure);
    }
}
