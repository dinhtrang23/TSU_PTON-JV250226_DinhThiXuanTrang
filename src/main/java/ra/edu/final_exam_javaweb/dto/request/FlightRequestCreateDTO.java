package ra.edu.final_exam_javaweb.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FlightRequestCreateDTO {
    @NotBlank(message = "Flight Id is required")
    private String flightId;
    @NotBlank(message = "Flight Name is required")
    private String flightName;

}
