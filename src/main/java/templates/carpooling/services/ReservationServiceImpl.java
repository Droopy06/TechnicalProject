package templates.carpooling.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import templates.carpooling.classes.Membre;
import templates.carpooling.classes.Reservation;
import templates.carpooling.model.ReservationMapper;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationMapper reservationMapper;

    @Override
    public List<Reservation> findAllReservationByMember(Membre membre) {
        return reservationMapper.findAllReservationByMember(membre);
    }

    @Override
    public List<Reservation> findAllReservation() {
        return reservationMapper.findAllReservation();
    }

    @Override
    public void saveReservation(Reservation reservation) {
        reservationMapper.saveReservation(reservation);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        reservationMapper.updateReservation(reservation);
    }

    @Override
    public void removeReservation(Reservation reservation) {
        reservationMapper.removeReservation(reservation);
    }
}
