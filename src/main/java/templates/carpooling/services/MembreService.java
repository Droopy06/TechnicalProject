package templates.carpooling.services;

import templates.carpooling.classes.Membre;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
public interface MembreService {
    List<Membre> listAllMembres();
    Membre getMemberById(long id);
    void saveMember(Membre membre);
    void updateInformation(Membre membre);
}
