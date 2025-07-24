package pomplatform.approveProjectStageStorage.handler;

import org.apache.log4j.Logger;
import pomplatform.approveProjectStageStorage.bean.BaseSapproveprojectstagestorageor;
import pomplatform.approveProjectStageStorage.bean.ConditionSapproveprojectstagestorageor;
import pomplatform.approveProjectStageStorage.query.QuerySapproveprojectstagestorageor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.dao.ProjectStageStorage;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.dao.ProjectStage;
import delicacy.common.BaseCollection;

public class SapproveprojectstagestorageorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SapproveprojectstagestorageorHandler.class);

	public static BaseCollection<BaseSapproveprojectstagestorageor> executeQuerySapproveprojectstagestorageor(ConditionSapproveprojectstagestorageor c, KeyValuePair[] replacements ) throws Exception {
		QuerySapproveprojectstagestorageor dao = new QuerySapproveprojectstagestorageor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSapproveprojectstagestorageor> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProjectStageStorage daoProjectStageStorage = new ProjectStageStorage();
			ProjectStage daoProjectStage = new ProjectStage();
			for(BaseSapproveprojectstagestorageor bean : result.getCollections()){
				daoProjectStageStorage.setConditionProjectId("=", bean.getProjectId());
				bean.setDetailProjectStageStorage(daoProjectStageStorage.conditionalLoad(null));
				daoProjectStage.setConditionProjectId("=", bean.getProjectId());
				bean.setDetailProjectStage(daoProjectStage.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSapproveprojectstagestorageor c = new ConditionSapproveprojectstagestorageor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSapproveprojectstagestorageor> result = executeQuerySapproveprojectstagestorageor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSapproveprojectstagestorageor> result;
		ConditionSapproveprojectstagestorageor c = new ConditionSapproveprojectstagestorageor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySapproveprojectstagestorageor dao = new QuerySapproveprojectstagestorageor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSapproveprojectstagestorageor.ALL_CAPTIONS);
			for(BaseSapproveprojectstagestorageor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


