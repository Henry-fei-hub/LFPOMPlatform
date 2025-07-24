package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseDepartmentIncomeDetailReport;
import pomplatform.report.bean.ConditionDepartmentIncomeDetailReport;
import pomplatform.report.query.QueryDepartmentIncomeDetailReport;
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

public class DepartmentIncomeDetailReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DepartmentIncomeDetailReportHandler.class);

	public static BaseCollection<BaseDepartmentIncomeDetailReport> executeQueryDepartmentIncomeDetailReport(ConditionDepartmentIncomeDetailReport c, KeyValuePair[] replacements ) throws Exception {
		QueryDepartmentIncomeDetailReport dao = new QueryDepartmentIncomeDetailReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseDepartmentIncomeDetailReport> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionDepartmentIncomeDetailReport c = new ConditionDepartmentIncomeDetailReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseDepartmentIncomeDetailReport> result = executeQueryDepartmentIncomeDetailReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseDepartmentIncomeDetailReport> result;
		ConditionDepartmentIncomeDetailReport c = new ConditionDepartmentIncomeDetailReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryDepartmentIncomeDetailReport dao = new QueryDepartmentIncomeDetailReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseDepartmentIncomeDetailReport.ALL_CAPTIONS);
			for(BaseDepartmentIncomeDetailReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


