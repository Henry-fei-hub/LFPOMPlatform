package pomplatform.employeeReportRecordDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.employeeReportRecordDetail.bean.BaseEmployeeMonthlyAchieveIntegral;
import pomplatform.employeeReportRecordDetail.bean.ConditionEmployeeMonthlyAchieveIntegral;
import pomplatform.employeeReportRecordDetail.query.QueryEmployeeMonthlyAchieveIntegral;
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

public class EmployeeMonthlyAchieveIntegralHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeMonthlyAchieveIntegralHandler.class);

	public static BaseCollection<BaseEmployeeMonthlyAchieveIntegral> executeQueryEmployeeMonthlyAchieveIntegral(ConditionEmployeeMonthlyAchieveIntegral c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeMonthlyAchieveIntegral dao = new QueryEmployeeMonthlyAchieveIntegral();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeMonthlyAchieveIntegral> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeMonthlyAchieveIntegral c = new ConditionEmployeeMonthlyAchieveIntegral();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeMonthlyAchieveIntegral> result = executeQueryEmployeeMonthlyAchieveIntegral(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeMonthlyAchieveIntegral> result;
		ConditionEmployeeMonthlyAchieveIntegral c = new ConditionEmployeeMonthlyAchieveIntegral();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeMonthlyAchieveIntegral dao = new QueryEmployeeMonthlyAchieveIntegral();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeMonthlyAchieveIntegral.ALL_CAPTIONS);
			for(BaseEmployeeMonthlyAchieveIntegral b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


