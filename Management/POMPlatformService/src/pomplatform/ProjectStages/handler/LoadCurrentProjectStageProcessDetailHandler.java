package pomplatform.ProjectStages.handler;

import org.apache.log4j.Logger;
import pomplatform.ProjectStages.bean.BaseLoadCurrentProjectStageProcessDetail;
import pomplatform.ProjectStages.bean.ConditionLoadCurrentProjectStageProcessDetail;
import pomplatform.ProjectStages.query.QueryLoadCurrentProjectStageProcessDetail;
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

public class LoadCurrentProjectStageProcessDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(LoadCurrentProjectStageProcessDetailHandler.class);

	public static BaseCollection<BaseLoadCurrentProjectStageProcessDetail> executeQueryLoadCurrentProjectStageProcessDetail(ConditionLoadCurrentProjectStageProcessDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryLoadCurrentProjectStageProcessDetail dao = new QueryLoadCurrentProjectStageProcessDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseLoadCurrentProjectStageProcessDetail> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionLoadCurrentProjectStageProcessDetail c = new ConditionLoadCurrentProjectStageProcessDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseLoadCurrentProjectStageProcessDetail> result = executeQueryLoadCurrentProjectStageProcessDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseLoadCurrentProjectStageProcessDetail> result;
		ConditionLoadCurrentProjectStageProcessDetail c = new ConditionLoadCurrentProjectStageProcessDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryLoadCurrentProjectStageProcessDetail dao = new QueryLoadCurrentProjectStageProcessDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseLoadCurrentProjectStageProcessDetail.ALL_CAPTIONS);
			for(BaseLoadCurrentProjectStageProcessDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


