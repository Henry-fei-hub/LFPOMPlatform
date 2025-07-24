package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BasePayMoneyAttentionOfWorkflow;
import pomplatform.workflow.bean.ConditionPayMoneyAttentionOfWorkflow;
import pomplatform.workflow.query.QueryPayMoneyAttentionOfWorkflow;
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

public class PayMoneyAttentionOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PayMoneyAttentionOfWorkflowHandler.class);

	public static BaseCollection<BasePayMoneyAttentionOfWorkflow> executeQueryPayMoneyAttentionOfWorkflow(ConditionPayMoneyAttentionOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryPayMoneyAttentionOfWorkflow dao = new QueryPayMoneyAttentionOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePayMoneyAttentionOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPayMoneyAttentionOfWorkflow c = new ConditionPayMoneyAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePayMoneyAttentionOfWorkflow> result = executeQueryPayMoneyAttentionOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePayMoneyAttentionOfWorkflow> result;
		ConditionPayMoneyAttentionOfWorkflow c = new ConditionPayMoneyAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPayMoneyAttentionOfWorkflow dao = new QueryPayMoneyAttentionOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePayMoneyAttentionOfWorkflow.ALL_CAPTIONS);
			for(BasePayMoneyAttentionOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


