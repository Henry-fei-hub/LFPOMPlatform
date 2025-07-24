package pomplatform.employees.handler;

import org.apache.log4j.Logger;
import pomplatform.employees.bean.BaseGetEmployeeByRoleAndPlate;
import pomplatform.employees.bean.ConditionGetEmployeeByRoleAndPlate;
import pomplatform.employees.query.QueryGetEmployeeByRoleAndPlate;
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

public class GetEmployeeByRoleAndPlateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetEmployeeByRoleAndPlateHandler.class);

	public static BaseCollection<BaseGetEmployeeByRoleAndPlate> executeQueryGetEmployeeByRoleAndPlate(ConditionGetEmployeeByRoleAndPlate c, KeyValuePair[] replacements ) throws Exception {
		QueryGetEmployeeByRoleAndPlate dao = new QueryGetEmployeeByRoleAndPlate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetEmployeeByRoleAndPlate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetEmployeeByRoleAndPlate c = new ConditionGetEmployeeByRoleAndPlate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetEmployeeByRoleAndPlate> result = executeQueryGetEmployeeByRoleAndPlate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetEmployeeByRoleAndPlate> result;
		ConditionGetEmployeeByRoleAndPlate c = new ConditionGetEmployeeByRoleAndPlate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetEmployeeByRoleAndPlate dao = new QueryGetEmployeeByRoleAndPlate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetEmployeeByRoleAndPlate.ALL_CAPTIONS);
			for(BaseGetEmployeeByRoleAndPlate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


