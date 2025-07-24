package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnLoadFinishStagePercent;
import pomplatform.project.bean.ConditionOnLoadFinishStagePercent;
import pomplatform.project.query.QueryOnLoadFinishStagePercent;
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

public class OnLoadFinishStagePercentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadFinishStagePercentHandler.class);

	public static BaseCollection<BaseOnLoadFinishStagePercent> executeQueryOnLoadFinishStagePercent(ConditionOnLoadFinishStagePercent c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadFinishStagePercent dao = new QueryOnLoadFinishStagePercent();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadFinishStagePercent> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadFinishStagePercent c = new ConditionOnLoadFinishStagePercent();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadFinishStagePercent> result = executeQueryOnLoadFinishStagePercent(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadFinishStagePercent> result;
		ConditionOnLoadFinishStagePercent c = new ConditionOnLoadFinishStagePercent();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadFinishStagePercent dao = new QueryOnLoadFinishStagePercent();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadFinishStagePercent.ALL_CAPTIONS);
			for(BaseOnLoadFinishStagePercent b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


