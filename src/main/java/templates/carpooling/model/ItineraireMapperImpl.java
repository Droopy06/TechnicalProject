package templates.carpooling.model;

import org.springframework.stereotype.Repository;
import templates.carpooling.classes.Itineraire;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
@Repository
public class ItineraireMapperImpl implements ItineraireMapper {
    @Override
    public List<Itineraire> findAllItenaire() {
        return null;
    }

    @Override
    public void saveItineaire(Itineraire itineraire) {

    }

    @Override
    public Itineraire getItineraireById(long id) {
        return null;
    }

    @Override
    public void updateItineraireById(Itineraire itineraire) {

    }
}
