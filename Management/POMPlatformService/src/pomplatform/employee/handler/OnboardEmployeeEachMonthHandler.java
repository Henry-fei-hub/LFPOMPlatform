package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseOnboardEmployeeEachMonth;
import pomplatform.employee.bean.ConditionOnboardEmployeeEachMonth;
import pomplatform.employee.query.QueryOnboardEmployeeEachMonth;
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

public class OnboardEmployeeEachMonthHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnboardEmployeeEachMonthHandler.class);

	public static BaseCollection<BaseOnboardEmployeeEachMonth> executeQueryOnboardEmployeeEachMonth(ConditionOnboardEmployeeEachMonth c, KeyValuePair[] replacements ) throws Exception {
		QueryOnboardEmployeeEachMonth dao = new QueryOnboardEmployeeEachMonth();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnboardEmployeeEachMonth> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnboardEmployeeEachMonth c = new ConditionOnboardEmployeeEachMonth();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnboardEmployeeEachMonth> result = executeQueryOnboardEmployeeEachMonth(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnboardEmployeeEachMonth> result;
		ConditionOnboardEmployeeEachMonth c = new ConditionOnboardEmployeeEachMonth();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnboardEmployeeEachMonth dao = new QueryOnboardEmployeeEachMonth();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnboardEmployeeEachMonth.ALL_CAPTIONS);
			for(BaseOnboardEmployeeEachMonth b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


