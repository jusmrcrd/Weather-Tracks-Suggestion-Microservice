package TestApiRestfull.APiRest.Controller;

import TestApiRestfull.APiRest.Request.SpotifyLoginRequest;
import TestApiRestfull.APiRest.Response.SpotifyTrackResponse;
import TestApiRestfull.APiRest.Service.SpotifyAuthorService;

import TestApiRestfull.APiRest.Service.SpotifyTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1/spotify")
public class SpotifyController {

    @Autowired
    private SpotifyAuthorService spotifyAuthorService;

    @Autowired
    private SpotifyTrackService spotifyTrackService;

    @Value("${SPOTI_TYPE}")
    private String Type;

    @Value("${CLIENT_ID}")
    private String ClientID;

    @Value("${CLIENT_SECRET}")
    private String ClientSecret;

    public ResponseEntity<String> getkey(){
        SpotifyLoginRequest request = new SpotifyLoginRequest(Type,ClientID,ClientSecret);
        return spotifyAuthorService.Aurthorization(request);
    }

    public  ResponseEntity SpotifyTracks(String type){
        SpotifyLoginRequest request = new SpotifyLoginRequest(Type,ClientID,ClientSecret);

        String token = spotifyAuthorService.getAuthSpoty().login(request).getAccesstoken();

        SpotifyTrackResponse response = spotifyTrackService.getTrackClient().getTracksMusic("Bearer "+token,type);

        return spotifyTrackService.getTrackClient(response);
    }

}
