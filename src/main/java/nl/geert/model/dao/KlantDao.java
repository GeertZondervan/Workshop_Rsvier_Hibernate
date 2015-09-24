
package nl.geert.model.dao;

import java.util.List;
import nl.geert.model.Klant;

/**
 *
 * @author Geert
 */
public interface KlantDao {

    void create(Klant klant);

    void update(Klant klant);

    Klant read(int id);
    
    Klant read(String voornaam, String achternaam);
    
//    Klant read(String postcode, int huisnummer);

    void delete(int id);
    
    void delete(String voornaam, String tussenvoegsel, String achternaam);
    
    void delete(String voornaam, String achternaam);
    
    List<Klant> getAll();


}
