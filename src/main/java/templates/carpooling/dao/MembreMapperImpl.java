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
public class MembreMapperImpl implements MembreMapper{

    private SessionFactory sessionFactory;

    @Override
    public List<Membre> listAllMembres() {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Membre> membres = session.createQuery("from Membre").list();
        session.close();
        return membres;
    }

    @Override
    public Membre getMemberById(long id) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Membre> membres = session.createQuery("from Membre where id="+id).list();
        session.close();
        return membres.get(0);
    }

    @Override
    public Membre getMemberByEmail(String email, String password) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Membre> membres = session.createQuery("from Membre where email='"+email+"' and password='"+password+"'").list();
        session.close();
        return membres.get(0);
    }

    @Override
    public void saveMember(Membre membre) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(membre);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateInformation(Membre membre) {
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(membre);
        session.getTransaction().commit();
        session.close();
    }
}
