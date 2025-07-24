package pomplatform.employeeRole.handler;

import org.apache.log4j.Logger;
import pomplatform.employeeRole.bean.BaseGetRole93Employees;
import pomplatform.employeeRole.bean.ConditionGetRole93Employees;
import pomplatform.employeeRole.query.QueryGetRole93Employees;
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

public class GetRole93EmployeesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetRole93EmployeesHandler.class);

	public static BaseCollection<BaseGetRole93Employees> executeQueryGetRole93Employees(ConditionGetRole93Employees c, KeyValuePair[] replacements ) throws Exception {
		QueryGetRole93Employees dao = new QueryGetRole93Employees();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetRole93Employees> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetRole93Employees c = new ConditionGetRole93Employees();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetRole93Employees> result = executeQueryGetRole93Employees(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetRole93Employees> result;
		ConditionGetRole93Employees c = new ConditionGetRole93Employees();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetRole93Employees dao = new QueryGetRole93Employees();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetRole93Employees.ALL_CAPTIONS);
			for(BaseGetRole93Employees b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


