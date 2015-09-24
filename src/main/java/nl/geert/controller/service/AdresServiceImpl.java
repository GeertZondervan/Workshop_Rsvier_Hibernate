package nl.geert.controller.service;

import java.util.List;
import nl.geert.model.Adres;
import nl.geert.model.dao.factories.DaoFactory;

/**
 *
 * @author Geert
 */
public class AdresServiceImpl implements AdresService {

    private DaoFactory daoFactory;

    @Override
    public void create(Adres adres) {
        if (adres.getHuisnummer() == 0 || adres.getStraatnaam() == null) {
            throw new IllegalArgumentException("Klant not complete");
        }
        daoFactory.getAdresDao().create(adres);
    }

    @Override
    public void update(Adres adres) {
        if (adres.getHuisnummer() == 0 || adres.getStraatnaam() == null) {
            throw new IllegalArgumentException("Klant not complete");
        }
        daoFactory.getAdresDao().update(adres);
    }

    @Override
    public Adres read(int id) {
        Adres adres = daoFactory.getAdresDao().read(id);
        if (adres == null) {
            throw new NullPointerException("klant not found");
        }
        return adres;
    }

    @Override
    public Adres read(String postcode, int huisnummer) {
        Adres adres = daoFactory.getAdresDao().read(postcode, huisnummer);
        if (adres == null) {
            throw new NullPointerException("klant not found");
        }
        return adres;
    }

    @Override
    public void delete(int id) {
        daoFactory.getAdresDao().delete(id);
    }

    @Override
    public List<Adres> getAll() {
        return daoFactory.getAdresDao().getAll();
    }

    @Override
    public DaoFactory getDaoFactory() {
        return daoFactory;
    }

    @Override
    public void setDaoFactory(DaoFactory dao) {
        this.daoFactory = dao;
    }

}
