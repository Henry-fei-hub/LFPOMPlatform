package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import pomplatform.workflow.bean.BaseOnLoadAuditListOfApproveProjectStageStroage;
import pomplatform.workflow.bean.ConditionOnLoadAuditListOfApproveProjectStageStroage;
import pomplatform.workflow.query.QueryOnLoadAuditListOfApproveProjectStageStroage;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class OnLoadAuditListOfApproveProjectStageStroageHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfApproveProjectStageStroageHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfApproveProjectStageStroage> executeQueryOnLoadAuditListOfApproveProjectStageStroage(ConditionOnLoadAuditListOfApproveProjectStageStroage c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfApproveProjectStageStroage dao = new QueryOnLoadAuditListOfApproveProjectStageStroage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfApproveProjectStageStroage> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfApproveProjectStageStroage c = new ConditionOnLoadAuditListOfApproveProjectStageStroage();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfApproveProjectStageStroage> result = executeQueryOnLoadAuditListOfApproveProjectStageStroage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfApproveProjectStageStroage> result;
		ConditionOnLoadAuditListOfApproveProjectStageStroage c = new ConditionOnLoadAuditListOfApproveProjectStageStroage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfApproveProjectStageStroage dao = new QueryOnLoadAuditListOfApproveProjectStageStroage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfApproveProjectStageStroage.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfApproveProjectStageStroage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


