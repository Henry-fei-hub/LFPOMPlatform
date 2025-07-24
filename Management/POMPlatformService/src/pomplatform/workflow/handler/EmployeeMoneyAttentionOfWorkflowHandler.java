package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseEmployeeMoneyAttentionOfWorkflow;
import pomplatform.workflow.bean.ConditionEmployeeMoneyAttentionOfWorkflow;
import pomplatform.workflow.query.QueryEmployeeMoneyAttentionOfWorkflow;
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

public class EmployeeMoneyAttentionOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeMoneyAttentionOfWorkflowHandler.class);

	public static BaseCollection<BaseEmployeeMoneyAttentionOfWorkflow> executeQueryEmployeeMoneyAttentionOfWorkflow(ConditionEmployeeMoneyAttentionOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeMoneyAttentionOfWorkflow dao = new QueryEmployeeMoneyAttentionOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeMoneyAttentionOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeMoneyAttentionOfWorkflow c = new ConditionEmployeeMoneyAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeMoneyAttentionOfWorkflow> result = executeQueryEmployeeMoneyAttentionOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeMoneyAttentionOfWorkflow> result;
		ConditionEmployeeMoneyAttentionOfWorkflow c = new ConditionEmployeeMoneyAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeMoneyAttentionOfWorkflow dao = new QueryEmployeeMoneyAttentionOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeMoneyAttentionOfWorkflow.ALL_CAPTIONS);
			for(BaseEmployeeMoneyAttentionOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


