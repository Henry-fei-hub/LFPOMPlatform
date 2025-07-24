package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseEmployeeMoneyAuditOfWorkflow;
import pomplatform.workflow.bean.ConditionEmployeeMoneyAuditOfWorkflow;
import pomplatform.workflow.query.QueryEmployeeMoneyAuditOfWorkflow;
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

public class EmployeeMoneyAuditOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeMoneyAuditOfWorkflowHandler.class);

	public static BaseCollection<BaseEmployeeMoneyAuditOfWorkflow> executeQueryEmployeeMoneyAuditOfWorkflow(ConditionEmployeeMoneyAuditOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeMoneyAuditOfWorkflow dao = new QueryEmployeeMoneyAuditOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeMoneyAuditOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeMoneyAuditOfWorkflow c = new ConditionEmployeeMoneyAuditOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeMoneyAuditOfWorkflow> result = executeQueryEmployeeMoneyAuditOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeMoneyAuditOfWorkflow> result;
		ConditionEmployeeMoneyAuditOfWorkflow c = new ConditionEmployeeMoneyAuditOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeMoneyAuditOfWorkflow dao = new QueryEmployeeMoneyAuditOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeMoneyAuditOfWorkflow.ALL_CAPTIONS);
			for(BaseEmployeeMoneyAuditOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


