package templates.carpooling.model;

import org.springframework.stereotype.Repository;
import templates.carpooling.classes.Membre;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
@Repository
public class MembreMapperImpl implements MembreMapper{
    @Override
    public List<Membre> listAllMembres() {
        return null;
    }

    @Override
    public Membre getMemberById(long id) {
        return null;
    }

    @Override
    public void saveMember(Membre membre) {

    }

    @Override
    public void updateInformation(Membre membre) {

    }
}
