package templates.carpooling.dao;

import org.springframework.stereotype.Repository;
import templates.carpooling.models.Membre;
import templates.carpooling.models.Reservation;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
@Repository
public class ReservationMapperImpl implements ReservationMapper {
    @Override
    public List<Reservation> findAllReservationByMember(Membre membre) {
        return null;
    }

    @Override
    public List<Reservation> findAllReservation() {
        return null;
    }

    @Override
    public void saveReservation(Reservation reservation) {

    }

    @Override
    public void updateReservation(Reservation reservation) {

    }

    @Override
    public void removeReservation(Reservation reservation) {

    }
}