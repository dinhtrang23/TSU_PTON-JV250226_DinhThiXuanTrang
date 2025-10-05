package ra.edu.exam.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.exam.model.Flight;
import ra.edu.exam.repository.FlightRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FlightRepositoryImp implements FlightRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Flight> findAll() {
        return entityManager.createQuery("from Flight", Flight.class).getResultList();
    }

    @Override
    @Transactional
    public boolean create(Flight flight) {
        try{
            entityManager.persist(flight);
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }
    @Override
    @Transactional
    public boolean update(Flight flight) {
        try{
            entityManager.merge(flight);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    @Override
    public boolean delete(int flightId) {
        try{
            Flight flight = findById(flightId);
            entityManager.remove(flight);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
