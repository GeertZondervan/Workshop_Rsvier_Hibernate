/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.geert.controller.service;

import java.util.List;
import nl.geert.model.Adres;
import nl.geert.model.dao.factories.DaoFactory;

/**
 *
 * @author Geert
 */
public interface AdresService {
     void create(Adres adres);

    void update(Adres adres);

    Adres read(int id);

    Adres read(String postcode, int huisnummer);

    void delete(int id);

    List<Adres> getAll();
    
    public DaoFactory getDaoFactory();
    
    public void setDaoFactory(DaoFactory dao);
}
