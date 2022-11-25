package rest.service;

import org.springframework.stereotype.Service;
import rest.dto.FlightDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkFile {

    private final String dirPath = "/Users/darakrivosapova/Downloads/Telegram Desktop/web-template 2/files/";

    public ArrayList<FlightDto> readCSV(String filename) throws IOException {
        String filePath = dirPath + filename;
        ArrayList<FlightDto> flights = new ArrayList<FlightDto>();
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                List<String> daysOfWeek = List.of(row[7].split(","));
                FlightDto account = new FlightDto(row[0], row[1], row[2], row[3], row[4], row[5],row[6], row[7], daysOfWeek);
                flights.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return flights;
    }
}
