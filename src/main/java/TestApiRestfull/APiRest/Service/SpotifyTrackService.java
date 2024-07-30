package TestApiRestfull.APiRest.Service;

import TestApiRestfull.APiRest.Client.SpotfyGetTrackClient;
import TestApiRestfull.APiRest.Entity.SpotifyEntity.TrackEntity.Tracks;
import TestApiRestfull.APiRest.Response.SpotifyTrackResponse;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Data
public class SpotifyTrackService{

    @Autowired
    private SpotfyGetTrackClient TrackClient;

    @Transactional
    public ResponseEntity<ArrayList<Tracks>> getTrackClient(SpotifyTrackResponse trackResponse){
        return ResponseEntity.ok(trackResponse.getTracksList());
    }

}
