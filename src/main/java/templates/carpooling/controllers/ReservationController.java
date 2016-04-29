package templates.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import templates.carpooling.services.ReservationService;

import java.util.HashMap;

/**
 * Created by LAMOOT Alexandre on 22/04/2016.
 */
@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value = { "/reservations" }, method = RequestMethod.GET)
    public ModelAndView signIn() {
        HashMap<String,Object> model = new HashMap<String,Object>();
        model.put("reservations",reservationService.findAllReservation());
        return new ModelAndView("carpooling/membre/connexion",model);
    }
}
