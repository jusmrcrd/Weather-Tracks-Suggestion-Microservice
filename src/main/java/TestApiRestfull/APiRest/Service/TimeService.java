package TestApiRestfull.APiRest.Service;
import TestApiRestfull.APiRest.Repository.TimeRepository;
import TestApiRestfull.APiRest.Entity.TimeEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class TimeService {
    @Autowired
    public TimeRepository timeRep;

    @Transactional
    public TimeEntity saveTime(TimeEntity timeEntity){
        return timeRep.save(timeEntity);
    }

    @Transactional
    public List<TimeEntity> getallTimes(){
        return timeRep.findAll();
    }

    @Transactional
    public Optional<TimeEntity> findBycity(String city){
        return timeRep.findBycity(city);
    }

    @Transactional
    public Optional<TimeEntity> findByiD(long id){return  timeRep.findByid(id);}

    @Transactional
    public void dellByID(Long id){
        timeRep.deleteById(id);
    }

    @Transactional
    public void purgeAll(){
        timeRep.deleteAll();
    }

}
