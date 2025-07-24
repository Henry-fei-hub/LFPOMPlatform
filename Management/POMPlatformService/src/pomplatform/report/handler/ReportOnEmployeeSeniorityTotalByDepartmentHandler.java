package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeSeniorityTotalByDepartment;
import pomplatform.report.bean.ConditionReportOnEmployeeSeniorityTotalByDepartment;
import pomplatform.report.query.QueryReportOnEmployeeSeniorityTotalByDepartment;
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

public class ReportOnEmployeeSeniorityTotalByDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeSeniorityTotalByDepartmentHandler.class);

	public static BaseCollection<BaseReportOnEmployeeSeniorityTotalByDepartment> executeQueryReportOnEmployeeSeniorityTotalByDepartment(ConditionReportOnEmployeeSeniorityTotalByDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeSeniorityTotalByDepartment dao = new QueryReportOnEmployeeSeniorityTotalByDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeSeniorityTotalByDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeSeniorityTotalByDepartment c = new ConditionReportOnEmployeeSeniorityTotalByDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeSeniorityTotalByDepartment> result = executeQueryReportOnEmployeeSeniorityTotalByDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeSeniorityTotalByDepartment> result;
		ConditionReportOnEmployeeSeniorityTotalByDepartment c = new ConditionReportOnEmployeeSeniorityTotalByDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeSeniorityTotalByDepartment dao = new QueryReportOnEmployeeSeniorityTotalByDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeSeniorityTotalByDepartment.ALL_CAPTIONS);
			for(BaseReportOnEmployeeSeniorityTotalByDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


