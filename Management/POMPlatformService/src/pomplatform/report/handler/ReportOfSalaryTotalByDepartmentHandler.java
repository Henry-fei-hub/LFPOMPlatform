package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOfSalaryTotalByDepartment;
import pomplatform.report.bean.ConditionReportOfSalaryTotalByDepartment;
import pomplatform.report.query.QueryReportOfSalaryTotalByDepartment;
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

public class ReportOfSalaryTotalByDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOfSalaryTotalByDepartmentHandler.class);

	public static BaseCollection<BaseReportOfSalaryTotalByDepartment> executeQueryReportOfSalaryTotalByDepartment(ConditionReportOfSalaryTotalByDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOfSalaryTotalByDepartment dao = new QueryReportOfSalaryTotalByDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOfSalaryTotalByDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOfSalaryTotalByDepartment c = new ConditionReportOfSalaryTotalByDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOfSalaryTotalByDepartment> result = executeQueryReportOfSalaryTotalByDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOfSalaryTotalByDepartment> result;
		ConditionReportOfSalaryTotalByDepartment c = new ConditionReportOfSalaryTotalByDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOfSalaryTotalByDepartment dao = new QueryReportOfSalaryTotalByDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOfSalaryTotalByDepartment.ALL_CAPTIONS);
			for(BaseReportOfSalaryTotalByDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


