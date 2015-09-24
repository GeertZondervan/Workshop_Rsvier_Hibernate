
package nl.geert.model.dao.factories;

import nl.geert.model.dao.AdresDao;
import nl.geert.model.dao.AdresDaoMySql;
import nl.geert.model.dao.KlantDao;
import nl.geert.model.dao.KlantDaoMySql;

/**
 *
 * @author Geert
 */
public class MySqlDaoFactory extends DaoFactory {
    public KlantDao getKlantDao(){
        return new KlantDaoMySql();
    }
    
     public AdresDao getAdresDao(){
        return new AdresDaoMySql();
    }
}
