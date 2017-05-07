/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.model.stage;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_einkauf_gel")
public class EinkaufGel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long ek_stn_gewicht;
    private double ek_stn_grundpreis;
    private double ek_stn_kg;
    private double ek_stn_maut;

    public long getEk_stn_gewicht() {
        return ek_stn_gewicht;
    }

    public void setEk_stn_gewicht(long ek_stn_gewicht) {
        this.ek_stn_gewicht = ek_stn_gewicht;
    }

    public double getEk_stn_grundpreis() {
        return ek_stn_grundpreis;
    }

    public void setEk_stn_grundpreis(double ek_stn_grundpreis) {
        this.ek_stn_grundpreis = ek_stn_grundpreis;
    }

    public double getEk_stn_kg() {
        return ek_stn_kg;
    }

    public void setEk_stn_kg(double ek_stn_kg) {
        this.ek_stn_kg = ek_stn_kg;
    }

    public double getEk_stn_maut() {
        return ek_stn_maut;
    }

    public void setEk_stn_maut(double ek_stn_maut) {
        this.ek_stn_maut = ek_stn_maut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EinkaufGel{" + "id=" + id + ", ek_stn_gewicht=" + ek_stn_gewicht + ", ek_stn_grundpreis=" + ek_stn_grundpreis + ", ek_stn_kg=" + ek_stn_kg + ", ek_stn_maut=" + ek_stn_maut + '}';
    }

}
