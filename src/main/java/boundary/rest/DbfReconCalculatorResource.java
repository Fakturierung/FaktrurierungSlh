package boundary.rest;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import control.dbf.recon.DbfReconciliationService;
import entity.recon.DbfTableReconStat;

@Path("statistics")
public class DbfReconCalculatorResource {

	@Inject
	DbfReconciliationService reconciliationService;

	@Path("{table}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response statistics(@PathParam("table") String table) {
		List<DbfTableReconStat> statistic = reconciliationService.doReconcilation(Arrays.asList(table));
		GenericEntity<List<DbfTableReconStat>> genericEntity = 
				new GenericEntity<List<DbfTableReconStat>>(statistic){};
		return Response.accepted().entity(genericEntity).build();
	}

}
