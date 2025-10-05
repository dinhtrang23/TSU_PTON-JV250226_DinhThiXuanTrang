package ra.edu.exam.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.exam.dto.request.FlightRequestCreateDTO;
import ra.edu.exam.model.Flight;
import ra.edu.exam.repository.FlightRepository;
import ra.edu.exam.service.FlightService;
import ra.edu.exam.service.UploadFileService;

import java.util.List;

@Service
public class FlightServiceImp implements FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private UploadFileService uploadFileService;
    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findById(int id) {
        return flightRepository.findById(id);
    }


    @Override
    public boolean create(FlightRequestCreateDTO flightDto) {
        String imageUrl = uploadFileService.uploadFile(flightDto.getFile());
        Flight flight = new Flight(
                flightDto.getFlightId(),
                flightDto.getFlightName(),
                flightDto.getStartingPoint(),
                flightDto.getDestination(),
                flightDto.getDepartureDate(),
                flightDto.getTravelTime(),
                flightDto.getTimeUnit(),
                imageUrl,
                (byte) 1);
        return flightRepository.create(flight);
    }

    @Override
    public boolean update(Flight flight) {
        return false;
    }

    @Override
    public boolean delete(Flight id) {
        return false;
    }

    @Override
    public boolean update(FlightRequestCreateDTO flightDto) {
        // 1. Lấy product cũ
        Flight flight = flightRepository.findById(flightDto.getFlightId());
        if (flight == null) return false;

        // 2. Update tên, giá, catalog, created
        flight.setFlightName(flightDto.getFlightName());
        flight.setStartingPoint(flightDto.getStartingPoint());
        flight.setDestination(flightDto.getDestination());
        flight.setCreated(flightDto.getDepartureDate());
        flight.setStatus(flightDto.getStatus());

        // 3. Upload file mới nếu có
        if (flightDto.getFile() != null && !flightDto.getFile().isEmpty()) {
            String imageUrl = uploadFileService.uploadFile(flightDto.getFile());
            flight.setTravelImage(imageUrl);
        }

        return flightRepository.update(flight);
    }

    @Override
    public boolean delete(String productId) {
        return flightRepository.delete(productId);
    }
}


