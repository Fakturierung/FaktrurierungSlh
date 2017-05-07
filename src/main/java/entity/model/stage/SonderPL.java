package entity.model.stage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_stn_kunde_sl")
public class SonderPL implements Serializable {

	private static final long serialVersionUID = 2598408982756839378L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long preisl_sl_nr;
    private String sl_krz;
    private String system;
    private double sl_preis_vk;
    private double sl_preis_vk_neu;
    @Column(name = "datum_PreisWechsel")
    @Temporal(TemporalType.DATE)
    private Date datumPreisWechsel;
    private String user;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_stamp")
    private Date timeStamp;
    private String leistungs_typ;
    private String kunde_sl_idx;
    private String system_idx;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getDatumPreisWechsel() {
        return datumPreisWechsel;
    }

    public void setDatumPreisWechsel(Date datumPreisWechsel) {
        this.datumPreisWechsel = datumPreisWechsel;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getLeistungs_typ() {
        return leistungs_typ;
    }

    public void setLeistungs_typ(String leistungs_typ) {
        this.leistungs_typ = leistungs_typ;
    }

    public String getKunde_sl_idx() {
        return kunde_sl_idx;
    }

    public void setKunde_sl_idx(String kunde_sl_idx) {
        this.kunde_sl_idx = kunde_sl_idx;
    }

    public String getSystem_idx() {
        return system_idx;
    }

    public void setSystem_idx(String system_idx) {
        this.system_idx = system_idx;
    }

    @Override
    public String toString() {
        return "SonderPL{" + "id=" + id + ", preisl_sl_nr=" + preisl_sl_nr + ", sl_krz=" + sl_krz + ", system=" + system + ", sl_preis_vk=" + sl_preis_vk + ", sl_preis_vk_neu=" + sl_preis_vk_neu + ", datumPreisWechsel=" + datumPreisWechsel + ", user=" + user + ", timeStamp=" + timeStamp + ", leistungs_typ=" + leistungs_typ + ", kunde_sl_idx=" + kunde_sl_idx + ", system_idx=" + system_idx + '}';
    }

}
