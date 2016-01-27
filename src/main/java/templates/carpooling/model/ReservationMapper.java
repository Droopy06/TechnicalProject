package templates.carpooling.model;

import templates.carpooling.classes.Membre;
import templates.carpooling.classes.Reservation;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
public interface ReservationMapper {
    List<Reservation> findAllReservationByMember(Membre membre);
    List<Reservation> findAllReservation();
    void saveReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void removeReservation(Reservation reservation);
}
