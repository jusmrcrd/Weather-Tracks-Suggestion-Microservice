package TestApiRestfull.APiRest.Client;

import TestApiRestfull.APiRest.Response.SpotifyTrackResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "SpotfyGetTrack",
        url = "https://api.spotify.com"
)

public interface SpotfyGetTrackClient {
    @GetMapping(value = "/v1/recommendations?limit=10&seed_genres={val}")
    SpotifyTrackResponse getTracksMusic(@RequestHeader("Authorization") String authorization, @RequestParam(value = "val") String val);

}
