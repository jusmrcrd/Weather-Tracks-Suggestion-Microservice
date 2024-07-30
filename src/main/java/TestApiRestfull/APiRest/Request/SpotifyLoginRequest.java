package TestApiRestfull.APiRest.Request;

import feign.form.FormProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpotifyLoginRequest {

    @FormProperty("grant_type")
    private String grantype;

    @FormProperty("client_id")
    private String clientid;

    @FormProperty("client_secret")
    private String clientsecret;

}
