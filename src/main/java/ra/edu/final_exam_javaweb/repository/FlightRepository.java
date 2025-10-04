package ra.edu.final_exam_javaweb.repository;

import ra.edu.final_exam_javaweb.model.Flight;

import java.util.List;

public interface FlightRepository {
    List<Flight> findAll();
    Flight findById(int id);
    boolean create(Flight flight);
    boolean update(Flight flight);
    boolean delete(String flightId);
}
