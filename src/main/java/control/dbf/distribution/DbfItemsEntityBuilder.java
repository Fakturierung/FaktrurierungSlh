package control.dbf.distribution;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import entity.model.stage.Ansprechpartner;
import entity.model.stage.Artikel;
import entity.model.stage.Stammdaten;

/**
 * Helper String/Class<?> for DbfItem
 * @author ngj
 *
 */
@Singleton
public class DbfItemsEntityBuilder {

	private Map<String, Class<?>> string2Classes;

	@PostConstruct
	public void init() {
		string2Classes = new HashMap<>();
		string2Classes.put(Stammdaten.class.getSimpleName(), Stammdaten.class);
		string2Classes.put(Ansprechpartner.class.getSimpleName(), Ansprechpartner.class);
		string2Classes.put(Artikel.class.getSimpleName(), Artikel.class);	
		
	}

	public Map<String, Class<?>> getString2Classes() {
		return string2Classes;
	}

}
