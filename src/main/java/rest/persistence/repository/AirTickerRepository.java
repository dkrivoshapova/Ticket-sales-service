package rest.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import rest.persistence.entity.Flight;

import java.util.List;

@Repository
public interface AirTickerRepository extends JpaRepository<Flight, Integer> {

    @Query(value = "select f.id, number, cityDeparture, cityArrival, timeDeparture, timeArrival, cost, DAYNAME(date) as date "
            + "from flights as f "
            + "join dates d on f.id = d.flight_id ", nativeQuery = true)
    List<Flight> findAllFlights();
}
