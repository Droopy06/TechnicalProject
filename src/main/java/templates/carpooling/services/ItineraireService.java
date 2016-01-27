package templates.carpooling.services;

import templates.carpooling.classes.Itineraire;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
public interface ItineraireService {
    List<Itineraire> findAllItenaire();
    void saveItineaire(Itineraire itineraire);
    Itineraire getItineraireById(long id);
    void updateItineraireById(Itineraire itineraire);
}
