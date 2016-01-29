package templates.carpooling.models;

/**
 * Created by prog on 27/01/2016.
 */
public class Membre {

    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String ip;
    private String adresse;
    private int age;
    private boolean isHaveCar;

    public Membre() {
        this.id = 1L;
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.ip = "127:0:0:1";
        this.adresse = "";
        this.age = 1;
        this.isHaveCar = false;
    }

    public Membre(long id, String nom, String prenom, String email, String ip, String adresse, int age, boolean isHaveCar) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.ip = ip;
        this.adresse = adresse;
        this.age = age;
        this.isHaveCar = isHaveCar;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHaveCar() {
        return isHaveCar;
    }

    public void setHaveCar(boolean haveCar) {
        isHaveCar = haveCar;
    }
}
