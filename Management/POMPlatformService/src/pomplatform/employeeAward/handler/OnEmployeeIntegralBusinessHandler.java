package pomplatform.employeeAward.handler;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import pomplatform.employeeAward.bean.BaseOnEmployeeIntegralBusiness;
import pomplatform.employeeAward.bean.ConditionOnEmployeeIntegralBusiness;
import pomplatform.employeeAward.query.QueryOnEmployeeIntegralBusiness;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class OnEmployeeIntegralBusinessHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnEmployeeIntegralBusinessHandler.class);

	public static BaseCollection<BaseOnEmployeeIntegralBusiness> executeQueryOnEmployeeIntegralBusiness(ConditionOnEmployeeIntegralBusiness c, KeyValuePair[] replacements ) throws Exception {
		QueryOnEmployeeIntegralBusiness dao = new QueryOnEmployeeIntegralBusiness();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnEmployeeIntegralBusiness> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnEmployeeIntegralBusiness c = new ConditionOnEmployeeIntegralBusiness();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnEmployeeIntegralBusiness> result = executeQueryOnEmployeeIntegralBusiness(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnEmployeeIntegralBusiness> result;
		ConditionOnEmployeeIntegralBusiness c = new ConditionOnEmployeeIntegralBusiness();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnEmployeeIntegralBusiness dao = new QueryOnEmployeeIntegralBusiness();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnEmployeeIntegralBusiness.ALL_CAPTIONS);
			for(BaseOnEmployeeIntegralBusiness b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


