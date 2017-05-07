package entity.model.stage;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_pr_gewichtsklassen")
public class Gewichtklasse implements Serializable {

	private static final long serialVersionUID = 1752677800619953501L;

	@Id
    private long kg;
    private long z_klasse;
    private long p_klasse;
    private double ek_stn_gel;
    private double ek_pal_gel;

    public long getKg() {
        return kg;
    }

    public void setKg(long kg) {
        this.kg = kg;
    }

    public long getZ_klasse() {
        return z_klasse;
    }

    public void setZ_klasse(long z_klasse) {
        this.z_klasse = z_klasse;
    }

    public long getP_klasse() {
        return p_klasse;
    }

    public void setP_klasse(long p_klasse) {
        this.p_klasse = p_klasse;
    }

    public double getEk_stn_gel() {
        return ek_stn_gel;
    }

    public void setEk_stn_gel(double ek_stn_gel) {
        this.ek_stn_gel = ek_stn_gel;
    }

    public double getEk_pal_gel() {
        return ek_pal_gel;
    }

    public void setEk_pal_gel(double ek_pal_gel) {
        this.ek_pal_gel = ek_pal_gel;
    }

    @Override
    public String toString() {
        return "Gewichtklasse{" + "kg=" + kg + ", z_klasse=" + z_klasse + ", p_klasse=" + p_klasse + ", ek_stn_gel=" + ek_stn_gel + ", ek_pal_gel=" + ek_pal_gel + '}';
    }

}
