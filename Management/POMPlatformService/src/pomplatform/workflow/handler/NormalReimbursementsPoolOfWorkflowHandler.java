package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseNormalReimbursementsPoolOfWorkflow;
import pomplatform.workflow.bean.ConditionNormalReimbursementsPoolOfWorkflow;
import pomplatform.workflow.query.QueryNormalReimbursementsPoolOfWorkflow;
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

public class NormalReimbursementsPoolOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NormalReimbursementsPoolOfWorkflowHandler.class);

	public static BaseCollection<BaseNormalReimbursementsPoolOfWorkflow> executeQueryNormalReimbursementsPoolOfWorkflow(ConditionNormalReimbursementsPoolOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryNormalReimbursementsPoolOfWorkflow dao = new QueryNormalReimbursementsPoolOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNormalReimbursementsPoolOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNormalReimbursementsPoolOfWorkflow c = new ConditionNormalReimbursementsPoolOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNormalReimbursementsPoolOfWorkflow> result = executeQueryNormalReimbursementsPoolOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNormalReimbursementsPoolOfWorkflow> result;
		ConditionNormalReimbursementsPoolOfWorkflow c = new ConditionNormalReimbursementsPoolOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNormalReimbursementsPoolOfWorkflow dao = new QueryNormalReimbursementsPoolOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNormalReimbursementsPoolOfWorkflow.ALL_CAPTIONS);
			for(BaseNormalReimbursementsPoolOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


