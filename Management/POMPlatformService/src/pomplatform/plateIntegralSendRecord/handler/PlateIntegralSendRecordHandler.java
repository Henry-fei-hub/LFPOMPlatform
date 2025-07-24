package pomplatform.plateIntegralSendRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.plateIntegralSendRecord.bean.BasePlateIntegralSendRecord;
import pomplatform.plateIntegralSendRecord.bean.ConditionPlateIntegralSendRecord;
import pomplatform.plateIntegralSendRecord.query.QueryPlateIntegralSendRecord;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class PlateIntegralSendRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PlateIntegralSendRecordHandler.class);

	public static BaseCollection<BasePlateIntegralSendRecord> executeQueryPlateIntegralSendRecord(ConditionPlateIntegralSendRecord c, KeyValuePair[] replacements ) throws Exception {
		QueryPlateIntegralSendRecord dao = new QueryPlateIntegralSendRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePlateIntegralSendRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPlateIntegralSendRecord c = new ConditionPlateIntegralSendRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePlateIntegralSendRecord> result = executeQueryPlateIntegralSendRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePlateIntegralSendRecord> result;
		ConditionPlateIntegralSendRecord c = new ConditionPlateIntegralSendRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPlateIntegralSendRecord dao = new QueryPlateIntegralSendRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePlateIntegralSendRecord.ALL_CAPTIONS);
			for(BasePlateIntegralSendRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


