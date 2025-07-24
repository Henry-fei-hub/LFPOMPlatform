package pomplatform.workflow.commonTravelReimbursement.handler;

import org.apache.log4j.Logger;

import pomplatform.workflow.commonTravelReimbursement.bean.BaseTravelReimbursementWithDepartment;
import pomplatform.workflow.commonTravelReimbursement.bean.ConditionTravelReimbursementWithDepartment;
import pomplatform.workflow.commonTravelReimbursement.query.QueryTravelReimbursementWithDepartment;
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
import com.pomplatform.db.bean.BaseTravelReimbursementLinkDepartment;
import com.pomplatform.db.dao.TravelReimbursementLinkDepartment;
import delicacy.common.BaseCollection;

public class TravelReimbursementWithDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TravelReimbursementWithDepartmentHandler.class);

	public static BaseCollection<BaseTravelReimbursementWithDepartment> executeQueryTravelReimbursementWithDepartment(ConditionTravelReimbursementWithDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryTravelReimbursementWithDepartment dao = new QueryTravelReimbursementWithDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTravelReimbursementWithDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			TravelReimbursementDetail daoTravelReimbursementDetail = new TravelReimbursementDetail();
			TravelReimbursementLinkDepartment daoTravelReimbursementLinkDepartment = new TravelReimbursementLinkDepartment();
			for(BaseTravelReimbursementWithDepartment bean : result.getCollections()){
				daoTravelReimbursementDetail.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				bean.setDetailTravelReimbursementDetail(daoTravelReimbursementDetail.conditionalLoad(null));
				daoTravelReimbursementLinkDepartment.setConditionTravelReimbursementId("=", bean.getTravelReimbursementId());
				bean.setDetailTravelReimbursementLinkDepartment(daoTravelReimbursementLinkDepartment.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTravelReimbursementWithDepartment c = new ConditionTravelReimbursementWithDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTravelReimbursementWithDepartment> result = executeQueryTravelReimbursementWithDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTravelReimbursementWithDepartment> result;
		ConditionTravelReimbursementWithDepartment c = new ConditionTravelReimbursementWithDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTravelReimbursementWithDepartment dao = new QueryTravelReimbursementWithDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTravelReimbursementWithDepartment.ALL_CAPTIONS);
			for(BaseTravelReimbursementWithDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


