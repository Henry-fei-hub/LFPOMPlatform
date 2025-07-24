package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import pomplatform.workflow.bean.BaseOnLoadAttentionListOfApproveProjectStageStroage;
import pomplatform.workflow.bean.ConditionOnLoadAttentionListOfApproveProjectStageStroage;
import pomplatform.workflow.query.QueryOnLoadAttentionListOfApproveProjectStageStroage;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class OnLoadAttentionListOfApproveProjectStageStroageHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttentionListOfApproveProjectStageStroageHandler.class);

	public static BaseCollection<BaseOnLoadAttentionListOfApproveProjectStageStroage> executeQueryOnLoadAttentionListOfApproveProjectStageStroage(ConditionOnLoadAttentionListOfApproveProjectStageStroage c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttentionListOfApproveProjectStageStroage dao = new QueryOnLoadAttentionListOfApproveProjectStageStroage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttentionListOfApproveProjectStageStroage> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttentionListOfApproveProjectStageStroage c = new ConditionOnLoadAttentionListOfApproveProjectStageStroage();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttentionListOfApproveProjectStageStroage> result = executeQueryOnLoadAttentionListOfApproveProjectStageStroage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttentionListOfApproveProjectStageStroage> result;
		ConditionOnLoadAttentionListOfApproveProjectStageStroage c = new ConditionOnLoadAttentionListOfApproveProjectStageStroage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttentionListOfApproveProjectStageStroage dao = new QueryOnLoadAttentionListOfApproveProjectStageStroage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttentionListOfApproveProjectStageStroage.ALL_CAPTIONS);
			for(BaseOnLoadAttentionListOfApproveProjectStageStroage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


