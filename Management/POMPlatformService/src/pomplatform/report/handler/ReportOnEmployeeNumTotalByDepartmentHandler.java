package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeNumTotalByDepartment;
import pomplatform.report.bean.ConditionReportOnEmployeeNumTotalByDepartment;
import pomplatform.report.query.QueryReportOnEmployeeNumTotalByDepartment;
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

public class ReportOnEmployeeNumTotalByDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeNumTotalByDepartmentHandler.class);

	public static BaseCollection<BaseReportOnEmployeeNumTotalByDepartment> executeQueryReportOnEmployeeNumTotalByDepartment(ConditionReportOnEmployeeNumTotalByDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeNumTotalByDepartment dao = new QueryReportOnEmployeeNumTotalByDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeNumTotalByDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeNumTotalByDepartment c = new ConditionReportOnEmployeeNumTotalByDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeNumTotalByDepartment> result = executeQueryReportOnEmployeeNumTotalByDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeNumTotalByDepartment> result;
		ConditionReportOnEmployeeNumTotalByDepartment c = new ConditionReportOnEmployeeNumTotalByDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeNumTotalByDepartment dao = new QueryReportOnEmployeeNumTotalByDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeNumTotalByDepartment.DOWNLOAD_CAPTIONS);
			for(BaseReportOnEmployeeNumTotalByDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


