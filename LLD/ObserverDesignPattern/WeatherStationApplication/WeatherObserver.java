package LLD.ObserverDesignPattern.WeatherStationApplication;

public interface WeatherObserver {
    void update(int temperature, int humidity, int pressure);
}
