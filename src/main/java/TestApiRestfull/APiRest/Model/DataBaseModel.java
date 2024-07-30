package TestApiRestfull.APiRest.Model;

import TestApiRestfull.APiRest.Entity.TimeEntity;
import TestApiRestfull.APiRest.Service.TimeService;
import TestApiRestfull.APiRest.Service.WeatherService;

public class DataBaseModel {
        public static TimeEntity isFundInDB(TimeService timeService, String locale, String lon, String lat){
            if(!timeService.getallTimes().isEmpty()) {
                if(locale != null){
                    if(timeService.findBycity(locale).isPresent())
                        return timeService.findBycity(locale).get();
                }else {
                    if(timeService.findByiD(WeatherKey.getID(Double.valueOf(lon), Double.valueOf(lat))).isPresent());
                        return timeService.findByiD(WeatherKey.getID(Double.valueOf(lon), Double.valueOf(lat))).get();
                }
            }
            return null;
        }

        public static String responsetype(String locale,String lon,String lat,String key){
            if (locale != null) {
                return WeatherService.getWheater(locale, key);
            } else{
                return WeatherService.getWheater(lat, lon, key);
            }
        }
}
