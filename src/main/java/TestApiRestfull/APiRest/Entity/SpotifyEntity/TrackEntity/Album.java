package TestApiRestfull.APiRest.Entity.SpotifyEntity.TrackEntity;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Album {
    private String albumType;
    private Integer totalTracks;
    //private ArrayList<String> availableMarkets;
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private ArrayList<ImageObject> images;
    private String name;
    private String releaseDate;
    private String releaseDatePrecision;
    private Restrictions restrictions;
    private String type;
    private String uri;
    private ArrayList<Artists> artistsList;
}
