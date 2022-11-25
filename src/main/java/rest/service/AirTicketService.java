package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.FlightDto;
import rest.persistence.entity.Flight;
import rest.persistence.repository.AirTickerRepository;

import java.util.*;

@Service
public class AirTicketService {

    private final AirTickerRepository airTickerRepository;

    public AirTicketService(AirTickerRepository userRepository) {
        this.airTickerRepository = userRepository;
    }

    public ModelAndView getAllFlights() {
        List<Flight> flights = airTickerRepository.findAll();
        Set<FlightDto> resultList = new HashSet<>();
        for (Flight flight : flights) {
            FlightDto flightDTO = new FlightDto();
            flightDTO.setNumber(flight.getNumber());
            flightDTO.setCost(flight.getCost().toString());
            flightDTO.setCityDeparture(flight.getCityDeparture());
            flightDTO.setCityArrival(flight.getCityArrival());
            flightDTO.setTimeArrival(flight.getTimeArrival().toString());
            flightDTO.setTimeDeparture(flight.getTimeDeparture().toString());
            flightDTO.setDaysOfWeek(flight.getDaysOfWeek());
            resultList.add(flightDTO);
        }
        return createAndFillModel(resultList);
    }

    private ModelAndView createAndFillModel(Set<FlightDto> flightDTOs) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.getModel().put("listFlights", flightDTOs);
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

}
