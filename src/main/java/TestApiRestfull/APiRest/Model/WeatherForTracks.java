package TestApiRestfull.APiRest.Model;

/*
    If temperature (celcius) is above 30 degrees, suggest tracks for party
    In case temperature is between 15 and 30 degrees, suggest pop music tracks
    If it's a bit chilly (between 10 and 14 degrees), suggest rock music tracks
    Otherwise, if it's freezing outside, suggests classical music tracks
*/


public class WeatherForTracks {

   public static String geTrackforTemp(Double time){
        if(time > 30){
          return "party";
        }else if(time >= 15) {
            return "pop";
        }else if(time >= 10){
            return "rock";
        }else{
            return "classical";
        }
   }

}
