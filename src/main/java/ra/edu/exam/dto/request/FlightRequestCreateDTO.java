package ra.edu.exam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightRequestCreateDTO {
    @NotBlank(message = "Flight Id is required")
    private int flightId;
    @NotBlank(message = "Flight Name is required")
    private String flightName;
    @NotBlank(message = "Starting Point is required")
    private String startingPoint;
    @NotBlank(message = "Destination is required")
    private String destination;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;
    private String travelTime;
    private String timeUnit;
    private MultipartFile file ;
    private byte status;
}
