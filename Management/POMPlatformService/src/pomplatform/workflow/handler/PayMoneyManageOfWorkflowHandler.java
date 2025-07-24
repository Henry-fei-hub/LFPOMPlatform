package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BasePayMoneyManageOfWorkflow;
import pomplatform.workflow.bean.ConditionPayMoneyManageOfWorkflow;
import pomplatform.workflow.query.QueryPayMoneyManageOfWorkflow;
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

public class PayMoneyManageOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PayMoneyManageOfWorkflowHandler.class);

	public static BaseCollection<BasePayMoneyManageOfWorkflow> executeQueryPayMoneyManageOfWorkflow(ConditionPayMoneyManageOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryPayMoneyManageOfWorkflow dao = new QueryPayMoneyManageOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePayMoneyManageOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPayMoneyManageOfWorkflow c = new ConditionPayMoneyManageOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePayMoneyManageOfWorkflow> result = executeQueryPayMoneyManageOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePayMoneyManageOfWorkflow> result;
		ConditionPayMoneyManageOfWorkflow c = new ConditionPayMoneyManageOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPayMoneyManageOfWorkflow dao = new QueryPayMoneyManageOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePayMoneyManageOfWorkflow.ALL_CAPTIONS);
			for(BasePayMoneyManageOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


