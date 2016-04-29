package templates.carpooling.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import templates.carpooling.HibernateUtil;
import templates.carpooling.models.Membre;
import templates.carpooling.models.Reservation;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
@Repository
public class ReservationMapperImpl implements ReservationMapper {

    private SessionFactory sessionFactory;

    @Override
    public List<Reservation> findAllReservationByMember(Membre membre) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Reservation> reservations = session.createQuery("from Reservation where idMembre="+membre.getId()).list();
        session.close();
        return reservations;
    }

    @Override
    public List<Reservation> findAllReservation() {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Reservation> reservations = session.createQuery("from Reservation").list();
        session.close();
        return reservations;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(reservation);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateReservation(Reservation reservation) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(reservation);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeReservation(Reservation reservation) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(reservation);
        session.getTransaction().commit();
        session.close();
    }
}
