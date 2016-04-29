package templates.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import templates.carpooling.services.ItineraireService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by LAMOOT Alexandre on 28/04/2016.
 */
@Controller
public class TrajetController {

    @Autowired
    ItineraireService itineraireService;

    @RequestMapping(value = { "/trajets" }, method = RequestMethod.GET)
    public ModelAndView trajets() {
        HashMap<String,Object> model = new HashMap<String,Object>();
        model.put("trajets",itineraireService.findAllItenaire());
        return new ModelAndView("carpooling/trajets/list-trajets",model);
    }

    @RequestMapping(value = { "/trajet/{trajet}" }, method = RequestMethod.GET)
    public ModelAndView trajet(@PathVariable(value = "trajet") long idTrajet) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        model.put("trajet",itineraireService.getItineraireById(idTrajet));
        return new ModelAndView("carpooling/trajets/trajet",model);
    }


}
