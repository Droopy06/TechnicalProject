package templates.carpooling.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by LAMOOT Alexandre on 28/04/2016.
 */
@Entity
@Table(name = "notation")
public class Notation {
    @GeneratedValue @Id
    private @Getter @Setter long id;
    private @Getter @Setter long idReservation;
    private @Getter @Setter int note;
    private @Getter @Setter String commentaire;
    private @Getter @Setter boolean recommandation;
}
