package ra.edu.final_exam_javaweb.service;

import ra.edu.final_exam_javaweb.dto.request.FlightRequestCreateDTO;
import ra.edu.final_exam_javaweb.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findAll();
    Flight findById(int id);
    boolean create(FlightRequestCreateDTO flight);
    boolean update(Flight flight);
    boolean delete(int id);
}
