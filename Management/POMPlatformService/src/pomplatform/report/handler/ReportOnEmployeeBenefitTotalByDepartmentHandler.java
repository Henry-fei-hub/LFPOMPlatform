package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeBenefitTotalByDepartment;
import pomplatform.report.bean.ConditionReportOnEmployeeBenefitTotalByDepartment;
import pomplatform.report.query.QueryReportOnEmployeeBenefitTotalByDepartment;
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

public class ReportOnEmployeeBenefitTotalByDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeBenefitTotalByDepartmentHandler.class);

	public static BaseCollection<BaseReportOnEmployeeBenefitTotalByDepartment> executeQueryReportOnEmployeeBenefitTotalByDepartment(ConditionReportOnEmployeeBenefitTotalByDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeBenefitTotalByDepartment dao = new QueryReportOnEmployeeBenefitTotalByDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeBenefitTotalByDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeBenefitTotalByDepartment c = new ConditionReportOnEmployeeBenefitTotalByDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeBenefitTotalByDepartment> result = executeQueryReportOnEmployeeBenefitTotalByDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeBenefitTotalByDepartment> result;
		ConditionReportOnEmployeeBenefitTotalByDepartment c = new ConditionReportOnEmployeeBenefitTotalByDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeBenefitTotalByDepartment dao = new QueryReportOnEmployeeBenefitTotalByDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeBenefitTotalByDepartment.ALL_CAPTIONS);
			for(BaseReportOnEmployeeBenefitTotalByDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


