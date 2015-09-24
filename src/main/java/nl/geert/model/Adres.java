package nl.geert.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 *
 * @author Geert
 */
@Entity
public class Adres implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adres_id;
    private String straatnaam;
    private String postcode;
    private String toevoeging;
    private int huisnummer;
    private String woonplaats;
    
    @OneToMany(mappedBy = "adres", fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
    @OrderBy("id")
   // @JoinTable(name = "Adres_has_klanten")
    private Set<Klant> klanten = new LinkedHashSet<>();

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.adres_id;
        hash = 23 * hash + Objects.hashCode(this.straatnaam);
        hash = 23 * hash + Objects.hashCode(this.postcode);
        hash = 23 * hash + Objects.hashCode(this.toevoeging);
        hash = 23 * hash + this.huisnummer;
        hash = 23 * hash + Objects.hashCode(this.woonplaats);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adres other = (Adres) obj;
        if (this.adres_id != other.adres_id) {
            return false;
        }
        if (!Objects.equals(this.straatnaam, other.straatnaam)) {
            return false;
        }
        if (!Objects.equals(this.toevoeging, other.toevoeging)) {
            return false;
        }
        if (this.huisnummer != other.huisnummer) {
            return false;
        }
        if (!Objects.equals(this.woonplaats, other.woonplaats)) {
            return false;
        }
        return true;
    }

    public Set<Klant> getKlanten() {
        return klanten;
    }

    public void setKlanten(Set<Klant> klanten) {
        this.klanten = klanten;
    }


}
