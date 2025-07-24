package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeEducationTotalByDepartment;
import pomplatform.report.bean.ConditionReportOnEmployeeEducationTotalByDepartment;
import pomplatform.report.query.QueryReportOnEmployeeEducationTotalByDepartment;
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

public class ReportOnEmployeeEducationTotalByDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeEducationTotalByDepartmentHandler.class);

	public static BaseCollection<BaseReportOnEmployeeEducationTotalByDepartment> executeQueryReportOnEmployeeEducationTotalByDepartment(ConditionReportOnEmployeeEducationTotalByDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeEducationTotalByDepartment dao = new QueryReportOnEmployeeEducationTotalByDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeEducationTotalByDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeEducationTotalByDepartment c = new ConditionReportOnEmployeeEducationTotalByDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeEducationTotalByDepartment> result = executeQueryReportOnEmployeeEducationTotalByDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeEducationTotalByDepartment> result;
		ConditionReportOnEmployeeEducationTotalByDepartment c = new ConditionReportOnEmployeeEducationTotalByDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeEducationTotalByDepartment dao = new QueryReportOnEmployeeEducationTotalByDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeEducationTotalByDepartment.ALL_CAPTIONS);
			for(BaseReportOnEmployeeEducationTotalByDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


