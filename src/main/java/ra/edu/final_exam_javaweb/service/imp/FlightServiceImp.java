package ra.edu.final_exam_javaweb.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.final_exam_javaweb.dto.request.FlightRequestCreateDTO;
import ra.edu.final_exam_javaweb.model.Flight;
import ra.edu.final_exam_javaweb.repository.FlightRepository;
import ra.edu.final_exam_javaweb.service.FlightService;
import ra.edu.final_exam_javaweb.service.UploadFileService;

import java.util.List;

@Service
public abstract class FlightServiceImp implements FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private UploadFileService uploadFileService;
    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

   // @Override
  //  public boolean create(FlightRequestCreateDTO flightDto) {
     //   String imageUrl = uploadFileService.uploadFile(FlightDto.getFile);
      //  Flight flight = new Flight();
      //  flightDto.getFlightName(),
   // }

}
