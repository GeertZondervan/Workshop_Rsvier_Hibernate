package nl.geert.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Geert
 */
@Entity
public class Klant implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int klant_id;
    private String voornaam;
    private String achternaam;
    private String tussenvoegsel;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresId")
    private Adres adres;
 

    
    public int getKlant_id() {
        return klant_id;
    }

    public void setKlant_id(int klant_id) {
        this.klant_id = klant_id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 53 * hash + Objects.hashCode(this.voornaam);
        hash = 53 * hash + Objects.hashCode(this.achternaam);
        hash = 53 * hash + Objects.hashCode(this.tussenvoegsel);
        hash = 53 * hash + Objects.hashCode(this.email);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Klant other = (Klant) obj;
       
        if (!Objects.equals(this.voornaam, other.voornaam)) {
            return false;
        }
        if (!Objects.equals(this.achternaam, other.achternaam)) {
            return false;
        }
        if (!Objects.equals(this.tussenvoegsel, other.tussenvoegsel)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }

        return true;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
  
   
}
