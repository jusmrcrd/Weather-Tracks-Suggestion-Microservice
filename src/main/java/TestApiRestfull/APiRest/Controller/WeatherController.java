package TestApiRestfull.APiRest.Controller;

import TestApiRestfull.APiRest.Client.SpotfyGetTrackClient;
import TestApiRestfull.APiRest.Entity.TimeEntity;
import TestApiRestfull.APiRest.Model.DataBaseModel;
import TestApiRestfull.APiRest.Model.WeatherForTracks;
import TestApiRestfull.APiRest.Service.WeatherService;
import TestApiRestfull.APiRest.Service.TimeService;

import jakarta.transaction.Transactional;

import lombok.SneakyThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class WeatherController {
    @Autowired
    private TimeService timeService;

    @Autowired
    private SpotifyController spotifyController;

    @Autowired
    private SpotfyGetTrackClient spotfyGetTrackClient;

    @Value("${API_KEY}")
    public String key;


    @SneakyThrows
    @PostMapping("/post/wheater")
    @ResponseBody
    public ResponseEntity GetWheater(@RequestParam(required = false) String locale,
                                     @RequestParam(required = false) String lon,
                                     @RequestParam(required = false) String lat){
        String responsePost = null;
        TimeEntity selectedDB =  DataBaseModel.isFundInDB(timeService,locale,lon,lat);
        Double type = 0.0;


        if(selectedDB == null) {
            responsePost = DataBaseModel.responsetype(locale, lon, lat, key);
            type = WeatherService.BuidEntityTime(responsePost).getTemp();
        }else{
            type = selectedDB.getTemp();
        }

        if(responsePost != null) {
            saveTime(responsePost);
        }

        return spotifyController.SpotifyTracks(WeatherForTracks.geTrackforTemp(type));
    }


    @Transactional
    public ResponseEntity saveTime(String responsePost){
        TimeEntity time = WeatherService.BuidEntityTime(responsePost);

        timeService.saveTime(time);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/all/results")
    public List<TimeEntity> getAllTime(){
        return timeService.getallTimes();
    }


    @DeleteMapping("/dell")
    public ResponseEntity dellByID(@RequestParam long id){
        timeService.dellByID(id);
        return ResponseEntity.ok(HttpStatus.GONE);
    }

}
