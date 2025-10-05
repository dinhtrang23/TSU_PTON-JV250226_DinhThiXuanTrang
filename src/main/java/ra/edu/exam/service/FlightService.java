package ra.edu.exam.service;

import ra.edu.exam.dto.request.FlightRequestCreateDTO;
import ra.edu.exam.model.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findAll();
    Flight findById(int id);
    boolean create(FlightRequestCreateDTO flight);

    boolean update(Flight flight);

    boolean delete(Flight flightId);
}
