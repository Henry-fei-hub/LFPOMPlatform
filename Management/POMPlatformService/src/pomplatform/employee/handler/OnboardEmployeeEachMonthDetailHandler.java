package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseOnboardEmployeeEachMonthDetail;
import pomplatform.employee.bean.ConditionOnboardEmployeeEachMonthDetail;
import pomplatform.employee.query.QueryOnboardEmployeeEachMonthDetail;
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

public class OnboardEmployeeEachMonthDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnboardEmployeeEachMonthDetailHandler.class);

	public static BaseCollection<BaseOnboardEmployeeEachMonthDetail> executeQueryOnboardEmployeeEachMonthDetail(ConditionOnboardEmployeeEachMonthDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryOnboardEmployeeEachMonthDetail dao = new QueryOnboardEmployeeEachMonthDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnboardEmployeeEachMonthDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnboardEmployeeEachMonthDetail c = new ConditionOnboardEmployeeEachMonthDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnboardEmployeeEachMonthDetail> result = executeQueryOnboardEmployeeEachMonthDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnboardEmployeeEachMonthDetail> result;
		ConditionOnboardEmployeeEachMonthDetail c = new ConditionOnboardEmployeeEachMonthDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnboardEmployeeEachMonthDetail dao = new QueryOnboardEmployeeEachMonthDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnboardEmployeeEachMonthDetail.DOWNLOAD_CAPTIONS);
			for(BaseOnboardEmployeeEachMonthDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


