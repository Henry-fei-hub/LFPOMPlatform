package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadPerformanceIntegralOfEmployee;
import pomplatform.account.bean.ConditionOnLoadPerformanceIntegralOfEmployee;
import pomplatform.account.query.QueryOnLoadPerformanceIntegralOfEmployee;
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

public class OnLoadPerformanceIntegralOfEmployeeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadPerformanceIntegralOfEmployeeHandler.class);

	public static BaseCollection<BaseOnLoadPerformanceIntegralOfEmployee> executeQueryOnLoadPerformanceIntegralOfEmployee(ConditionOnLoadPerformanceIntegralOfEmployee c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadPerformanceIntegralOfEmployee dao = new QueryOnLoadPerformanceIntegralOfEmployee();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadPerformanceIntegralOfEmployee> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadPerformanceIntegralOfEmployee c = new ConditionOnLoadPerformanceIntegralOfEmployee();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadPerformanceIntegralOfEmployee> result = executeQueryOnLoadPerformanceIntegralOfEmployee(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadPerformanceIntegralOfEmployee> result;
		ConditionOnLoadPerformanceIntegralOfEmployee c = new ConditionOnLoadPerformanceIntegralOfEmployee();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadPerformanceIntegralOfEmployee dao = new QueryOnLoadPerformanceIntegralOfEmployee();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadPerformanceIntegralOfEmployee.ALL_CAPTIONS);
			for(BaseOnLoadPerformanceIntegralOfEmployee b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


