package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseProjectTravelReimbursement;
import pomplatform.workflow.bean.ConditionProjectTravelReimbursement;
import pomplatform.workflow.query.QueryProjectTravelReimbursement;
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
import delicacy.common.BaseCollection;

public class ProjectTravelReimbursementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectTravelReimbursementHandler.class);

	public static BaseCollection<BaseProjectTravelReimbursement> executeQueryProjectTravelReimbursement(ConditionProjectTravelReimbursement c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectTravelReimbursement dao = new QueryProjectTravelReimbursement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectTravelReimbursement> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			TravelReimbursementDetail daoTravelReimbursementDetail = new TravelReimbursementDetail();
			for(BaseProjectTravelReimbursement bean : result.getCollections()){
				daoTravelReimbursementDetail.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				bean.setDetailTravelReimbursementDetail(daoTravelReimbursementDetail.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectTravelReimbursement c = new ConditionProjectTravelReimbursement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectTravelReimbursement> result = executeQueryProjectTravelReimbursement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectTravelReimbursement> result;
		ConditionProjectTravelReimbursement c = new ConditionProjectTravelReimbursement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectTravelReimbursement dao = new QueryProjectTravelReimbursement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectTravelReimbursement.ALL_CAPTIONS);
			for(BaseProjectTravelReimbursement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


