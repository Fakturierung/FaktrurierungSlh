package entity.model.mirror;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_artikel", schema = "fak2")
public class MirrorArtikel implements Serializable {

	private static final long serialVersionUID = -3009135962608039231L;

	@Id
	private long artikelNr;

	@Column(name = "KD_ART_IDX")
	private String kundenArtikelIndex; // concat kdnr+artNr

	@Column(name = "ARTIKEL_BEZ")
	private String artikelBezeichnung;

	private long anz_packstuecke;
	private double laenge;
	private double breite;
	private double hoehe;
	private double gewicht;

	private double preis; // Währung €
	private String service;

	@Column(name = "XXL")
	private boolean isXXL;

	private String sl1;
	private String sl2;
	private String sl3;
	private String sl4;

	@OneToOne
	private MirrorVolFaktor vol_Faktor;

	public long getArtikelNr() {
		return artikelNr;
	}

	public void setArtikelNr(long artikelNr) {
		this.artikelNr = artikelNr;
	}

	public String getKundenArtikelIndex() {
		return kundenArtikelIndex;
	}

	public void setKundenArtikelIndex(String kundenArtikelIndex) {
		this.kundenArtikelIndex = kundenArtikelIndex;
	}

	public String getArtikelBezeichnung() {
		return artikelBezeichnung;
	}

	public void setArtikelBezeichnung(String artikelBezeichnung) {
		this.artikelBezeichnung = artikelBezeichnung;
	}

	public long getAnz_packstuecke() {
		return anz_packstuecke;
	}

	public void setAnz_packstuecke(long anz_packstuecke) {
		this.anz_packstuecke = anz_packstuecke;
	}

	public double getLaenge() {
		return laenge;
	}

	public void setLaenge(double laenge) {
		this.laenge = laenge;
	}

	public double getBreite() {
		return breite;
	}

	public void setBreite(double breite) {
		this.breite = breite;
	}

	public double getHoehe() {
		return hoehe;
	}

	public void setHoehe(double hoehe) {
		this.hoehe = hoehe;
	}

	public double getGewicht() {
		return gewicht;
	}

	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public boolean isIsXXL() {
		return isXXL;
	}

	public void setIsXXL(boolean isXXL) {
		this.isXXL = isXXL;
	}

	public String getSl1() {
		return sl1;
	}

	public void setSl1(String sl1) {
		this.sl1 = sl1;
	}

	public String getSl2() {
		return sl2;
	}

	public void setSl2(String sl2) {
		this.sl2 = sl2;
	}

	public String getSl3() {
		return sl3;
	}

	public void setSl3(String sl3) {
		this.sl3 = sl3;
	}

	public String getSl4() {
		return sl4;
	}

	public void setSl4(String sl4) {
		this.sl4 = sl4;
	}

	public MirrorVolFaktor getVol_Faktor() {
		return vol_Faktor;
	}

	public void setVol_Faktor(MirrorVolFaktor vol_Faktor) {
		this.vol_Faktor = vol_Faktor;
	}

}
