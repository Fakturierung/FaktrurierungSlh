package boundary.rest;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;

import control.dbf.DbfRowDataService;
import control.dbf.files.DbfFilesMetaDataProvider;
import control.dbf.files.DbfFilesProcessingService;
import entity.dbf.DbfFilesMetadata;

@Path("dbfload")
public class DbfFilesImportResource {

	@Inject
	private Logger logger;

	@Inject
	private DbfFilesProcessingService dbfFilesProcessingService;

	@Inject
	private DbfFilesMetaDataProvider dbfFilesMetaDataProvider;

	@Inject
	private DbfRowDataService dbfRowdataService;

	@GET
	@Path("{fileName}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response processFile(@PathParam("fileName") @NotNull String fileName) {
		logger.info("--- REST::DbfFilesImportResource - PROCESS + SAVE DbfFile [INPUT = '{}'] ---",
				new Object[] { fileName });
		/* Metadata for dbfFile */
		DbfFilesMetadata dbfFile = this.dbfFilesMetaDataProvider.getDbfFilesConfigMap().get(fileName);
		if (null == dbfFile) {
			throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("DBF-FILE not found").build());
		}
		/* process dbfFile */
		long typedId = dbfFile.getDbfTypeId();
		Map<Long, List<String[]>> rowDataAsMap = dbfFilesProcessingService.processFile(dbfFile.getDbfFilePath(), typedId);
		if (MapUtils.isEmpty(rowDataAsMap)) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("ERROR Processing DBF-File").build();
		}
		/* content */
		List<String[]> data = rowDataAsMap.get(typedId);
		if (CollectionUtils.isNotEmpty(data)) {
			StringBuilder sb = new StringBuilder();
			for (String[] values : data) {
				long id = dbfRowdataService.saveRowData(dbfFile, values);
				sb.append(id).append(" ");
			}
			logger.info("--- REST::DbfFilesImport Resource - DbfFile [OUTPUT = '{}'] processed ---",
					new Object[] { fileName });
			return Response.ok().entity("DbfRowData Entity saved with IDs [" + sb.toString() + "]").build();
		}
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("No Data Found for DBF TypeId " + typedId).build();
	}

}
