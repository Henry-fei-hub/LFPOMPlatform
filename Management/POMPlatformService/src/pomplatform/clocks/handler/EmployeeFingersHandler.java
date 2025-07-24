package pomplatform.clocks.handler;

import org.apache.log4j.Logger;
import pomplatform.clocks.bean.BaseEmployeeFingers;
import pomplatform.clocks.bean.ConditionEmployeeFingers;
import pomplatform.clocks.query.QueryEmployeeFingers;
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

public class EmployeeFingersHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeFingersHandler.class);

	public static BaseCollection<BaseEmployeeFingers> executeQueryemployeeFingers(ConditionEmployeeFingers c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeFingers dao = new QueryEmployeeFingers();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeFingers> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeFingers c = new ConditionEmployeeFingers();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeFingers> result = executeQueryemployeeFingers(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeFingers> result;
		ConditionEmployeeFingers c = new ConditionEmployeeFingers();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeFingers dao = new QueryEmployeeFingers();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeFingers.ALL_CAPTIONS);
			for(BaseEmployeeFingers b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


