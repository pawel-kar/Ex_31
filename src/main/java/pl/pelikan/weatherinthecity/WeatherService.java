package pl.pelikan.weatherinthecity;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pelikan.weatherinthecity.openweatherapi.OpenWeatherDto;

@Service
public class WeatherService {
    private final String APIkey = "a679efea71b41c07773c5cefa663728b";

    private final RestTemplate restTemplate = new RestTemplate();

    public OpenWeatherDto getBasicWeatherInfoForGivenCity(String city) {
        try {
            String URL = createUrlForGivenCity(city);
            return restTemplate.getForObject(URL, OpenWeatherDto.class);
        } catch (Exception e) {
            throw new NoCityFoundException();
        }
    }

    private String createUrlForGivenCity(String city) {
        return "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + APIkey;
    }
}
