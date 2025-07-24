package pomplatform.workflow.projectTravelReimbursement.handler;

import org.apache.log4j.Logger;

import pomplatform.workflow.projectTravelReimbursement.bean.BaseNewProjectTravelReimbursement;
import pomplatform.workflow.projectTravelReimbursement.bean.ConditionNewProjectTravelReimbursement;
import pomplatform.workflow.projectTravelReimbursement.query.QueryNewProjectTravelReimbursement;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseTravelReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursementDetail;
import com.pomplatform.db.bean.BaseTravelReimbursementLinkProject;
import com.pomplatform.db.dao.TravelReimbursementLinkProject;
import delicacy.common.BaseCollection;

public class NewProjectTravelReimbursementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NewProjectTravelReimbursementHandler.class);

	public static BaseCollection<BaseNewProjectTravelReimbursement> executeQueryNewProjectTravelReimbursement(ConditionNewProjectTravelReimbursement c, KeyValuePair[] replacements ) throws Exception {
		QueryNewProjectTravelReimbursement dao = new QueryNewProjectTravelReimbursement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNewProjectTravelReimbursement> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			TravelReimbursementDetail daoTravelReimbursementDetail = new TravelReimbursementDetail();
			TravelReimbursementLinkProject daoTravelReimbursementLinkProject = new TravelReimbursementLinkProject();
			for(BaseNewProjectTravelReimbursement bean : result.getCollections()){
				daoTravelReimbursementDetail.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				bean.setDetailTravelReimbursementDetail(daoTravelReimbursementDetail.conditionalLoad(null));
				daoTravelReimbursementLinkProject.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				bean.setDetailTravelReimbursementLinkProject(daoTravelReimbursementLinkProject.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNewProjectTravelReimbursement c = new ConditionNewProjectTravelReimbursement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNewProjectTravelReimbursement> result = executeQueryNewProjectTravelReimbursement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNewProjectTravelReimbursement> result;
		ConditionNewProjectTravelReimbursement c = new ConditionNewProjectTravelReimbursement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNewProjectTravelReimbursement dao = new QueryNewProjectTravelReimbursement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNewProjectTravelReimbursement.ALL_CAPTIONS);
			for(BaseNewProjectTravelReimbursement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


