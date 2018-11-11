package myapp.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.exceptions.UnirestException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import myapp.javaObjects.Weather;
import myapp.weatherApi.WeatherApi;


@RestController
@RequestMapping("/weatherService")
@Api(value= "WeatherServiceApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class WeatherService {
//	EntityManager manager = EntityManagerHelper.getEntityManager();
	
	@Autowired
	private WeatherApi weatherApi;
	@Autowired
	private Weather weather;

	@GetMapping(value = "/city/{city}")
	@ApiOperation("get weather with spicific id")
	@ApiResponse(code=200,message="Ok",response=WeatherApi.class)
	
	public List<Weather> getWeather(@PathVariable("city") String city)throws UnirestException {
		Integer daysNumber = weather.getDaysNumber();
		List<Weather> result = weatherApi.getListWeather(city, daysNumber);
		//System.out.println(result);
		return result;
	}
}
