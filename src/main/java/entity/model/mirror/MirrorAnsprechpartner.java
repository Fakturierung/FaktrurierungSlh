/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.model.mirror;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import entity.model.AnsprechpartnerPK;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_cu_Ansprechpartner", schema = "fak2")
public class MirrorAnsprechpartner implements Serializable {

	private static final long serialVersionUID = -9043773817570160815L;

	@EmbeddedId
	private AnsprechpartnerPK ansprechpartnerPK;

	private String titel;
	private String nachname;
	private String vorname;
	private String tel_nummer;
	private String mobile;
	private String fax_nummer;
	@Column(name = "EmailAdresse")
	private String email;
	@Temporal(TemporalType.DATE)
	private Date geburtstag;
	@OneToOne
	private MirrorPosition position;

	public AnsprechpartnerPK getAnsprechpartnerPK() {
		if (null == ansprechpartnerPK) {
			ansprechpartnerPK = new AnsprechpartnerPK();
		}
		return ansprechpartnerPK;
	}

	public void setAnsprechpartnerPK(AnsprechpartnerPK ansprechpartnerPK) {
		this.ansprechpartnerPK = ansprechpartnerPK;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getTel_nummer() {
		return tel_nummer;
	}

	public void setTel_nummer(String tel_nummer) {
		this.tel_nummer = tel_nummer;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax_nummer() {
		return fax_nummer;
	}

	public void setFax_nummer(String fax_nummer) {
		this.fax_nummer = fax_nummer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getGeburtstag() {
		return geburtstag;
	}

	public void setGeburtstag(Date geburtstag) {
		this.geburtstag = geburtstag;
	}

	public MirrorPosition getPosition() {
		return position;
	}

	public void setPosition(MirrorPosition position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Ansprechpartner{" + "ansprechpartnerPK=" + ansprechpartnerPK + ",titel=" + titel + ", nachname="
				+ nachname + ", vorname=" + vorname + ", tel_nummer=" + tel_nummer + ", mobile=" + mobile
				+ ", fax_nummer=" + fax_nummer + ", email=" + email + ", geburtstag=" + geburtstag + ", position="
				+ position + '}';
	}

}
