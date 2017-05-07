package entity.model.mirror;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "TBL_PREISLISTE_A", schema = "fak2")
public class MirrorPreisliste implements Serializable {

	private static final long serialVersionUID = -1816664762060121898L;

	@Id
    private Long id;
    private String laender_kz;
    private Long preisListenNr;
    private long gewicht_klasse;
    private String service;
    /*zoneX as 123.00€  Suffix '€'*/
    private double zone1;
    private double zone2;
    private double zone3;
    private double zone4;
    private double zone5;
    private double zone6;
    private double reserve;
    private double preisJeKg;
    private String preisIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLaender_kz() {
        return laender_kz;
    }

    public void setLaender_kz(String laender_kz) {
        this.laender_kz = laender_kz;
    }

    public Long getPreisListenNr() {
        return preisListenNr;
    }

    public void setPreisListenNr(Long preisListenNr) {
        this.preisListenNr = preisListenNr;
    }

    public long getGewicht_klasse() {
        return gewicht_klasse;
    }

    public void setGewicht_klasse(long gewicht_klasse) {
        this.gewicht_klasse = gewicht_klasse;
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

    public double getPreisJeKg() {
        return preisJeKg;
    }

    public void setPreisJeKg(double preisJeKg) {
        this.preisJeKg = preisJeKg;
    }

    public String getPreisIndex() {
        return preisIndex;
    }

    public void setPreisIndex(String preisIndex) {
        this.preisIndex = preisIndex;
    }

    @Override
    public String toString() {
        return "Preisliste{" + "id=" + id + ", laender_kz=" + laender_kz + ", preisListenNr=" + preisListenNr + ", gewicht_klasse=" + gewicht_klasse + ", service=" + service + ", zone1=" + zone1 + ", zone2=" + zone2 + ", zone3=" + zone3 + ", zone4=" + zone4 + ", zone5=" + zone5 + ", zone6=" + zone6 + ", reserve=" + reserve + ", preisJeKg=" + preisJeKg + ", preisIndex=" + preisIndex + '}';
    }

}
