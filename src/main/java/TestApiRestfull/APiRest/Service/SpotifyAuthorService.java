package TestApiRestfull.APiRest.Service;

import TestApiRestfull.APiRest.Client.SpotifyConnectionClient;
import TestApiRestfull.APiRest.Request.SpotifyLoginRequest;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class SpotifyAuthorService {

    @Autowired
    private SpotifyConnectionClient AuthSpoty;


    @Transactional
    public ResponseEntity<String> Aurthorization(SpotifyLoginRequest auth){
        return ResponseEntity.ok(AuthSpoty.login(auth).getAccesstoken());
    }


}
