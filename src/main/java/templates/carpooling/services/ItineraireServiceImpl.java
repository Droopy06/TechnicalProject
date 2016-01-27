package templates.carpooling.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import templates.carpooling.classes.Itineraire;
import templates.carpooling.model.ItineraireMapper;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
@Service
public class ItineraireServiceImpl implements ItineraireService{

    @Autowired
    ItineraireMapper itineraireMapper;

    @Override
    public List<Itineraire> findAllItenaire() {
        return itineraireMapper.findAllItenaire();
    }

    @Override
    public void saveItineaire(Itineraire itineraire) {
        itineraireMapper.saveItineaire(itineraire);
    }

    @Override
    public Itineraire getItineraireById(long id) {
        return itineraireMapper.getItineraireById(id);
    }

    @Override
    public void updateItineraireById(Itineraire itineraire) {
        itineraireMapper.updateItineraireById(itineraire);
    }
}
