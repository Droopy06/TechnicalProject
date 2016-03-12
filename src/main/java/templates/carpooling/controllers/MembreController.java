package templates.carpooling.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by LAMOOT Alexandre on 12/03/2016.
 */
@Controller
public class MembreController {

    @RequestMapping(value = { "/connexion" }, method = RequestMethod.GET)
    public ModelAndView signIn(HttpSession httpSession) {
        HashMap<String,Object> model = new HashMap<String,Object>();
        if(isConnect(httpSession))
            return new ModelAndView("redirect:/account",model);
        return new ModelAndView("carpooling/signin",model);
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
