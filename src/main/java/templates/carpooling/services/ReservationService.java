package templates.carpooling.services;

import templates.carpooling.models.Membre;
import templates.carpooling.models.Reservation;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
public interface ReservationService {
    List<Reservation> findAllReservationByMember(Membre membre);
    List<Reservation> findAllReservation();
    void saveReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void removeReservation(Reservation reservation);
}
