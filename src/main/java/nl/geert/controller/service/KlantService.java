/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.geert.controller.service;

import java.util.List;
import nl.geert.model.Klant;
import nl.geert.model.dao.factories.DaoFactory;

/**
 *
 * @author Geert
 */
public interface KlantService {
     void create(Klant klant);

    void update(Klant klant);

    Klant read(int id);
    
    Klant read(String voornaam, String achternaam);
    
//    Klant read(String postcode, int huisnummer);

    void delete(int id);
    
    void delete(String voornaam, String tussenvoegsel, String achternaam);
    
    void delete(String voornaam, String achternaam);
    
    List<Klant> getAll();
    
    public DaoFactory getDaoFactory();
    
    public void setDaoFactory(DaoFactory dao);
}
