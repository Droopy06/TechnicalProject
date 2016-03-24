package templates.carpooling.services;

import templates.carpooling.models.Membre;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
public interface MembreService {
    List<Membre> listAllMembres();
    Membre getMemberById(long id);
    Membre getMemberByEmail(String email,String password);
    void saveMember(Membre membre);
    void updateInformation(Membre membre);
    String getTokenByUser();
    String sha256(String base);
    String getIpAdresse(HttpServletRequest request);
}
