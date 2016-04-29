package templates.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import templates.carpooling.models.Itineraire;
import templates.carpooling.models.Membre;
import templates.carpooling.models.Reservation;
import templates.carpooling.services.ItineraireService;
import templates.carpooling.services.MembreService;
import templates.carpooling.services.ReservationService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 12/03/2016.
 */
@Controller
public class MembreController {

    @Autowired
    MembreService membreService;

    @Autowired
    ReservationService reservationService;

    @Autowired
    ItineraireService itineraireService;

    @RequestMapping(value = { "/connexion" }, method = RequestMethod.GET)
    public ModelAndView signIn(HttpSession httpSession) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        if(isConnect(httpSession))
            return new ModelAndView("redirect:/home",model);
        model.put("membre",new Membre());
        return new ModelAndView("carpooling/membre/connexion",model);
    }

    @RequestMapping(value = { "/connect" }, method = RequestMethod.POST)
    public ModelAndView signIn(@Valid @ModelAttribute Membre membre,
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
            httpSession.setAttribute("membre",membre1);
            return new ModelAndView("redirect:/home",model);
        }else {
            model.put("membre",membre);
            return new ModelAndView("carpooling/membre/connexion", model);
        }
    }

    @RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
    public String logout(HttpSession httpSession) {
        if(isConnect(httpSession))
            httpSession.setAttribute("membre",null);
        return "redirect:/home";
    }

    @RequestMapping(value = { "/inscription" }, method = RequestMethod.GET)
    public ModelAndView register(HttpSession httpSession) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        model.put("membre",new Membre());
        return new ModelAndView("carpooling/membre/inscription",model);
    }

    @RequestMapping(value = { "/inscription" }, method = RequestMethod.POST)
    public ModelAndView registerConfirm(@Valid @ModelAttribute Membre membre,
                                        BindingResult bindingResult) {
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
        membreService.saveMember(membre);
        return new ModelAndView("redirect:/connexion",model);
    }

    @RequestMapping(value = { "/account" }, method = RequestMethod.GET)
    public ModelAndView account(HttpSession httpSession) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        if(isConnect(httpSession)){
            Membre membre = (Membre) httpSession.getAttribute("membre");
            model.put("membre",httpSession.getAttribute("membre"));
            List<Reservation> reservations = reservationService.findAllReservationByMember(membre);
            List<Itineraire> itineraires = new ArrayList<>();
            for(Reservation reservation : reservations) {
                Itineraire itineraire = itineraireService.getItineraireById(reservation.getIdItineraire());
                itineraires.add(itineraire);
                reservation.setItineraire(itineraire);
            }
            model.put("reservations",reservations);
            model.put("itineraires",itineraires);
            return new ModelAndView("carpooling/membre/compte", model);
        }else {
            return new ModelAndView("redirect:/connexion", model);
        }
    }
    private boolean isConnect(HttpSession session){
        boolean isConnect = false;
        if(session.getAttribute("membre") != null){
            isConnect = (!session.getAttribute("membre").equals("")) ? true : false;
        }else
            isConnect = false;
        return isConnect;
    }
}
