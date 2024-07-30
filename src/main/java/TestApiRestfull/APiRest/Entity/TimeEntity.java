package TestApiRestfull.APiRest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="time")
public class TimeEntity {
    @Id
    private Long id;

    @Column(name="Cityname",unique = true)
    private String city;

    @Column(name="Lon")
    private Double lon;

    @Column(name="Lat")
    private Double lat;

    @Column(name="Temp_min")
    private Double temp;

    @Column(name="Create_by")
    private LocalDateTime createBy = LocalDateTime.now();

    @Column(name="Create_byPcok")
    private long epoch = Instant.now().getEpochSecond();
}
