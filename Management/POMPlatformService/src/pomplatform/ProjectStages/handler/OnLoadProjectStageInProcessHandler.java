package pomplatform.ProjectStages.handler;

import org.apache.log4j.Logger;
import pomplatform.ProjectStages.bean.BaseOnLoadProjectStageInProcess;
import pomplatform.ProjectStages.bean.ConditionOnLoadProjectStageInProcess;
import pomplatform.ProjectStages.query.QueryOnLoadProjectStageInProcess;
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

public class OnLoadProjectStageInProcessHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectStageInProcessHandler.class);

	public static BaseCollection<BaseOnLoadProjectStageInProcess> executeQueryOnLoadProjectStageInProcess(ConditionOnLoadProjectStageInProcess c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectStageInProcess dao = new QueryOnLoadProjectStageInProcess();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectStageInProcess> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectStageInProcess c = new ConditionOnLoadProjectStageInProcess();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectStageInProcess> result = executeQueryOnLoadProjectStageInProcess(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectStageInProcess> result;
		ConditionOnLoadProjectStageInProcess c = new ConditionOnLoadProjectStageInProcess();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectStageInProcess dao = new QueryOnLoadProjectStageInProcess();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectStageInProcess.ALL_CAPTIONS);
			for(BaseOnLoadProjectStageInProcess b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


