package entity.model.mirror;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "tbl_pr_nachnahme", schema = "fak2")
public class MirrorNachnahme implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NN_min")
    private double nn_min;
    @Column(name = "NN_pro")
    private double nn_pro;
    @Column(name = "NN_max")
    private double nn_max;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNn_min() {
        return nn_min;
    }

    public void setNn_min(double nn_min) {
        this.nn_min = nn_min;
    }

    public double getNn_pro() {
        return nn_pro;
    }

    public void setNn_pro(double nn_pro) {
        this.nn_pro = nn_pro;
    }

    public double getNn_max() {
        return nn_max;
    }

    public void setNn_max(double nn_max) {
        this.nn_max = nn_max;
    }

    @Override
    public String toString() {
        return "Nachnahme{" + "id=" + id + ", nn_min=" + nn_min + ", nn_pro=" + nn_pro + ", nn_max=" + nn_max + '}';
    }

}
