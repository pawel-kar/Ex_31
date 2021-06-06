package pl.pelikan.weatherinthecity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherController {

    WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String redirectToHomePage() {
        return "home";
    }

    @PostMapping("/city")
    public String getWeatherForCity(Model model, @RequestParam(value = "city_name") String city) {
        model.addAttribute("city", city);
        model.addAttribute("weather", weatherService.getBasicWeatherInfoForGivenCity(city));
        return "weatherinfo";
    }

    @ExceptionHandler(NoCityFoundException.class)
    public String handleException() {
        return "nocityfound";
    }
}
