package entity.model.stage;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_pr_preisliste_A")
public class BasisPL implements Serializable {
    
	private static final long serialVersionUID = 4759648628942058831L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String laender_kz;
    private long preislistenNr;
    @OneToOne
    private Gewichtklasse gewichtklasse;
    private String service;
    private double zone1;
    private double zone2;
    private double zone3;
    private double zone4;
    private double zone5;
    private double zone6;
    private double reserve;
    private double preisJeKG;
    private String preisIndex;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLaender_kz() {
        return laender_kz;
    }

    public void setLaender_kz(String laender_kz) {
        this.laender_kz = laender_kz;
    }

    public long getPreislistenNr() {
        return preislistenNr;
    }

    public void setPreislistenNr(long preislistenNr) {
        this.preislistenNr = preislistenNr;
    }

    public Gewichtklasse getGewichtklasse() {
        return gewichtklasse;
    }

    public void setGewichtklasse(Gewichtklasse gewichtklasse) {
        this.gewichtklasse = gewichtklasse;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getZone1() {
        return zone1;
    }

    public void setZone1(double zone1) {
        this.zone1 = zone1;
    }

    public double getZone2() {
        return zone2;
    }

    public void setZone2(double zone2) {
        this.zone2 = zone2;
    }

    public double getZone3() {
        return zone3;
    }

    public void setZone3(double zone3) {
        this.zone3 = zone3;
    }

    public double getZone4() {
        return zone4;
    }

    public void setZone4(double zone4) {
        this.zone4 = zone4;
    }

    public double getZone5() {
        return zone5;
    }

    public void setZone5(double zone5) {
        this.zone5 = zone5;
    }

    public double getZone6() {
        return zone6;
    }

    public void setZone6(double zone6) {
        this.zone6 = zone6;
    }

    public double getReserve() {
        return reserve;
    }

    public void setReserve(double reserve) {
        this.reserve = reserve;
    }

    public double getPreisJeKG() {
        return preisJeKG;
    }

    public void setPreisJeKG(double preisJeKG) {
        this.preisJeKG = preisJeKG;
    }

    public String getPreisIndex() {
        return preisIndex;
    }

    public void setPreisIndex(String preisIndex) {
        this.preisIndex = preisIndex;
    }

    @Override
    public String toString() {
        return "BasisPL{" + "id=" + id + ", laender_kz=" + laender_kz + ", preislistenNr=" + preislistenNr + ", gewichtklasse=" + gewichtklasse + ", service=" + service + ", zone1=" + zone1 + ", zone2=" + zone2 + ", zone3=" + zone3 + ", zone4=" + zone4 + ", zone5=" + zone5 + ", zone6=" + zone6 + ", reserve=" + reserve + ", preisJeKG=" + preisJeKG + ", preisIndex=" + preisIndex + '}';
    }
    
    
    
}
