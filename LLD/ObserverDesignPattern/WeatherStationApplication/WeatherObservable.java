package LLD.ObserverDesignPattern.WeatherStationApplication;

public interface WeatherObservable {
    void registerObserver(WeatherObserver weatherObserver);
    void removeObserver(WeatherObserver weatherObserver);
    void notifyObservers();
}
