package pomplatform.InspectionReport.handler;

import org.apache.log4j.Logger;
import pomplatform.InspectionReport.bean.BaseEmployee;
import pomplatform.InspectionReport.bean.ConditionEmployee;
import pomplatform.InspectionReport.query.QueryEmployee;
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

public class EmployeeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeHandler.class);

	public static BaseCollection<BaseEmployee> executeQueryEmployee(ConditionEmployee c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployee dao = new QueryEmployee();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployee> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployee c = new ConditionEmployee();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployee> result = executeQueryEmployee(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployee> result;
		ConditionEmployee c = new ConditionEmployee();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployee dao = new QueryEmployee();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployee.ALL_CAPTIONS);
			for(BaseEmployee b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


