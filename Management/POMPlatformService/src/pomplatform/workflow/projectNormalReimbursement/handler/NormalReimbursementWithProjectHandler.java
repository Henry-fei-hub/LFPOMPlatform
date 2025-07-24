package pomplatform.workflow.projectNormalReimbursement.handler;

import org.apache.log4j.Logger;

import pomplatform.workflow.projectNormalReimbursement.bean.BaseNormalReimbursementWithProject;
import pomplatform.workflow.projectNormalReimbursement.bean.ConditionNormalReimbursementWithProject;
import pomplatform.workflow.projectNormalReimbursement.query.QueryNormalReimbursementWithProject;
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
import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;
import com.pomplatform.db.dao.NormalReimbursementLinkProject;
import delicacy.common.BaseCollection;

public class NormalReimbursementWithProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NormalReimbursementWithProjectHandler.class);

	public static BaseCollection<BaseNormalReimbursementWithProject> executeQueryNormalReimbursementWithProject(ConditionNormalReimbursementWithProject c, KeyValuePair[] replacements ) throws Exception {
		QueryNormalReimbursementWithProject dao = new QueryNormalReimbursementWithProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNormalReimbursementWithProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProjectNormalReimbursementDetail daoProjectNormalReimbursementDetail = new ProjectNormalReimbursementDetail();
			NormalReimbursementLinkProject daoNormalReimbursementLinkProject = new NormalReimbursementLinkProject();
			for(BaseNormalReimbursementWithProject bean : result.getCollections()){
				daoProjectNormalReimbursementDetail.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
				bean.setDetailProjectNormalReimbursementDetail(daoProjectNormalReimbursementDetail.conditionalLoad(null));
				daoNormalReimbursementLinkProject.setConditionProjectNormalReimbursementId("=", bean.getProjectNormalReimbursementId());
				bean.setDetailNormalReimbursementLinkProject(daoNormalReimbursementLinkProject.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNormalReimbursementWithProject c = new ConditionNormalReimbursementWithProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNormalReimbursementWithProject> result = executeQueryNormalReimbursementWithProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNormalReimbursementWithProject> result;
		ConditionNormalReimbursementWithProject c = new ConditionNormalReimbursementWithProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNormalReimbursementWithProject dao = new QueryNormalReimbursementWithProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNormalReimbursementWithProject.ALL_CAPTIONS);
			for(BaseNormalReimbursementWithProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


