package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseOnboardEmployeeEachYear;
import pomplatform.employee.bean.ConditionOnboardEmployeeEachYear;
import pomplatform.employee.query.QueryOnboardEmployeeEachYear;
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

public class OnboardEmployeeEachYearHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnboardEmployeeEachYearHandler.class);

	public static BaseCollection<BaseOnboardEmployeeEachYear> executeQueryOnboardEmployeeEachYear(ConditionOnboardEmployeeEachYear c, KeyValuePair[] replacements ) throws Exception {
		QueryOnboardEmployeeEachYear dao = new QueryOnboardEmployeeEachYear();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnboardEmployeeEachYear> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnboardEmployeeEachYear c = new ConditionOnboardEmployeeEachYear();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnboardEmployeeEachYear> result = executeQueryOnboardEmployeeEachYear(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnboardEmployeeEachYear> result;
		ConditionOnboardEmployeeEachYear c = new ConditionOnboardEmployeeEachYear();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnboardEmployeeEachYear dao = new QueryOnboardEmployeeEachYear();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnboardEmployeeEachYear.ALL_CAPTIONS);
			for(BaseOnboardEmployeeEachYear b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


