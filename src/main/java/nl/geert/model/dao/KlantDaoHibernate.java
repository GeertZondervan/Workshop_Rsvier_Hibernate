
package nl.geert.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nl.geert.controller.HibernateUtil;
import nl.geert.model.Klant;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Geert
 */
public class KlantDaoHibernate implements KlantDao {

    @Override
    public void create(Klant klant) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(klant);
           // session.save(klant.getAdres());
        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    @Override
    public void update(Klant klant) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.merge(klant);
           // session.merge(klant.getAdres());
        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    @Override
    public Klant read(int id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            return (Klant) session.get(Klant.class, id);
        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    @Override
    public Klant read(String voornaam, String achternaam) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            String sql = "SELECT p FROM Klant p WHERE p.voornaam = :voornaam AND p.achternaam = :achternaam";
            Query query = session.createQuery(sql).setParameter("voornaam", voornaam).setParameter("achternaam", achternaam);

            Klant klant = (Klant) query.uniqueResult();

            return klant;

        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    public int getKlantId(String voornaam, String achternaam) throws SQLException {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            String sql = "SELECT p FROM Klant p WHERE p.voornaam = :voornaam AND p.achternaam = :achternaam";
            Query query = session.createQuery(sql).setParameter("voornaam", voornaam).setParameter("achternaam", achternaam);
            try {
                Klant klant = (Klant) query.uniqueResult();
                if (klant != null) {
                    return klant.getKlant_id();
                } else {
                    return -1;
                }
            } catch (Exception ex) {
                List<Klant> list = query.list();
                return list.get(list.size() - 1).getKlant_id();
            }

        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    @Override
    public void delete(int id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Klant klant = (Klant) session.get(Klant.class, id);
            session.delete(klant);
        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    @Override
    public void delete(String voornaam, String tussenvoegsel, String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String voornaam, String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Klant> getAll() {
        List<Klant> klanten = new ArrayList<Klant>();
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Criteria crit = session.createCriteria(Klant.class);
            klanten = crit.list();
        } finally {
            HibernateUtil.commitAndCloseSession(session);

        }
        return klanten;
    }
}
