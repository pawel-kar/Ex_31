package pl.pelikan.weatherinthecity.openweatherapi;

import lombok.Data;

@Data
public class BasicWeather {
    private double temp;
    private double pressure;
    private double humidity;
}
