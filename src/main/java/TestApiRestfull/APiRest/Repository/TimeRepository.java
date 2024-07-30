package TestApiRestfull.APiRest.Repository;
import TestApiRestfull.APiRest.Entity.TimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TimeRepository extends JpaRepository<TimeEntity,Long> {
    public Optional<TimeEntity> findBycity(String city);
    public Optional<TimeEntity> findByid(long id);
}
