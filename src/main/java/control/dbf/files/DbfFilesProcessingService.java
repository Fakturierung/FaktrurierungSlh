package control.dbf.files;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jamel.dbf.DbfReader;
import org.jamel.dbf.structure.DbfDataType;
import org.jamel.dbf.structure.DbfHeader;
import org.jamel.dbf.structure.DbfRow;
import org.slf4j.Logger;

/**
 * DBF Files Processor
 * 
 * @author ngj
 *
 */
public class DbfFilesProcessingService {

	private Charset charset;
	private DbfHeader header;
	private int numberOfRows;

	@Inject
	Logger logger;

	@Inject
	private DbfFilesParser dbfFilesParser;

	@PostConstruct
	public void init() {
		this.charset = Charset.forName(ParserUtils.Cp850);
	}

	public Map<Long, List<String[]>> processFile(String path, long typeId) {
		Map<Long, List<String[]>> rowData = new HashMap<>();
		File file = new File(path);
		if (file.exists() && file.isFile() && file.canRead()) {
			try (DbfReader dbfReader = new DbfReader(file, this.charset)) {
				this.header = dbfReader.getHeader();
				this.numberOfRows = dbfReader.getRecordCount();
				logger.info("--- PROCESSING DBF file '{}' - Content [#Headers = '{}', #Rows = '{}'] ---",
						new Object[] { file.getAbsolutePath(), this.header.getFieldsCount(), this.numberOfRows });
				/* MetaData in file */
				Map<String, DbfDataType> metadata = dbfFilesParser.parseHeader(file.getName(), header);
				/* File content */
				DbfRow nextRow = null;
				long counter = 0;
				if (rowData.isEmpty()) {
					rowData.put(typeId, new ArrayList<String[]>());
				} else {
					if (!rowData.containsKey(typeId)) {
						rowData.put(typeId, new ArrayList<String[]>());
					}
				}
				/* extract data */
				do {
					counter++;
					if (counter > numberOfRows) {
						logger.info("---  (EOF) PROCESSING of DBF file '{}' DONE - EndPosition '{}' ---",
								new Object[] { file.getAbsolutePath(), counter });
						break;
					}
					nextRow = dbfReader.nextRow();
					String[] rowValues = dbfFilesParser.parseRow(metadata, nextRow, this.charset);
					logger.debug("--- FILE dbfRow ['{}'] - Data ['{}'] extracted ---",
							new Object[] { counter, rowValues });
					rowData.get(typeId).add(rowValues);
					logger.debug("--- TYPEID '{}' - UPDATED with DbfRow ['#{}'] and VALUES ['{}'] ---",
							new Object[] { typeId, counter, rowValues });
				} while (nextRow != null);
			}
		}
		return rowData;
	}

	public Charset getCharset() {
		return charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	public DbfHeader getHeader() {
		return header;
	}

	public void setHeader(DbfHeader header) {
		this.header = header;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public DbfFilesParser getDbfDataExtractor() {
		return dbfFilesParser;
	}

	public void setDbfDataExtractor(DbfFilesParser dbfDataExtractor) {
		this.dbfFilesParser = dbfDataExtractor;
	}

}
