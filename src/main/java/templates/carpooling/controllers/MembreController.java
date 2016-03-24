package templates.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import templates.carpooling.models.Membre;
import templates.carpooling.services.MembreService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * Created by LAMOOT Alexandre on 12/03/2016.
 */
@Controller
public class MembreController {

    @Autowired
    MembreService membreService;

    @RequestMapping(value = { "/connexion" }, method = RequestMethod.GET)
    public ModelAndView signIn(HttpSession httpSession) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        if(isConnect(httpSession))
            return new ModelAndView("redirect:/home",model);
        model.put("membre",new Membre());
        return new ModelAndView("carpooling/signin",model);
    }

    @RequestMapping(value = { "/connect" }, method = RequestMethod.POST)
    public ModelAndView signIn(@Valid @ModelAttribute Membre membre,
                               BindingResult bindingResult,
                                HttpSession httpSession) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        if(bindingResult.hasErrors()){
            model.put("erreur",bindingResult.getAllErrors());//Liste d'objets erreur.
            model.put("membre",membre);
            return new ModelAndView("carpooling/signin",model);
        }
        Membre membre1 = membreService.getMemberByEmail(membre.getEmail(),membre.getEmail());
        if(membre1.getNom() != null){
            httpSession.setAttribute("membre",membre1);
            return new ModelAndView("redirect:/home",model);
        }else {
            model.put("membre",membre);
            return new ModelAndView("carpooling/signin", model);
        }
    }


    @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView registerUser() {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("membre",new Membre());
        return new ModelAndView("carpooling/create",model);
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute @Valid Membre membre,
                            BindingResult bindingResult) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        if(bindingResult.hasErrors()){
            model.put("erreur",bindingResult.getAllErrors());//Liste d'objets erreur.
            model.put("membre",membre);
            return new ModelAndView("carpooling/create",model);
        }
        membreService.saveMember(membre);
        return new ModelAndView("redirect:/connexion",model);
    }

    @RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
    public String logout(HttpSession httpSession) {
        if(isConnect(httpSession))
            httpSession.setAttribute("membre",null);
        return "redirect:/home";
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
