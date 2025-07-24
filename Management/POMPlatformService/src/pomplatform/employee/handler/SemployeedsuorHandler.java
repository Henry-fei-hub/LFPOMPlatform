package pomplatform.employee.handler;

import org.apache.log4j.Logger;
import pomplatform.employee.bean.BaseSemployeedsuor;
import pomplatform.employee.bean.ConditionSemployeedsuor;
import pomplatform.employee.query.QuerySemployeedsuor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.dao.EmployeeRole;
import delicacy.common.BaseCollection;

public class SemployeedsuorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SemployeedsuorHandler.class);

	public static BaseCollection<BaseSemployeedsuor> executeQuerySemployeedsuor(ConditionSemployeedsuor c, KeyValuePair[] replacements ) throws Exception {
		QuerySemployeedsuor dao = new QuerySemployeedsuor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSemployeedsuor> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			EmployeeRole daoEmployeeRole = new EmployeeRole();
			for(BaseSemployeedsuor bean : result.getCollections()){
				daoEmployeeRole.setConditionEmployeeId("=", bean.getEmployeeId());
				bean.setDetailEmployeeRole(daoEmployeeRole.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSemployeedsuor c = new ConditionSemployeedsuor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSemployeedsuor> result = executeQuerySemployeedsuor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSemployeedsuor> result;
		ConditionSemployeedsuor c = new ConditionSemployeedsuor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySemployeedsuor dao = new QuerySemployeedsuor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSemployeedsuor.ALL_CAPTIONS);
			for(BaseSemployeedsuor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


