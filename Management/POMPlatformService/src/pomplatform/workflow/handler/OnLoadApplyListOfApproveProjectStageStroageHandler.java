package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import pomplatform.workflow.bean.BaseOnLoadApplyListOfApproveProjectStageStroage;
import pomplatform.workflow.bean.ConditionOnLoadApplyListOfApproveProjectStageStroage;
import pomplatform.workflow.query.QueryOnLoadApplyListOfApproveProjectStageStroage;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class OnLoadApplyListOfApproveProjectStageStroageHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfApproveProjectStageStroageHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfApproveProjectStageStroage> executeQueryOnLoadApplyListOfApproveProjectStageStroage(ConditionOnLoadApplyListOfApproveProjectStageStroage c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfApproveProjectStageStroage dao = new QueryOnLoadApplyListOfApproveProjectStageStroage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfApproveProjectStageStroage> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfApproveProjectStageStroage c = new ConditionOnLoadApplyListOfApproveProjectStageStroage();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfApproveProjectStageStroage> result = executeQueryOnLoadApplyListOfApproveProjectStageStroage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfApproveProjectStageStroage> result;
		ConditionOnLoadApplyListOfApproveProjectStageStroage c = new ConditionOnLoadApplyListOfApproveProjectStageStroage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfApproveProjectStageStroage dao = new QueryOnLoadApplyListOfApproveProjectStageStroage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfApproveProjectStageStroage.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfApproveProjectStageStroage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


