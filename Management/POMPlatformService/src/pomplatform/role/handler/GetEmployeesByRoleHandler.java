package pomplatform.role.handler;

import org.apache.log4j.Logger;
import pomplatform.role.bean.BaseGetEmployeesByRole;
import pomplatform.role.bean.ConditionGetEmployeesByRole;
import pomplatform.role.query.QueryGetEmployeesByRole;
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

public class GetEmployeesByRoleHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(GetEmployeesByRoleHandler.class);

	public static BaseCollection<BaseGetEmployeesByRole> executeQueryGetEmployeesByRole(ConditionGetEmployeesByRole c, KeyValuePair[] replacements ) throws Exception {
		QueryGetEmployeesByRole dao = new QueryGetEmployeesByRole();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseGetEmployeesByRole> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionGetEmployeesByRole c = new ConditionGetEmployeesByRole();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseGetEmployeesByRole> result = executeQueryGetEmployeesByRole(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseGetEmployeesByRole> result;
		ConditionGetEmployeesByRole c = new ConditionGetEmployeesByRole();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryGetEmployeesByRole dao = new QueryGetEmployeesByRole();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseGetEmployeesByRole.ALL_CAPTIONS);
			for(BaseGetEmployeesByRole b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


