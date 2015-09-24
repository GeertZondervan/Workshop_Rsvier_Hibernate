/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.geert.model.dao.factories;

import nl.geert.model.dao.AdresDao;
import nl.geert.model.dao.AdresDaoXml;
import nl.geert.model.dao.KlantDao;
import nl.geert.model.dao.KlantDaoXml;

/**
 *
 * @author Geert
 */
public class XmlDaoFactory extends DaoFactory{
    public KlantDao getKlantDao(){
        return new KlantDaoXml();
    }
    
     public AdresDao getAdresDao(){
        return new AdresDaoXml();
    }
}
