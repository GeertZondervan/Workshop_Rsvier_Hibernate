
package nl.geert.model.dao.factories;

import nl.geert.model.dao.AdresDao;
import nl.geert.model.dao.AdresDaoHibernate;
import nl.geert.model.dao.KlantDao;
import nl.geert.model.dao.KlantDaoHibernate;

/**
 *
 * @author Geert
 */
public class HibernateDaoFactory extends DaoFactory {
    public KlantDao getKlantDao(){
        return new KlantDaoHibernate();
    }
    
    public AdresDao getAdresDao(){
       return new AdresDaoHibernate();
    }
}
