package nl.geert.controller;


import com.sun.rowset.CachedRowSetImpl;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import nl.geert.controller.connection.DBConnect;
import nl.geert.model.Klant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Geert
 */
public class AppFunctionality {

    private CachedRowSet crs;
    private Connection con;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private static boolean hikariSelected = true;

    public void setConnection(String url, String user, String password) {
        DBConnect.setUrl(url);
        DBConnect.setUser(user);
        DBConnect.setPassword(password);
    }

    public CachedRowSet setCrs() {
        try {
            crs = new CachedRowSetImpl();
            if (hikariSelected) {
                con = DBConnect.connectWithHikari();
            } else {
                con = DBConnect.connectWithC3p0();
            }
        } catch (SQLException ex) {
            log.error("Cannot create crs", ex);

        }
        return crs;
    }
    
    public Connection getConnection(){       
        return con;
    }



    public void voerSQLUit(String sqlQuery) {
        try {
            log.info("Executing SQL Query\n");
            setCrs();
            crs.setCommand(sqlQuery);
            crs.execute(con);
        } catch (Exception ex) {
            log.error("Cannot execute Query {}\n", sqlQuery, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                    con = null;
                } catch (SQLException ex) {
                    log.error("Cannot close connection \n", con.toString());
                }
            }
        }
    }


    public boolean isHikariSelected() {
        return hikariSelected;
    }


    public void setHikariSelected(boolean hikariSelected) {
        this.hikariSelected = hikariSelected;
    }

  
    
    
}
