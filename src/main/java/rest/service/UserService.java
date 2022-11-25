package rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import rest.dto.UserDto;
import rest.persistence.entity.User;
import rest.persistence.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AirTicketService airTicketService;

    public UserService(UserRepository userRepository, AirTicketService airTicketService) {
        this.userRepository = userRepository;
        this.airTicketService = airTicketService;
    }

    public ModelAndView login(UserDto userDto) {

        System.out.println(userDto.getEmail());
        System.out.println(userDto.getPassword());
        if (userDto.getEmail().equals("") || userDto.getPassword().equals("")) {
            return LoginExcepPage();
        }
        List<User> userInfo = userRepository.findAllUser();
        for (User user : userInfo) {
            if (userDto.getEmail().equals(user.getEmail())) {
                if (userDto.getPassword().equals(user.getPassword())) {
                    return airTicketService.getAllFlights();
                }
            }
        }
        return LoginExcepPage();
    }


    private ModelAndView createAdminPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    private ModelAndView LoginExcepPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.setViewName("exception-login");
        modelAndView.getModel().put("message", "неправильный логин или пароль"); // иньекция значений на страницу
        return modelAndView;
    }
}