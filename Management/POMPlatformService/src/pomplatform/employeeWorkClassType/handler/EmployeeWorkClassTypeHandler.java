package pomplatform.employeeWorkClassType.handler;

import org.apache.log4j.Logger;
import pomplatform.employeeWorkClassType.bean.BaseEmployeeWorkClassType;
import pomplatform.employeeWorkClassType.bean.ConditionEmployeeWorkClassType;
import pomplatform.employeeWorkClassType.query.QueryEmployeeWorkClassType;
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

public class EmployeeWorkClassTypeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeWorkClassTypeHandler.class);

	public static BaseCollection<BaseEmployeeWorkClassType> executeQueryEmployeeWorkClassType(ConditionEmployeeWorkClassType c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeWorkClassType dao = new QueryEmployeeWorkClassType();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeWorkClassType> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeWorkClassType c = new ConditionEmployeeWorkClassType();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeWorkClassType> result = executeQueryEmployeeWorkClassType(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeWorkClassType> result;
		ConditionEmployeeWorkClassType c = new ConditionEmployeeWorkClassType();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeWorkClassType dao = new QueryEmployeeWorkClassType();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeWorkClassType.ALL_CAPTIONS);
			for(BaseEmployeeWorkClassType b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


