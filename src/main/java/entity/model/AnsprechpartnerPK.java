package entity.model;
 
import java.io.Serializable;

import javax.persistence.Embeddable;

import entity.CounterSequence;

/**
 *
 * @author ngj
 */
@Embeddable
public class AnsprechpartnerPK implements Serializable {

	private static final long serialVersionUID = 2252167873326052498L;
	
	
	private long kundenNummer; //Stammdaten.kundennummer
	private long lfd_Nummer;  //AutoWert

	
	public AnsprechpartnerPK(){
		this.lfd_Nummer = CounterSequence.getAndIncrement();
	}
	
	public long getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(long kundenNummer) {
		this.kundenNummer = kundenNummer;
	}

	public long getLfd_Nummer() {
		return lfd_Nummer;
	}

	public void setLfd_Nummer(long lfd_Nummer) {
		this.lfd_Nummer = lfd_Nummer;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + (int) (this.kundenNummer ^ (this.kundenNummer >>> 32));
		hash = 97 * hash + (int) (this.lfd_Nummer ^ (this.lfd_Nummer >>> 32));
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AnsprechpartnerPK other = (AnsprechpartnerPK) obj;
		if (this.kundenNummer != other.kundenNummer) {
			return false;
		}
		if (this.lfd_Nummer != other.lfd_Nummer) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AnsprechpartnerPK [kundenNummer=" + kundenNummer + ", lfd_Nummer=" + lfd_Nummer + "]";
	}
	
	

}
