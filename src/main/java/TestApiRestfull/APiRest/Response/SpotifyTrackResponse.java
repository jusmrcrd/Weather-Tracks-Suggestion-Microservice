package TestApiRestfull.APiRest.Response;

import TestApiRestfull.APiRest.Entity.SpotifyEntity.SeedEntity.Seeds;
import java.util.ArrayList;

import TestApiRestfull.APiRest.Entity.SpotifyEntity.TrackEntity.Tracks;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SpotifyTrackResponse {

    @JsonProperty("seeds")
    private ArrayList<Seeds> seedsList;

    @JsonProperty("tracks")
    private ArrayList<Tracks> tracksList;


}
