package templates.carpooling.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
@Entity   
@Table(name="Reservation")
public class Reservation {

    @Id
    @GeneratedValue
    private @Getter @Setter long id;
    private @Getter @Setter long idItineraire;
    private @Getter @Setter long idMembre;
    private @Getter @Setter long price;
    private @Getter @Setter int seat;
    private @Getter @Setter String modePaiement;

}
