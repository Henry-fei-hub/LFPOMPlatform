package pomplatform.report.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseDepartmentIncomeReport;
import pomplatform.report.bean.ConditionDepartmentIncomeReport;
import pomplatform.report.query.QueryDepartmentIncomeReport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class DepartmentIncomeReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DepartmentIncomeReportHandler.class);

	public static BaseCollection<BaseDepartmentIncomeReport> executeQueryDepartmentIncomeReport(ConditionDepartmentIncomeReport c, KeyValuePair[] replacements ) throws Exception {
		QueryDepartmentIncomeReport dao = new QueryDepartmentIncomeReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseDepartmentIncomeReport> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionDepartmentIncomeReport c = new ConditionDepartmentIncomeReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseDepartmentIncomeReport> result = executeQueryDepartmentIncomeReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseDepartmentIncomeReport> result;
		ConditionDepartmentIncomeReport c = new ConditionDepartmentIncomeReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryDepartmentIncomeReport dao = new QueryDepartmentIncomeReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseDepartmentIncomeReport.ALL_CAPTIONS);
			for(BaseDepartmentIncomeReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


