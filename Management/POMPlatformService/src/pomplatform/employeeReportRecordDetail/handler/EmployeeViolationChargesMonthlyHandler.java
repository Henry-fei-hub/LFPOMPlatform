package pomplatform.employeeReportRecordDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.employeeReportRecordDetail.bean.BaseEmployeeViolationChargesMonthly;
import pomplatform.employeeReportRecordDetail.bean.ConditionEmployeeViolationChargesMonthly;
import pomplatform.employeeReportRecordDetail.query.QueryEmployeeViolationChargesMonthly;
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

public class EmployeeViolationChargesMonthlyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeViolationChargesMonthlyHandler.class);

	public static BaseCollection<BaseEmployeeViolationChargesMonthly> executeQueryEmployeeViolationChargesMonthly(ConditionEmployeeViolationChargesMonthly c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeViolationChargesMonthly dao = new QueryEmployeeViolationChargesMonthly();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeViolationChargesMonthly> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeViolationChargesMonthly c = new ConditionEmployeeViolationChargesMonthly();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeViolationChargesMonthly> result = executeQueryEmployeeViolationChargesMonthly(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeViolationChargesMonthly> result;
		ConditionEmployeeViolationChargesMonthly c = new ConditionEmployeeViolationChargesMonthly();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeViolationChargesMonthly dao = new QueryEmployeeViolationChargesMonthly();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeViolationChargesMonthly.ALL_CAPTIONS);
			for(BaseEmployeeViolationChargesMonthly b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


