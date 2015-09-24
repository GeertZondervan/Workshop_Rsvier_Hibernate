
package nl.geert.model.dao.factories;

import nl.geert.model.dao.AdresDao;
import nl.geert.model.dao.KlantDao;


/**
 *
 * @author Geert
 */
public abstract class DaoFactory {
    
    //list of DAO types
    public static final int HIBERNATE = 1;
    public static final int JSON = 2;
    public static final int XML = 3;
    public static final int MYSQL = 4;
    
    public abstract KlantDao getKlantDao();
    public abstract AdresDao getAdresDao();
    
    public static DaoFactory getDaoFactory(int whichFactory){
        switch(whichFactory){
            case HIBERNATE: return new HibernateDaoFactory();
            case JSON: return new JsonDaoFactory();
            case XML: return new XmlDaoFactory();
            case MYSQL: return new MySqlDaoFactory();
            default: return null;
        }
    }
}
