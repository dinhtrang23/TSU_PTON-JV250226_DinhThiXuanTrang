package ra.edu.final_exam_javaweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Flight")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Flight {
    @Id
    @Column(name = "flight_id", columnDefinition = "int(10)")
    private int flightId;
    @Column(name="flight_name",columnDefinition = "varchar(100)", nullable = false)
    private String flightName;
    @Column(name ="starting_point",columnDefinition = "varchar(255)", nullable = false)
    private String startingPoint;
    @Column(name ="destination",columnDefinition = "varchar(255)", nullable = false)
    private String destination;
    @Column(name = "departure_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;
    @Column(name ="travel_time",columnDefinition = "int(10)", nullable = false)
    private String travelTime;
    @Column(name ="time_unit",columnDefinition = "varchar(10)", nullable = false)
    private String timeUnit;
    @Column(name ="travel_image",columnDefinition = "varchar(255)", nullable = false)
    private String travelImage;
    @Column(name = "status", columnDefinition = "tinyint default 1")
    private int status;




}
