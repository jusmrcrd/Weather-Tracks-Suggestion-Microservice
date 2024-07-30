package TestApiRestfull.APiRest.Model;

//Classe para passar a chave o link e  a info com latitude longitude ou localização


import io.github.cdimascio.dotenv.Dotenv;

public class WeatherKey {
    private String local;
    private String lat,lon;
    private  final String url  =  "http://api.openweathermap.org/data/2.5/weather?";

    private final String key;
    private  final String country = "pt_br";
    private  final String metricAndCallapiID = "BR&units=metric&APPID=";


    public WeatherKey(String local, String key){
        this.local = local;
        this.key = key;
    }

    public WeatherKey(String lat, String lon, String key){
        this.lat = lat;
        this.lon = lon;
        this.key = key;
    }

    public String getCitytime(){
        return String.format("%s%s%s,%s,%s%s",url,"q=",local,country,metricAndCallapiID,key);
    }

    public String getLatLonTime(){
        return String.format("%s%s%s&%s%s&%s,%s%s",url,"lon=",lon,"lat=",lat,country,metricAndCallapiID,key);
    }


    //(lat + 46) * 10000 + (lon + 91) * 900000
    //Metodo retorna o calculo para setar o campo ID da entidade Time sem causar colisão
    //usando um calculo para fazer um deslocamento decimal
    public static long getID(Double lon ,Double lat){
        return (long) (((lat + 46)*100000) + ((lon + 91)*90000));
    }


}
