package config;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Custom Producer field for EntityManager
 * 
 * @author ngj
 *
 */
public class CustomEntityManagerProducer {

	@Produces
	@PersistenceContext(unitName = "mysql")
	@MYSQL
	EntityManager entityManager;

//	@Produces
//	@PersistenceContext(unitName = "mysql2")
//	@MirrorUnit
//	EntityManager mirrorPU;

//	@Produces
//	@PersistenceContext(unitName = "mysql3")
//	@ReconUnit
//	EntityManager reconPU;

}
