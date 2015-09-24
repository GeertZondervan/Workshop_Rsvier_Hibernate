package nl.geert.model.dao;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import nl.geert.controller.AppFunctionality;
import nl.geert.controller.connection.DBConnect;
import nl.geert.model.Klant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Geert
 */
public class KlantDaoMySql implements KlantDao {

    private static CachedRowSet crs;
    private Connection con;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private AppFunctionality functions = new AppFunctionality();

//    public void setConnection(String url, String user, String password) {
//        DBConnect.setUrl(url);
//        DBConnect.setUser(user);
//        DBConnect.setPassword(password);
 //   }

//    public void setCrs() {
//        try {
//            crs = new CachedRowSetImpl();
//            if (hikariSelected) {
//                con = DBConnect.connectWithHikari();
//            } else {
//                con = DBConnect.connectWithC3p0();
//            }
//        } catch (SQLException ex) {
//            log.error("Cannot create crs", ex);
//
//        }
//    }

    @Override
    public void create(Klant klant) {
        try {
            log.info("Creating Klant {} {} \n", klant.getVoornaam(), klant.getAchternaam());
            crs = functions.setCrs();
            con = functions.getConnection();
            crs.setCommand("insert into oefen_opdracht_db.Klant (voornaam, achternaam, tussenvoegsel, email, straatnaam, postcode, toevoeging, huisnummer, woonplaats) VALUES ( '"
                    + klant.getVoornaam() + "', '" + klant.getAchternaam() + "', '" + klant.getTussenvoegsel() + "', '" + klant.getEmail() +  "')");
            crs.execute(con);
        } catch (Exception ex) {
            log.error("Cannot insert Klant into database \n", ex);
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

    @Override
    public void update(Klant klant) {
        try {
            log.info("Updating Klant {} {}\n", klant.getVoornaam(), klant.getAchternaam());
            crs = functions.setCrs();
            con = functions.getConnection();
            crs.setCommand("UPDATE Klant set voornaam = '" + klant.getVoornaam() + "', achternaam = '" + klant.getAchternaam() + "', tussenvoegsel = '" + klant.getTussenvoegsel()
                    + "', email = '" + klant.getEmail() + "', straatnaam = '" +  "' where klant_id = " + klant.getKlant_id());
            crs.execute(con);
            while (crs.next()) {
                System.out.println(crs.getString(2));
            }
        } catch (Exception ex) {
            log.error("Cannot Update Klant {} {}\n", klant.getVoornaam(), klant.getAchternaam(), ex);
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

    @Override
    public Klant read(int id) {
        Klant klant = new Klant();
        try {
            log.info("Reading Klant with id {}\n", id);
            crs = functions.setCrs();
            con = functions.getConnection();
            crs.setCommand("SELECT voornaam, achternaam, tussenvoegsel, email, straatnaam, postcode, toevoeging, huisnummer, woonplaats FROM  Klant WHERE klant_id = '" + id + "';");
            crs.execute(con);
            while (crs.next()) {
                klant.setVoornaam(crs.getString(1));
                klant.setAchternaam(crs.getString(2));
                klant.setTussenvoegsel(crs.getString(3));
                klant.setEmail(crs.getString(4));
               

            }
        } catch (Exception ex) {
            log.error("Cannot read Klant with klantId {}\n", id, ex);
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
        return klant;
    }

    @Override
    public Klant read(String voornaam, String achternaam) {
        Klant klant = new Klant();
        klant.setVoornaam(voornaam);
        klant.setAchternaam(achternaam);
        try {
            log.info("Reading Klant {} {}\n", voornaam, achternaam);
            crs = functions.setCrs();
            con = functions.getConnection();
            crs.setCommand("SELECT klant_id, tussenvoegsel, email, straatnaam, postcode, toevoeging, huisnummer, woonplaats FROM  Klant WHERE voornaam = '"
                    + voornaam + "'AND achternaam = '" + achternaam + "';");
            crs.execute(con);
            while (crs.next()) {
                klant.setKlant_id(crs.getInt(1));
                klant.setTussenvoegsel(crs.getString(2));
                klant.setEmail(crs.getString(3));
            
            }
        } catch (Exception ex) {
            log.error("Cannot read Klant {} {}\n", voornaam, achternaam, ex);
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

        return klant;

    }

    

    @Override
    public void delete(int id) {
        try {
            log.info("Deleting Klant with klantId {}\n", id);
            crs = functions.setCrs();
            con = functions.getConnection();
            crs.setCommand("DELETE FROM Klant WHERE klant_id = '" + id + "';");
            crs.execute(con);

        } catch (Exception ex) {
            log.error("Cannot delete Klant\n", ex);
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

    @Override
    public void delete(String voornaam, String tussenvoegsel, String achternaam) {
        try {
            log.info("Deleting Klant {} {} {}\n", voornaam, tussenvoegsel, achternaam);
            crs = functions.setCrs();
            con = functions.getConnection();
            crs.setCommand("DELETE FROM Klant WHERE voornaam = '" + voornaam + "' AND tussenvoegsel = '" + tussenvoegsel + "' AND achternaam = '" + achternaam + "';");
            crs.execute(con);

        } catch (Exception ex) {
            log.error("Cannot delete Klant\n", ex);
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

    @Override
    public void delete(String voornaam, String achternaam) {
        try {
            log.info("Deleting Klant {} {}\n", voornaam, achternaam);
            crs = functions.setCrs();
            con = functions.getConnection();
            crs.setCommand("DELETE FROM Klant WHERE voornaam = '" + voornaam + "' AND achternaam = '" + achternaam + "';");
            crs.execute(con);

        } catch (Exception ex) {
            log.error("Cannot delete Klant\n", ex);
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

    public void voerSQLUit(String sqlQuery) {
        try {
            log.info("Executing SQL Query\n");
            crs = functions.setCrs();
            con = functions.getConnection();
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

    @Override
    public List<Klant> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
