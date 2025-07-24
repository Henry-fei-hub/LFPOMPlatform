package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseTravelReimbursementsPoolOfWorkflow;
import pomplatform.workflow.bean.ConditionTravelReimbursementsPoolOfWorkflow;
import pomplatform.workflow.query.QueryTravelReimbursementsPoolOfWorkflow;
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

public class TravelReimbursementsPoolOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TravelReimbursementsPoolOfWorkflowHandler.class);

	public static BaseCollection<BaseTravelReimbursementsPoolOfWorkflow> executeQueryTravelReimbursementsPoolOfWorkflow(ConditionTravelReimbursementsPoolOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryTravelReimbursementsPoolOfWorkflow dao = new QueryTravelReimbursementsPoolOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTravelReimbursementsPoolOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTravelReimbursementsPoolOfWorkflow c = new ConditionTravelReimbursementsPoolOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTravelReimbursementsPoolOfWorkflow> result = executeQueryTravelReimbursementsPoolOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTravelReimbursementsPoolOfWorkflow> result;
		ConditionTravelReimbursementsPoolOfWorkflow c = new ConditionTravelReimbursementsPoolOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTravelReimbursementsPoolOfWorkflow dao = new QueryTravelReimbursementsPoolOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTravelReimbursementsPoolOfWorkflow.ALL_CAPTIONS);
			for(BaseTravelReimbursementsPoolOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


