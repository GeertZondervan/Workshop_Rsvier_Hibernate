
package nl.geert.controller.service;

import java.util.List;
import nl.geert.model.Klant;
import nl.geert.model.dao.factories.DaoFactory;

/**
 *
 * @author Geert
 */
public class KlantServiceImpl implements KlantService {
    private DaoFactory daoFactory;
    
    
    @Override
    public void create(Klant klant) throws IllegalArgumentException {
        if(klant.getEmail() == null){
            throw new IllegalArgumentException("Klant not complete");
        }
       daoFactory.getKlantDao().create(klant);
    }

    @Override
    public void update(Klant klant) {
        daoFactory.getKlantDao().update(klant);
    }

    @Override
    public Klant read(int id) {
        Klant klant = daoFactory.getKlantDao().read(id);
        if (klant == null){
            throw new NullPointerException("klant not found");
        }
        return klant;
    }

    @Override
    public Klant read(String voornaam, String achternaam) {
        Klant klant = daoFactory.getKlantDao().read(voornaam, achternaam);
        if (klant == null){
            throw new NullPointerException("klant not found");
        }
        return klant;
    }

//    @Override
//    public Klant read(String postcode, int huisnummer) {
//       Klant klant = daoFactory.getKlantDao().read(postcode, huisnummer);
//        if (klant == null){
//            throw new NullPointerException("klant not found");
//        }
//        return klant;
//    }

    @Override
    public void delete(int id) {
        daoFactory.getKlantDao().delete(id);
    }

    @Override
    public void delete(String voornaam, String tussenvoegsel, String achternaam) {
        daoFactory.getKlantDao().delete(voornaam, tussenvoegsel, achternaam);
    }

    @Override
    public void delete(String voornaam, String achternaam) {
        daoFactory.getKlantDao().delete(voornaam, achternaam);
    }

    @Override
    public List<Klant> getAll() {
        return daoFactory.getKlantDao().getAll();
    }

    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory dao) {
        this.daoFactory = dao;
    }

    
}
