package nl.geert.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nl.geert.controller.HibernateUtil;
import nl.geert.model.Adres;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Geert
 */
public class AdresDaoHibernate implements AdresDao {

    @Override
    public void create(Adres adres) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(adres);
        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    @Override
    public void update(Adres adres) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.merge(adres);

        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    @Override
    public Adres read(int id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            return (Adres) session.get(Adres.class, id);
        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    @Override
    public Adres read(String postcode, int huisnummer) {
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            String sql = "SELECT p FROM Adres p WHERE p.postcode = :postcode AND p.huisnummer = :huisnummer";
            Query query = session.createQuery(sql).setParameter("postcode", postcode).setParameter("huisnummer", huisnummer);

            Adres adres = (Adres) query.uniqueResult();

            return adres;

        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    public int getAdresId(String postcode, int huisnummer) throws SQLException {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            String sql = "SELECT p FROM Klant p WHERE p.postcode = :postcode AND p.huisnummer = :huisnummer";
            Query query = session.createQuery(sql).setParameter("postcode", postcode).setParameter("huisnummer", huisnummer);
            try {
                Adres adres = (Adres) query.uniqueResult();
                if (adres != null) {
                    return adres.getAdres_id();
                } else {
                    return -1;
                }
            } catch (Exception ex) {
                List<Adres> list = query.list();
                return list.get(list.size() - 1).getAdres_id();
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
            Adres adres = (Adres) session.get(Adres.class, id);
            session.delete(adres);
        } finally {
            HibernateUtil.commitAndCloseSession(session);
        }
    }

    @Override
    public List<Adres> getAll() {
        List<Adres> adresList = new ArrayList<Adres>();
        Session session = HibernateUtil.getSession();

        try {
            session.beginTransaction();
            Criteria crit = session.createCriteria(Adres.class);
            adresList = crit.list();
        } finally {
            HibernateUtil.commitAndCloseSession(session);

        }
        return adresList;
    }

}
