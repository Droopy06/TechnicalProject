package templates.blabla.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Projet {
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String accueil() {
        return "carpooling/index";
    }
}
