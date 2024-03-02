package LLD.ObserverDesignPattern.WeatherStationApplication;

import java.util.ArrayList;
import java.util.List;

// Concrete Observable
public class WeatherStation implements WeatherObservable{
    List<WeatherObserver> weatherObserverList;
    int temperature;
    int humidity;
    int pressure;

    WeatherStation(){
        weatherObserverList=new ArrayList<>();
    }

    //<<<NOTE THIS>>>
    //Whenever data is set, users are notified with the updated weather information
    void setWeatherData(int temperature, int humidity, int pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        notifyObservers();
    }


    @Override
    public void registerObserver(WeatherObserver weatherObserver) {
        weatherObserverList.add(weatherObserver);
    }

    @Override
    public void removeObserver(WeatherObserver weatherObserver) {
        weatherObserverList.remove(weatherObserver);
    }

    @Override
    public void notifyObservers() {
        for(WeatherObserver weatherObserver: weatherObserverList)
            weatherObserver.update(temperature,humidity,pressure);
    }
}
