package ra.edu.exam.repository;

import org.springframework.transaction.annotation.Transactional;
import ra.edu.exam.model.Flight;

import java.util.List;

public interface FlightRepository {
    List<Flight> findAll();
    Flight findById(int id);
    boolean create(Flight flight);
    boolean update(Flight flight);
    boolean delete(int flightId);

}
