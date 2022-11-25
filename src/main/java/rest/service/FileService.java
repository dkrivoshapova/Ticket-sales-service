package rest.service;

import org.springframework.stereotype.Service;
import rest.dto.FlightDto;
import rest.persistence.entity.Flight;
import rest.persistence.repository.AirTickerRepository;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


@Service
public class FileService {


    private final AirTickerRepository airTickerRepository;
    private final WorkFile workFile;


    public FileService(AirTickerRepository airTickerRepository, WorkFile workFile) {
        this.airTickerRepository = airTickerRepository;
        this.workFile = workFile;
    }

    public void uploadFile(String filename) throws IOException, ParseException {
        ArrayList<FlightDto> flightDTOS = workFile.readCSV(filename);
        addFlights(flightDTOS);
    }

    public void addFlights(ArrayList<FlightDto> flightDTOS) {
        for (FlightDto flightDTO : flightDTOS) {
            Flight flight = new Flight();
            flight.setNumber(flightDTO.getNumber());
            flight.setCityDeparture(flightDTO.getCityDeparture());
            flight.setCityArrival(flightDTO.getCityArrival());
            flight.setTimeDeparture(flightDTO.getTimeDeparture());
            flight.setTimeArrival(flightDTO.getTimeArrival());
            flight.setCost(flightDTO.getCost());
            flight.setSeats(flightDTO.getSeats());
            flight.setDaysOfWeek(flightDTO.getDaysOfWeek());
            airTickerRepository.save(flight);
        }
    }
}

