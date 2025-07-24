package pomplatform.projectEmployee.handler;

import org.apache.log4j.Logger;
import pomplatform.projectEmployee.bean.BaseProjectEmployeeAudit;
import pomplatform.projectEmployee.bean.ConditionProjectEmployeeAudit;
import pomplatform.projectEmployee.query.QueryProjectEmployeeAudit;
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

public class ProjectEmployeeAuditHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectEmployeeAuditHandler.class);

	public static BaseCollection<BaseProjectEmployeeAudit> executeQueryProjectEmployeeAudit(ConditionProjectEmployeeAudit c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectEmployeeAudit dao = new QueryProjectEmployeeAudit();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectEmployeeAudit> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectEmployeeAudit c = new ConditionProjectEmployeeAudit();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectEmployeeAudit> result = executeQueryProjectEmployeeAudit(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectEmployeeAudit> result;
		ConditionProjectEmployeeAudit c = new ConditionProjectEmployeeAudit();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectEmployeeAudit dao = new QueryProjectEmployeeAudit();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectEmployeeAudit.ALL_CAPTIONS);
			for(BaseProjectEmployeeAudit b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


