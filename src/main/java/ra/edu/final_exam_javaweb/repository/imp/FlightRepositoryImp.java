package ra.edu.final_exam_javaweb.repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.final_exam_javaweb.model.Flight;
import ra.edu.final_exam_javaweb.repository.FlightRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Locale;
@Repository
public abstract class FlightRepositoryImp implements FlightRepository {
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

    @Override
    @Transactional
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
