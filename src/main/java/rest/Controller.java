package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
//import rest.dto.PlaneDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rest.dto.UserDto;
import rest.service.FileService;
import rest.service.HtmlPageService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.UUID;

/**
 * Класс в котором описываются http методы (АПИ), методы вызываются с фронта
 **/
@RestController
public class Controller {


    @Autowired
    private HtmlPageService htmlPageService;
    @Autowired
    private FileService fileService;


    /**
     * Пример метода который будет вызываться по URL: http://localhost:8080
     * метод возвращает html страницу, "resources/templates/welcome.html"
     **/
    @GetMapping(value = "/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        return htmlPageService.createFlightPage();
    }

    @PostMapping("/")
    public void handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes, HttpServletResponse response) throws IOException, ParseException {
        fileService.uploadFile(file.getOriginalFilename());
        response.sendRedirect("/");
    }

    @GetMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.clear();
        modelAndView.setViewName("login"); // указываю какую страницу вернуть
        return modelAndView;
    }
    @PostMapping(value = "/login")
    public ModelAndView checkUser(UserDto userDto) {
        return htmlPageService.registrartion(userDto);
    }

}
