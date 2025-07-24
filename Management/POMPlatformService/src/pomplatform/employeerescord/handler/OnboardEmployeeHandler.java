package pomplatform.employeerescord.handler;

import org.apache.log4j.Logger;
import pomplatform.employeerescord.bean.BaseOnboardEmployee;
import pomplatform.employeerescord.bean.ConditionOnboardEmployee;
import pomplatform.employeerescord.query.QueryOnboardEmployee;
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

public class OnboardEmployeeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnboardEmployeeHandler.class);

	public static BaseCollection<BaseOnboardEmployee> executeQueryOnboardEmployee(ConditionOnboardEmployee c, KeyValuePair[] replacements ) throws Exception {
		QueryOnboardEmployee dao = new QueryOnboardEmployee();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnboardEmployee> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnboardEmployee c = new ConditionOnboardEmployee();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnboardEmployee> result = executeQueryOnboardEmployee(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnboardEmployee> result;
		ConditionOnboardEmployee c = new ConditionOnboardEmployee();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnboardEmployee dao = new QueryOnboardEmployee();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnboardEmployee.ALL_CAPTIONS);
			for(BaseOnboardEmployee b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


