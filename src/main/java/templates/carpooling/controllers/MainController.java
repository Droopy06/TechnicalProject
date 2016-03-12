package templates.carpooling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String accueil() {
        return "carpooling/home";
    }

}
