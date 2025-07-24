package pomplatform.employeeSalaryReturnRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.employeeSalaryReturnRecord.bean.BaseEmployeeSalaryReturnRecord;
import pomplatform.employeeSalaryReturnRecord.bean.ConditionEmployeeSalaryReturnRecord;
import pomplatform.employeeSalaryReturnRecord.query.QueryEmployeeSalaryReturnRecord;
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

public class EmployeeSalaryReturnRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeSalaryReturnRecordHandler.class);

	public static BaseCollection<BaseEmployeeSalaryReturnRecord> executeQueryEmployeeSalaryReturnRecord(ConditionEmployeeSalaryReturnRecord c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeSalaryReturnRecord dao = new QueryEmployeeSalaryReturnRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeSalaryReturnRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeSalaryReturnRecord c = new ConditionEmployeeSalaryReturnRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeSalaryReturnRecord> result = executeQueryEmployeeSalaryReturnRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeSalaryReturnRecord> result;
		ConditionEmployeeSalaryReturnRecord c = new ConditionEmployeeSalaryReturnRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeSalaryReturnRecord dao = new QueryEmployeeSalaryReturnRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeSalaryReturnRecord.ALL_CAPTIONS);
			for(BaseEmployeeSalaryReturnRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


