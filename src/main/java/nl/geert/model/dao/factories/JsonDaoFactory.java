
package nl.geert.model.dao.factories;

import nl.geert.model.dao.AdresDao;
import nl.geert.model.dao.AdresDaoJson;
import nl.geert.model.dao.KlantDao;
import nl.geert.model.dao.KlantDaoJson;

/**
 *
 * @author Geert
 */
public class JsonDaoFactory extends DaoFactory {
    public KlantDao getKlantDao(){
        return new KlantDaoJson();
    }
    
    public AdresDao getAdresDao(){
        return new AdresDaoJson();
    }
}
