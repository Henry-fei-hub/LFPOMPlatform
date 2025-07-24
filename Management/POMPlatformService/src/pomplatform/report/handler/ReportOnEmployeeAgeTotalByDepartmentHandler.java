package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeAgeTotalByDepartment;
import pomplatform.report.bean.ConditionReportOnEmployeeAgeTotalByDepartment;
import pomplatform.report.query.QueryReportOnEmployeeAgeTotalByDepartment;
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

public class ReportOnEmployeeAgeTotalByDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeAgeTotalByDepartmentHandler.class);

	public static BaseCollection<BaseReportOnEmployeeAgeTotalByDepartment> executeQueryReportOnEmployeeAgeTotalByDepartment(ConditionReportOnEmployeeAgeTotalByDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeAgeTotalByDepartment dao = new QueryReportOnEmployeeAgeTotalByDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeAgeTotalByDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeAgeTotalByDepartment c = new ConditionReportOnEmployeeAgeTotalByDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeAgeTotalByDepartment> result = executeQueryReportOnEmployeeAgeTotalByDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeAgeTotalByDepartment> result;
		ConditionReportOnEmployeeAgeTotalByDepartment c = new ConditionReportOnEmployeeAgeTotalByDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeAgeTotalByDepartment dao = new QueryReportOnEmployeeAgeTotalByDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeAgeTotalByDepartment.ALL_CAPTIONS);
			for(BaseReportOnEmployeeAgeTotalByDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


