package pomplatform.sEmployeeSalaryReturnEachMonthRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.sEmployeeSalaryReturnEachMonthRecord.bean.BaseSEmployeeSalaryReturnEachMonthRecord;
import pomplatform.sEmployeeSalaryReturnEachMonthRecord.bean.ConditionSEmployeeSalaryReturnEachMonthRecord;
import pomplatform.sEmployeeSalaryReturnEachMonthRecord.query.QuerySEmployeeSalaryReturnEachMonthRecord;
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

public class SEmployeeSalaryReturnEachMonthRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SEmployeeSalaryReturnEachMonthRecordHandler.class);

	public static BaseCollection<BaseSEmployeeSalaryReturnEachMonthRecord> executeQuerySEmployeeSalaryReturnEachMonthRecord(ConditionSEmployeeSalaryReturnEachMonthRecord c, KeyValuePair[] replacements ) throws Exception {
		QuerySEmployeeSalaryReturnEachMonthRecord dao = new QuerySEmployeeSalaryReturnEachMonthRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSEmployeeSalaryReturnEachMonthRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSEmployeeSalaryReturnEachMonthRecord c = new ConditionSEmployeeSalaryReturnEachMonthRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSEmployeeSalaryReturnEachMonthRecord> result = executeQuerySEmployeeSalaryReturnEachMonthRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSEmployeeSalaryReturnEachMonthRecord> result;
		ConditionSEmployeeSalaryReturnEachMonthRecord c = new ConditionSEmployeeSalaryReturnEachMonthRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySEmployeeSalaryReturnEachMonthRecord dao = new QuerySEmployeeSalaryReturnEachMonthRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSEmployeeSalaryReturnEachMonthRecord.ALL_CAPTIONS);
			for(BaseSEmployeeSalaryReturnEachMonthRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


