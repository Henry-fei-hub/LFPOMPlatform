package pomplatform.sProjectEmployeeAdvanceRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.sProjectEmployeeAdvanceRecord.bean.BaseSProjectEmployeeAdvanceRecord;
import pomplatform.sProjectEmployeeAdvanceRecord.bean.ConditionSProjectEmployeeAdvanceRecord;
import pomplatform.sProjectEmployeeAdvanceRecord.query.QuerySProjectEmployeeAdvanceRecord;
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

public class SProjectEmployeeAdvanceRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SProjectEmployeeAdvanceRecordHandler.class);

	public static BaseCollection<BaseSProjectEmployeeAdvanceRecord> executeQuerySProjectEmployeeAdvanceRecord(ConditionSProjectEmployeeAdvanceRecord c, KeyValuePair[] replacements ) throws Exception {
		QuerySProjectEmployeeAdvanceRecord dao = new QuerySProjectEmployeeAdvanceRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSProjectEmployeeAdvanceRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSProjectEmployeeAdvanceRecord c = new ConditionSProjectEmployeeAdvanceRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSProjectEmployeeAdvanceRecord> result = executeQuerySProjectEmployeeAdvanceRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSProjectEmployeeAdvanceRecord> result;
		ConditionSProjectEmployeeAdvanceRecord c = new ConditionSProjectEmployeeAdvanceRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySProjectEmployeeAdvanceRecord dao = new QuerySProjectEmployeeAdvanceRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSProjectEmployeeAdvanceRecord.ALL_CAPTIONS);
			for(BaseSProjectEmployeeAdvanceRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


