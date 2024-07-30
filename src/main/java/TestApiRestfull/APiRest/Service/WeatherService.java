package TestApiRestfull.APiRest.Service;
import TestApiRestfull.APiRest.Entity.TimeEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import TestApiRestfull.APiRest.Model.WeatherKey;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    private static final List<JsonNode> jsonlist = new ArrayList<>();

    public static String getWheater(String local,String Key){
        String responsePost;

        WeatherKey we = new WeatherKey(local,Key);
        responsePost = RestClient.create().get()
                .uri(we.getCitytime())
                .retrieve()
                .body(String.class);

        //showTest(responsePost);
        return  responsePost;
    }

    public static String getWheater(String lat, String lon,String Key){
        String responsePost;

        WeatherKey weather = new WeatherKey(lat,lon,Key);
        responsePost = RestClient.create().get()
                .uri(weather.getLatLonTime())
                .retrieve()
                .body(String.class);

        //showTest(responsePost);
        return  responsePost;
    }


    @SneakyThrows
    public static TimeEntity BuidEntityTime(String tips){
        TimeEntity entity = new TimeEntity();
        var name = new ObjectMapper().readTree(tips).findPath("name").asText();
        var lat = new ObjectMapper().readTree(tips).findPath("coord").get("lat").asDouble();
        var lon = new ObjectMapper().readTree(tips).findPath("coord").get("lon").asDouble();
        var temp = new ObjectMapper().readTree(tips).findPath("main").get("temp_min").asDouble();

        entity.setCity(name);
        entity.setId(WeatherKey.getID(lon,lat));
        entity.setLon(lon);
        entity.setLat(lat);
        entity.setTemp(temp);


        return entity;
    }

}
