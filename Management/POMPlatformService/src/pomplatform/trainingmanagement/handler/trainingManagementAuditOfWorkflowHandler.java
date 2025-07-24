package pomplatform.trainingmanagement.handler;

import org.apache.log4j.Logger;
import pomplatform.trainingmanagement.bean.BasetrainingManagementAuditOfWorkflow;
import pomplatform.trainingmanagement.bean.ConditiontrainingManagementAuditOfWorkflow;
import pomplatform.trainingmanagement.query.QuerytrainingManagementAuditOfWorkflow;
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

public class trainingManagementAuditOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(trainingManagementAuditOfWorkflowHandler.class);

	public static BaseCollection<BasetrainingManagementAuditOfWorkflow> executeQuerytrainingManagementAuditOfWorkflow(ConditiontrainingManagementAuditOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QuerytrainingManagementAuditOfWorkflow dao = new QuerytrainingManagementAuditOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasetrainingManagementAuditOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditiontrainingManagementAuditOfWorkflow c = new ConditiontrainingManagementAuditOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BasetrainingManagementAuditOfWorkflow> result = executeQuerytrainingManagementAuditOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasetrainingManagementAuditOfWorkflow> result;
		ConditiontrainingManagementAuditOfWorkflow c = new ConditiontrainingManagementAuditOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerytrainingManagementAuditOfWorkflow dao = new QuerytrainingManagementAuditOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasetrainingManagementAuditOfWorkflow.ALL_CAPTIONS);
			for(BasetrainingManagementAuditOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


