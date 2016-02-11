package templates.carpooling.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import templates.carpooling.HibernateUtil;
import templates.carpooling.models.Itineraire;

import java.util.List;

/**
 * Created by LAMOOT Alexandre on 27/01/2016.
 */
@Repository
public class ItineraireMapperImpl implements ItineraireMapper {

    private SessionFactory sessionFactory;

    @Override
    public List<Itineraire> findAllItenaire() {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Itineraire> itineraires = session.createQuery("from Itineraire").list();
        session.close();
        return itineraires;
    }

    @Override
    public void saveItineaire(Itineraire itineraire) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(itineraire);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Itineraire getItineraireById(long id) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Itineraire> itineraires = session.createQuery("from Itineraire where id="+id).list();
        session.close();
        return itineraires.get(0);
    }

    @Override
    public void updateItineraireById(Itineraire itineraire) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(itineraire);
        session.getTransaction().commit();
        session.close();
    }
}
