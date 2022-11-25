package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.UserDto;

@Service
public class HtmlPageService {

    private final AirTicketService airTicketService;
    private final UserService userService;


    public HtmlPageService(AirTicketService airTicketService, UserService userService) {
        this.airTicketService = airTicketService;
        this.userService = userService;

    }

    public ModelAndView createFlightPage() {
        return airTicketService.getAllFlights();
    }

    public ModelAndView registrartion(UserDto userDto) {
        return userService.login(userDto);
    }
}


