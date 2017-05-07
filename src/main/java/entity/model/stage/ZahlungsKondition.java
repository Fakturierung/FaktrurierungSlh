/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.model.stage;

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
@Table(name = "tbl_cu_Zahlungskonditionen")
public class ZahlungsKondition implements Serializable {

	private static final long serialVersionUID = 3676367251719189559L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "zahlungsziel")
	private long tageNetto;
	private long zahlung;
	private String beschreibung;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTageNetto() {
		return tageNetto;
	}

	public void setTageNetto(long tageNetto) {
		this.tageNetto = tageNetto;
	}

	public long getZahlung() {
		return zahlung;
	}

	public void setZahlung(long zahlung) {
		this.zahlung = zahlung;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	@Override
	public String toString() {
		return "ZahlungsKondition [id=" + id + ", tageNetto=" + tageNetto + ", zahlung=" + zahlung + ", beschreibung="
				+ beschreibung + "]";
	}

}
