package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadTaskListOfApproveProjectStageStroage;
import pomplatform.workflow.bean.ConditionOnLoadTaskListOfApproveProjectStageStroage;
import pomplatform.workflow.query.QueryOnLoadTaskListOfApproveProjectStageStroage;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class OnLoadTaskListOfApproveProjectStageStroageHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadTaskListOfApproveProjectStageStroageHandler.class);

	public static BaseCollection<BaseOnLoadTaskListOfApproveProjectStageStroage> executeQueryOnLoadTaskListOfApproveProjectStageStroage(ConditionOnLoadTaskListOfApproveProjectStageStroage c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadTaskListOfApproveProjectStageStroage dao = new QueryOnLoadTaskListOfApproveProjectStageStroage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadTaskListOfApproveProjectStageStroage> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadTaskListOfApproveProjectStageStroage c = new ConditionOnLoadTaskListOfApproveProjectStageStroage();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadTaskListOfApproveProjectStageStroage> result = executeQueryOnLoadTaskListOfApproveProjectStageStroage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadTaskListOfApproveProjectStageStroage> result;
		ConditionOnLoadTaskListOfApproveProjectStageStroage c = new ConditionOnLoadTaskListOfApproveProjectStageStroage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadTaskListOfApproveProjectStageStroage dao = new QueryOnLoadTaskListOfApproveProjectStageStroage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadTaskListOfApproveProjectStageStroage.ALL_CAPTIONS);
			for(BaseOnLoadTaskListOfApproveProjectStageStroage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


