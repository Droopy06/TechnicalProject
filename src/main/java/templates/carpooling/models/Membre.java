package templates.carpooling.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by prog on 27/01/2016.
 */
@Entity
@Table(name="membre")
public class Membre {
    @Id
    @GeneratedValue
    private @Getter @Setter long id;
    private @Getter @Setter String nom;
    private @Getter @Setter String prenom;
    @NotNull @Size(min = 8,max = 250)
    private @Getter @Setter String email;
    @NotNull @Size(min = 8,max = 250)
    private @Getter @Setter String password;
    private @Getter @Setter String ip;
    private @Getter @Setter String adresse;
    private @Getter @Setter int age;
    private @Getter @Setter boolean isHaveCar;
    private @Getter @Setter String token;
    private @Getter @Setter String telephone;
    private @Getter @Setter boolean actif;
}
