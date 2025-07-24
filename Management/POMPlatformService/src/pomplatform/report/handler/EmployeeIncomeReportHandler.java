package pomplatform.report.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseEmployeeIncomeReport;
import pomplatform.report.bean.ConditionEmployeeIncomeReport;
import pomplatform.report.query.QueryEmployeeIncomeReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class EmployeeIncomeReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeIncomeReportHandler.class);

	public static BaseCollection<BaseEmployeeIncomeReport> executeQueryEmployeeIncomeReport(ConditionEmployeeIncomeReport c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeIncomeReport dao = new QueryEmployeeIncomeReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeIncomeReport> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeIncomeReport c = new ConditionEmployeeIncomeReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeIncomeReport> result = executeQueryEmployeeIncomeReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeIncomeReport> result;
		ConditionEmployeeIncomeReport c = new ConditionEmployeeIncomeReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeIncomeReport dao = new QueryEmployeeIncomeReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeIncomeReport.ALL_CAPTIONS);
			for(BaseEmployeeIncomeReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


