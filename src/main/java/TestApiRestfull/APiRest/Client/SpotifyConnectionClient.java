package TestApiRestfull.APiRest.Client;

import TestApiRestfull.APiRest.Request.SpotifyLoginRequest;
import TestApiRestfull.APiRest.Response.SpotifyLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(
        name = "SpotfyConnectionClient",
        url = "https://accounts.spotify.com"
)
public interface SpotifyConnectionClient {

    @PostMapping(value = "/api/token",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    SpotifyLoginResponse login(@RequestBody SpotifyLoginRequest request);

}
