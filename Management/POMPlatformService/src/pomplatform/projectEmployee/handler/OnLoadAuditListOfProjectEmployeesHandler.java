package pomplatform.projectEmployee.handler;

import org.apache.log4j.Logger;
import pomplatform.projectEmployee.bean.BaseOnLoadAuditListOfProjectEmployees;
import pomplatform.projectEmployee.bean.ConditionOnLoadAuditListOfProjectEmployees;
import pomplatform.projectEmployee.query.QueryOnLoadAuditListOfProjectEmployees;
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

public class OnLoadAuditListOfProjectEmployeesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfProjectEmployeesHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfProjectEmployees> executeQueryOnLoadAuditListOfProjectEmployees(ConditionOnLoadAuditListOfProjectEmployees c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfProjectEmployees dao = new QueryOnLoadAuditListOfProjectEmployees();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfProjectEmployees> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfProjectEmployees c = new ConditionOnLoadAuditListOfProjectEmployees();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfProjectEmployees> result = executeQueryOnLoadAuditListOfProjectEmployees(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfProjectEmployees> result;
		ConditionOnLoadAuditListOfProjectEmployees c = new ConditionOnLoadAuditListOfProjectEmployees();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfProjectEmployees dao = new QueryOnLoadAuditListOfProjectEmployees();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfProjectEmployees.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfProjectEmployees b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


