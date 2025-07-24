package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BasePreProjectNormalReimbursement;
import pomplatform.workflow.bean.ConditionPreProjectNormalReimbursement;
import pomplatform.workflow.query.QueryPreProjectNormalReimbursement;
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
import com.pomplatform.db.bean.BaseNormalReimbursementLinkMainProject;
import com.pomplatform.db.dao.NormalReimbursementLinkMainProject;
import delicacy.common.BaseCollection;

public class PreProjectNormalReimbursementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PreProjectNormalReimbursementHandler.class);

	public static BaseCollection<BasePreProjectNormalReimbursement> executeQueryPreProjectNormalReimbursement(ConditionPreProjectNormalReimbursement c, KeyValuePair[] replacements ) throws Exception {
		QueryPreProjectNormalReimbursement dao = new QueryPreProjectNormalReimbursement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePreProjectNormalReimbursement> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProjectNormalReimbursementDetail daoProjectNormalReimbursementDetail = new ProjectNormalReimbursementDetail();
			NormalReimbursementLinkMainProject daoNormalReimbursementLinkMainProject = new NormalReimbursementLinkMainProject();
			for(BasePreProjectNormalReimbursement bean : result.getCollections()){
				daoProjectNormalReimbursementDetail.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
				bean.setDetailProjectNormalReimbursementDetail(daoProjectNormalReimbursementDetail.conditionalLoad(null));
				daoNormalReimbursementLinkMainProject.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
				bean.setDetailNormalReimbursementLinkMainProject(daoNormalReimbursementLinkMainProject.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPreProjectNormalReimbursement c = new ConditionPreProjectNormalReimbursement();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePreProjectNormalReimbursement> result = executeQueryPreProjectNormalReimbursement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePreProjectNormalReimbursement> result;
		ConditionPreProjectNormalReimbursement c = new ConditionPreProjectNormalReimbursement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPreProjectNormalReimbursement dao = new QueryPreProjectNormalReimbursement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePreProjectNormalReimbursement.ALL_CAPTIONS);
			for(BasePreProjectNormalReimbursement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


