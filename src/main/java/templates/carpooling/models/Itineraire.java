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
@Table(name="itineraire")
public class Itineraire {

    @Id
    @GeneratedValue
    private @Getter @Setter long id;
    private @Getter @Setter String departure;
    private @Getter @Setter String arrival;
    private @Getter @Setter long price;
    private @Getter @Setter int seat;


}
