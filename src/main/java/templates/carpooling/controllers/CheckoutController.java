package templates.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import templates.carpooling.models.Membre;
import templates.carpooling.services.ItineraireService;
import templates.carpooling.services.MembreService;
import templates.carpooling.services.ReservationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 28/04/2016.
 */
@Controller
public class CheckoutController {

    @Autowired
    ItineraireService itineraireService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    MembreService membreService;

    @RequestMapping(value = { "/checkout/{trajet}" }, method = RequestMethod.GET)
    public ModelAndView trajetEtape1(@PathVariable(value = "trajet") long idTrajet) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        model.put("trajet",itineraireService.getItineraireById(idTrajet));
        return new ModelAndView("carpooling/checkout/etape1",model);
    }

    @RequestMapping(value = { "/checkout/2/{trajet}" }, method = RequestMethod.GET)
    public ModelAndView trajetEtape2(@PathVariable(value = "trajet") long idTrajet) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        model.put("trajet",itineraireService.getItineraireById(idTrajet));
        model.put("membre",new Membre());
        return new ModelAndView("carpooling/checkout/etape2",model);
    }

    @RequestMapping(value = { "checkout/connexion/{trajet}" }, method = RequestMethod.POST)
    public ModelAndView signIn(@PathVariable(value = "trajet") long idTrajet,
                               @Valid @ModelAttribute Membre membre,
                               BindingResult bindingResult,
                               HttpSession httpSession) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            String erreur = "";
            for (FieldError error : errors ) {
                erreur += "Le champs "+error.getField() + " - " + error.getDefaultMessage();
            }
            model.put("erreur",erreur);//Liste d'objets erreur.
            model.put("membre",membre);
            return new ModelAndView("carpooling/membre/connexion",model);
        }
        Membre membre1 = membreService.getMemberByEmail(membre.getEmail(),membre.getPassword());
        if(membre1.getNom() != null && membre1.isActif()){
            httpSession.setAttribute("membreCheckout",membre1);
            return new ModelAndView("redirect:/checkout/3/",model);
        }else {
            model.put("membre",membre);
            return new ModelAndView("carpooling/membre/connexion", model);
        }
    }

    @RequestMapping(value = { "/checkout/identification/inscription" }, method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute Membre membre) {


        HashMap<String,Object> model = new HashMap<String,Object>();
        model.put("membre",membre);
        return new ModelAndView("carpooling/membre/inscription",model);
    }
}
