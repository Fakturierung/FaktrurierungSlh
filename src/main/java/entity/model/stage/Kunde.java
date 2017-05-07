package entity.model.stage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Kunde
 *
 * @author ngj
 */
@Entity
@Table(name = "TBL_KUNDE_SL")
public class Kunde implements Serializable {

	private static final long serialVersionUID = 8762472225803986170L;

	@Id
    private Long id;

    private long preisl_sl_nr;
    private String sl_krz;
    private String system;
    private double sl_preis_vk;
    private double sl_preis_vk_neu;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum_preiswechsel;
    private String user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date time_stamp;
    private String leistungs_typ;
    /*berechnete Attribute*/
    private long kunde_sl_idx;
    private long system_idx;

    @OneToMany
    @JoinColumn(name = "KUNDE")
    private List<Artikel> kunden_artikel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPreisl_sl_nr() {
        return preisl_sl_nr;
    }

    public void setPreisl_sl_nr(long preisl_sl_nr) {
        this.preisl_sl_nr = preisl_sl_nr;
    }

    public String getSl_krz() {
        return sl_krz;
    }

    public void setSl_krz(String sl_krz) {
        this.sl_krz = sl_krz;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public double getSl_preis_vk() {
        return sl_preis_vk;
    }

    public void setSl_preis_vk(double sl_preis_vk) {
        this.sl_preis_vk = sl_preis_vk;
    }

    public double getSl_preis_vk_neu() {
        return sl_preis_vk_neu;
    }

    public void setSl_preis_vk_neu(double sl_preis_vk_neu) {
        this.sl_preis_vk_neu = sl_preis_vk_neu;
    }

    public Date getDatum_preiswechsel() {
        return datum_preiswechsel;
    }

    public void setDatum_preiswechsel(Date datum_preiswechsel) {
        this.datum_preiswechsel = datum_preiswechsel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(Date time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getLeistungs_typ() {
        return leistungs_typ;
    }

    public void setLeistungs_typ(String leistungs_typ) {
        this.leistungs_typ = leistungs_typ;
    }

    public long getKunde_sl_idx() {
        return kunde_sl_idx;
    }

    public void setKunde_sl_idx(long kunde_sl_idx) {
        this.kunde_sl_idx = kunde_sl_idx;
    }

    public long getSystem_idx() {
        return system_idx;
    }

    public void setSystem_idx(long system_idx) {
        this.system_idx = system_idx;
    }

    public List<Artikel> getKunden_artikel() {
        return kunden_artikel;
    }

    public void setKunden_artikel(List<Artikel> kunden_artikel) {
        this.kunden_artikel = kunden_artikel;
    }

}
