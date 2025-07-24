package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseTravelReimbursementsAttentionOfWorkflow;
import pomplatform.workflow.bean.ConditionTravelReimbursementsAttentionOfWorkflow;
import pomplatform.workflow.query.QueryTravelReimbursementsAttentionOfWorkflow;
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

public class TravelReimbursementsAttentionOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TravelReimbursementsAttentionOfWorkflowHandler.class);

	public static BaseCollection<BaseTravelReimbursementsAttentionOfWorkflow> executeQueryTravelReimbursementsAttentionOfWorkflow(ConditionTravelReimbursementsAttentionOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryTravelReimbursementsAttentionOfWorkflow dao = new QueryTravelReimbursementsAttentionOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTravelReimbursementsAttentionOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTravelReimbursementsAttentionOfWorkflow c = new ConditionTravelReimbursementsAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTravelReimbursementsAttentionOfWorkflow> result = executeQueryTravelReimbursementsAttentionOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTravelReimbursementsAttentionOfWorkflow> result;
		ConditionTravelReimbursementsAttentionOfWorkflow c = new ConditionTravelReimbursementsAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTravelReimbursementsAttentionOfWorkflow dao = new QueryTravelReimbursementsAttentionOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTravelReimbursementsAttentionOfWorkflow.ALL_CAPTIONS);
			for(BaseTravelReimbursementsAttentionOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


