package entity.model.mirror;

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
@Table(name = "tbl_stn_service", schema = "fak2")
public class MirrorService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String service;
    private String system;
    private String bezeichnung;
    private long ergaenz_kto;
    private long ergaknt_ab;
    private long kst;
    private String tabelle_preis;
    private double minimum_kalku;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public long getErgaenz_kto() {
        return ergaenz_kto;
    }

    public void setErgaenz_kto(long ergaenz_kto) {
        this.ergaenz_kto = ergaenz_kto;
    }

    public long getErgaknt_ab() {
        return ergaknt_ab;
    }

    public void setErgaknt_ab(long ergaknt_ab) {
        this.ergaknt_ab = ergaknt_ab;
    }

    public long getKst() {
        return kst;
    }

    public void setKst(long kst) {
        this.kst = kst;
    }

    public String getTabelle_preis() {
        return tabelle_preis;
    }

    public void setTabelle_preis(String tabelle_preis) {
        this.tabelle_preis = tabelle_preis;
    }

    public double getMinimum_kalku() {
        return minimum_kalku;
    }

    public void setMinimum_kalku(double minimum_kalku) {
        this.minimum_kalku = minimum_kalku;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", service=" + service + ", system=" + system + ", bezeichnung=" + bezeichnung + ", ergaenz_kto=" + ergaenz_kto + ", ergaknt_ab=" + ergaknt_ab + ", kst=" + kst + ", tabelle_preis=" + tabelle_preis + ", minimum_kalku=" + minimum_kalku + '}';
    }

}
