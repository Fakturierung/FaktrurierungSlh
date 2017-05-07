package boundary.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import aop.Duration;
import config.MYSQL;
import entity.dbf.DbfRowData;

@Path("rowdata")
@Stateless
@Duration
public class DbfRowDataResource {

	@Inject @MYSQL 
	private EntityManager em;
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getRowData(@PathParam("id") long id){
		DbfRowData found = em.find(DbfRowData.class, id);
		return Response.accepted().entity(found).build();
	}
	
}
