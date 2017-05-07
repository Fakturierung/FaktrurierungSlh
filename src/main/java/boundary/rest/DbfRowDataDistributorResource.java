package boundary.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import control.dbf.DbfRowDataProcessingEventProducer;
import entity.dbf.DbfRowData;

@Path("distributor")
public class DbfRowDataDistributorResource {

	@Inject
	private DbfRowDataProcessingEventProducer eventProducer;	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response startDistribution(){
		eventProducer.loadInitialRowData();
		GenericEntity<List<DbfRowData>> genericEntity = 
				new GenericEntity<List<DbfRowData>>(eventProducer.getRowDatas()){};
		return Response.accepted().entity(genericEntity).build();
	}
	
}
