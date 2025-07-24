package pomplatform.handler;

import delicacy.common.*;
import org.apache.log4j.Logger;
import pomplatform.bean.BaseEmployeeSalaryType;
import pomplatform.bean.ConditionEmployeeSalaryType;
import pomplatform.query.QueryEmployeeSalaryType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

public class EmployeeSalaryTypeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeSalaryTypeHandler.class);

	public static BaseCollection<BaseEmployeeSalaryType> executeQueryEmployeeSalaryType(ConditionEmployeeSalaryType c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeSalaryType dao = new QueryEmployeeSalaryType();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeSalaryType> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeSalaryType c = new ConditionEmployeeSalaryType();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeSalaryType> result = executeQueryEmployeeSalaryType(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeSalaryType> result;
		ConditionEmployeeSalaryType c = new ConditionEmployeeSalaryType();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeSalaryType dao = new QueryEmployeeSalaryType();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeSalaryType.ALL_CAPTIONS);
			for(BaseEmployeeSalaryType b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


