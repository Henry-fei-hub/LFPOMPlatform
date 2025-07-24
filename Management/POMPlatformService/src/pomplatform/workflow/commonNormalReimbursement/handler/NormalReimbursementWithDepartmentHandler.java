package pomplatform.workflow.commonNormalReimbursement.handler;

import org.apache.log4j.Logger;

import pomplatform.workflow.commonNormalReimbursement.bean.BaseNormalReimbursementWithDepartment;
import pomplatform.workflow.commonNormalReimbursement.bean.ConditionNormalReimbursementWithDepartment;
import pomplatform.workflow.commonNormalReimbursement.query.QueryNormalReimbursementWithDepartment;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkDepartment;
import com.pomplatform.db.dao.NormalReimbursementLinkDepartment;
import delicacy.common.BaseCollection;

public class NormalReimbursementWithDepartmentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NormalReimbursementWithDepartmentHandler.class);

	public static BaseCollection<BaseNormalReimbursementWithDepartment> executeQueryNormalReimbursementWithDepartment(ConditionNormalReimbursementWithDepartment c, KeyValuePair[] replacements ) throws Exception {
		QueryNormalReimbursementWithDepartment dao = new QueryNormalReimbursementWithDepartment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNormalReimbursementWithDepartment> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProjectNormalReimbursementDetail daoProjectNormalReimbursementDetail = new ProjectNormalReimbursementDetail();
			NormalReimbursementLinkDepartment daoNormalReimbursementLinkDepartment = new NormalReimbursementLinkDepartment();
			for(BaseNormalReimbursementWithDepartment bean : result.getCollections()){
				daoProjectNormalReimbursementDetail.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
				bean.setDetailProjectNormalReimbursementDetail(daoProjectNormalReimbursementDetail.conditionalLoad(null));
				daoNormalReimbursementLinkDepartment.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
				bean.setDetailNormalReimbursementLinkDepartment(daoNormalReimbursementLinkDepartment.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNormalReimbursementWithDepartment c = new ConditionNormalReimbursementWithDepartment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNormalReimbursementWithDepartment> result = executeQueryNormalReimbursementWithDepartment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNormalReimbursementWithDepartment> result;
		ConditionNormalReimbursementWithDepartment c = new ConditionNormalReimbursementWithDepartment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNormalReimbursementWithDepartment dao = new QueryNormalReimbursementWithDepartment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNormalReimbursementWithDepartment.ALL_CAPTIONS);
			for(BaseNormalReimbursementWithDepartment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


