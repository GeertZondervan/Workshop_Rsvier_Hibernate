package nl.geert.model.dao;

import com.sun.xml.internal.messaging.saaj.util.XMLDeclarationParser;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nl.geert.model.Klant;

/**
 *
 * @author Geert
 */
public class KlantDaoXml implements KlantDao {

    List<Klant> list = new ArrayList<>();
    File file = new File("d:\\klanten.xml");

    @Override
    public void create(Klant klant) {
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                XMLDecoder xmlDec = new XMLDecoder(bis);
                list = (List<Klant>) xmlDec.readObject();
                xmlDec.close();
            }
            list.add(klant);
            //convert user object to json string, and save to a file
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEnc = new XMLEncoder(bos);
            xmlEnc.writeObject(list);
            xmlEnc.close();

        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }

    @Override
    public void update(Klant klant) {
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDec = new XMLDecoder(bis);
            list = (List<Klant>) xmlDec.readObject();

            for (Klant klantje : list) {
                if (klantje.getKlant_id() == klant.getKlant_id()) {
                    klantje.setVoornaam(klant.getVoornaam());
                    klantje.setAchternaam(klant.getAchternaam());
                    klantje.setTussenvoegsel(klant.getTussenvoegsel());
                    klantje.setEmail(klant.getEmail());

                }
            }
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEnc = new XMLEncoder(bos);
            xmlEnc.writeObject(list);
            xmlEnc.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Klant read(int id) {
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDec = new XMLDecoder(bis);
            list = (List<Klant>) xmlDec.readObject();
            xmlDec.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Klant klant = null;
        for (Klant klantje : list) {
            if (klantje.getKlant_id() == id) {
                klant = klantje;
            }

        }
        return klant;
    }

    @Override
    public Klant read(String voornaam, String achternaam) {
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDec = new XMLDecoder(bis);
            list = (List<Klant>) xmlDec.readObject();
            xmlDec.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Klant klant = null;
        for (Klant klantje : list) {
            if (klantje.getVoornaam().equals(voornaam) && klantje.getAchternaam().equals(achternaam)) {
                klant = klantje;
            }

        }
        return klant;
    }

//    @Override
//    public Klant read(String postcode, int huisnummer) {
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            BufferedInputStream bis = new BufferedInputStream(fis);
//            XMLDecoder xmlDec = new XMLDecoder(bis);
//            list = (List<Klant>) xmlDec.readObject();
//            xmlDec.close();
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        Klant klant = null;
//        for (Klant klantje : list) {
//            if (klantje.getPostcode().equals(postcode) && (klantje.getHuisnummer() == huisnummer)) {
//                klant = klantje;
//            }
//
//        }
//        return klant;
//    }

    @Override
    public void delete(int id) {
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDec = new XMLDecoder(bis);
            list = (List<Klant>) xmlDec.readObject();
            xmlDec.close();

            List<Klant> copy = new ArrayList<>(list);
            for (Klant klantje : list) {
                if (klantje.getKlant_id() == id) {
                    copy.remove(klantje);
                }
            }

            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEnc = new XMLEncoder(bos);
            xmlEnc.writeObject(copy);
            xmlEnc.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(String voornaam, String tussenvoegsel, String achternaam) {
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDec = new XMLDecoder(bis);
            list = (List<Klant>) xmlDec.readObject();
            xmlDec.close();

            List<Klant> copy = new ArrayList<>(list);
            for (Klant klantje : list) {
                if (klantje.getVoornaam().equals(voornaam) && klantje.getTussenvoegsel().equals(tussenvoegsel) && klantje.getAchternaam().equals(achternaam)) {
                    copy.remove(klantje);
                }
            }

            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEnc = new XMLEncoder(bos);
            xmlEnc.writeObject(copy);
            xmlEnc.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String voornaam, String achternaam) {
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDec = new XMLDecoder(bis);
            list = (List<Klant>) xmlDec.readObject();
            xmlDec.close();

            List<Klant> copy = new ArrayList<>(list);
            for (Klant klantje : list) {
                if (klantje.getVoornaam().equals(voornaam) && klantje.getAchternaam().equals(achternaam)) {
                    copy.remove(klantje);
                }
            }

            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            XMLEncoder xmlEnc = new XMLEncoder(bos);
            xmlEnc.writeObject(copy);
            xmlEnc.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Klant> getAll() {
        list = null;

        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDec = new XMLDecoder(bis);
            list = (List<Klant>) xmlDec.readObject();
            xmlDec.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
