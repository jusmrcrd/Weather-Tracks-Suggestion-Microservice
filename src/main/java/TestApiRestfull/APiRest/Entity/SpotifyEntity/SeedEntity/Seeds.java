package TestApiRestfull.APiRest.Entity.SpotifyEntity.SeedEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seeds {

    private Integer afterFilteringSize;
    private Integer afterRelinkingSize;
    private String href;
    private String id;
    private Integer initialPoolSize;
    private String type;

}
