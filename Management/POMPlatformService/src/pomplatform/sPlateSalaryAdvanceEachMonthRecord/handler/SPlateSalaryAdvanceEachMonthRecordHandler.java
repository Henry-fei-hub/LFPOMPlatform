package pomplatform.sPlateSalaryAdvanceEachMonthRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.sPlateSalaryAdvanceEachMonthRecord.bean.BaseSPlateSalaryAdvanceEachMonthRecord;
import pomplatform.sPlateSalaryAdvanceEachMonthRecord.bean.ConditionSPlateSalaryAdvanceEachMonthRecord;
import pomplatform.sPlateSalaryAdvanceEachMonthRecord.query.QuerySPlateSalaryAdvanceEachMonthRecord;
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

public class SPlateSalaryAdvanceEachMonthRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SPlateSalaryAdvanceEachMonthRecordHandler.class);

	public static BaseCollection<BaseSPlateSalaryAdvanceEachMonthRecord> executeQuerySPlateSalaryAdvanceEachMonthRecord(ConditionSPlateSalaryAdvanceEachMonthRecord c, KeyValuePair[] replacements ) throws Exception {
		QuerySPlateSalaryAdvanceEachMonthRecord dao = new QuerySPlateSalaryAdvanceEachMonthRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSPlateSalaryAdvanceEachMonthRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSPlateSalaryAdvanceEachMonthRecord c = new ConditionSPlateSalaryAdvanceEachMonthRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSPlateSalaryAdvanceEachMonthRecord> result = executeQuerySPlateSalaryAdvanceEachMonthRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSPlateSalaryAdvanceEachMonthRecord> result;
		ConditionSPlateSalaryAdvanceEachMonthRecord c = new ConditionSPlateSalaryAdvanceEachMonthRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySPlateSalaryAdvanceEachMonthRecord dao = new QuerySPlateSalaryAdvanceEachMonthRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSPlateSalaryAdvanceEachMonthRecord.ALL_CAPTIONS);
			for(BaseSPlateSalaryAdvanceEachMonthRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


