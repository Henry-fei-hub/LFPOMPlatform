package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BasePreProjectTravelReimbursement;
import pomplatform.workflow.bean.ConditionPreProjectTravelReimbursement;
import pomplatform.workflow.query.QueryPreProjectTravelReimbursement;
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
import com.pomplatform.db.bean.BaseTravelReimbursementLinkMainProject;
import com.pomplatform.db.dao.TravelReimbursementLinkMainProject;
import delicacy.common.BaseCollection;

public class PreProjectTravelReimbursementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PreProjectTravelReimbursementHandler.class);

	public static BaseCollection<BasePreProjectTravelReimbursement> executeQueryPreProjectTravelReimbursement(ConditionPreProjectTravelReimbursement c, KeyValuePair[] replacements ) throws Exception {
		QueryPreProjectTravelReimbursement dao = new QueryPreProjectTravelReimbursement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePreProjectTravelReimbursement> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			TravelReimbursementDetail daoTravelReimbursementDetail = new TravelReimbursementDetail();
			TravelReimbursementLinkMainProject daoTravelReimbursementLinkMainProject = new TravelReimbursementLinkMainProject();
			for(BasePreProjectTravelReimbursement bean : result.getCollections()){
				daoTravelReimbursementDetail.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				bean.setDetailTravelReimbursementDetail(daoTravelReimbursementDetail.conditionalLoad(null));
				daoTravelReimbursementLinkMainProject.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				bean.setDetailTravelReimbursementLinkMainProject(daoTravelReimbursementLinkMainProject.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPreProjectTravelReimbursement c = new ConditionPreProjectTravelReimbursement();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePreProjectTravelReimbursement> result = executeQueryPreProjectTravelReimbursement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePreProjectTravelReimbursement> result;
		ConditionPreProjectTravelReimbursement c = new ConditionPreProjectTravelReimbursement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPreProjectTravelReimbursement dao = new QueryPreProjectTravelReimbursement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePreProjectTravelReimbursement.ALL_CAPTIONS);
			for(BasePreProjectTravelReimbursement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


