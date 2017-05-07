package entity.model.stage;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author ngj
 */
@Entity
@Table(name = "tbl_cu_stammdaten")
public class Stammdaten implements Serializable {

	private static final long serialVersionUID = 9024073913813092452L;

	@Id
	private long kundennummer; // NUMMER
	private String debitornummer; // VDAT - REFERENZ
	private String kundenname; // V_Dat -> NAME
	private String name2; // V_Dat -> NAME2
	private String strasse; // V_Dat -> STRASSE
	private long plz; // V_Dat -> PLC; tbl_stn_plz
	private String ort; // V_Dat -> ORT; tbl_stn_plz_ortsteile
	private String land; // D = Deutschland / Quelle: V_Dat -> LAND; tbl_stn_country_kz
	
	@OneToOne(cascade = CascadeType.ALL)
	private FrachtZahler abweichender_Frachtzahler; //F_NAME=name, F_NAME2=name2, F_STRASSE=strasse, F_PLZ=plz, F_ORT=ort, F_LAND=land
	@OneToOne(cascade = CascadeType.ALL)
	private VolFaktor vol_faktor; //VOL_FAKTOR=faktor
	@OneToOne(cascade = CascadeType.ALL)
	private Ansprechpartner ansprechpartner; //KONTAKT=titel+nachname, TELEFON=tel_nummer, TELEFAX=fax_nummer
	
	private String ustid; // USTID
	
	@OneToOne
	private Betreuer betreuer;
	@OneToOne
	private BerechnungsModus berechnungsModus;
	private BasisPL basisPL;
	@OneToOne
	private SonderPL sonderPL;
	@OneToOne
	private DieselFloater dieselFloater;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ZahlungsKondition zahlungskondition;//ZIEL=tageNetto, ZAHLUNG=zahlung	
	@OneToOne(cascade = CascadeType.ALL)
	private Nachnahme nachnahme;//NN_MIN=nn_min, NN_PRO=nn_pro
	
	private String formularCode;

	public long getKundennummer() {
		return kundennummer;
	}

	public void setKundennummer(long kundennummer) {
		this.kundennummer = kundennummer;
	}

	public String getDebitornummer() {
		return debitornummer;
	}

	public void setDebitornummer(String debitornummer) {
		this.debitornummer = debitornummer;
	}

	public String getKundenname() {
		return kundenname;
	}

	public void setKundenname(String kundenname) {
		this.kundenname = kundenname;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public long getPlz() {
		return plz;
	}

	public void setPlz(long plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public FrachtZahler getAbweichender_Frachtzahler() {
		return abweichender_Frachtzahler;
	}

	public void setAbweichender_Frachtzahler(FrachtZahler abweichender_Frachtzahler) {
		this.abweichender_Frachtzahler = abweichender_Frachtzahler;
	}

	public VolFaktor getVol_faktor() {
		return vol_faktor;
	}

	public void setVol_faktor(VolFaktor vol_faktor) {
		this.vol_faktor = vol_faktor;
	}

	public Ansprechpartner getAnsprechpartner() {
		return ansprechpartner;
	}

	public void setAnsprechpartner(Ansprechpartner ansprechpartner) {
		this.ansprechpartner = ansprechpartner;
	}

	public String getUstid() {
		return ustid;
	}

	public void setUstid(String ustid) {
		this.ustid = ustid;
	}

	public Betreuer getBetreuer() {
		return betreuer;
	}

	public void setBetreuer(Betreuer betreuer) {
		this.betreuer = betreuer;
	}

	public BerechnungsModus getBerechnungsModus() {
		return berechnungsModus;
	}

	public void setBerechnungsModus(BerechnungsModus berechnungsModus) {
		this.berechnungsModus = berechnungsModus;
	}

	public DieselFloater getDieselFloater() {
		return dieselFloater;
	}

	public void setDieselFloater(DieselFloater dieselFloater) {
		this.dieselFloater = dieselFloater;
	}

	public BasisPL getBasisPL() {
		return basisPL;
	}

	public void setBasisPL(BasisPL basisPL) {
		this.basisPL = basisPL;
	}

	public SonderPL getSonderPL() {
		return sonderPL;
	}

	public void setSonderPL(SonderPL sonderPL) {
		this.sonderPL = sonderPL;
	}

	public ZahlungsKondition getZahlungskondition() {
		return zahlungskondition;
	}

	public void setZahlungskondition(ZahlungsKondition zahlungskondition) {
		this.zahlungskondition = zahlungskondition;
	}

	public Nachnahme getNachnahme() {
		return nachnahme;
	}

	public void setNachnahme(Nachnahme nachnahme) {
		this.nachnahme = nachnahme;
	}

	public String getFormularCode() {
		return formularCode;
	}

	public void setFormularCode(String formularCode) {
		this.formularCode = formularCode;
	}

	@Override
	public String toString() {
		return "Stammdaten [kundennummer=" + kundennummer + ", debitornummer=" + debitornummer + ", kundenname="
				+ kundenname + ", name2=" + name2 + ", strasse=" + strasse + ", plz=" + plz + ", ort=" + ort + ", land="
				+ land + ", abweichender_Frachtzahler=" + abweichender_Frachtzahler + ", vol_faktor=" + vol_faktor
				+ ", ansprechpartner=" + ansprechpartner + ", ustid=" + ustid + ", betreuer=" + betreuer
				+ ", berechnungsModus=" + berechnungsModus + ", basisPL=" + basisPL + ", sonderPL=" + sonderPL
				+ ", dieselFloater=" + dieselFloater + ", zahlungskondition=" + zahlungskondition + ", nachnahme="
				+ nachnahme + ", formularCode=" + formularCode + "]";
	}

}
