package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BasePreProjectAnalysisData;
import pomplatform.project.bean.ConditionPreProjectAnalysisData;
import pomplatform.project.query.QueryPreProjectAnalysisData;
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

public class PreProjectAnalysisDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PreProjectAnalysisDataHandler.class);

	public static BaseCollection<BasePreProjectAnalysisData> executeQueryPreProjectAnalysisData(ConditionPreProjectAnalysisData c, KeyValuePair[] replacements ) throws Exception {
		QueryPreProjectAnalysisData dao = new QueryPreProjectAnalysisData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePreProjectAnalysisData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPreProjectAnalysisData c = new ConditionPreProjectAnalysisData();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePreProjectAnalysisData> result = executeQueryPreProjectAnalysisData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePreProjectAnalysisData> result;
		ConditionPreProjectAnalysisData c = new ConditionPreProjectAnalysisData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPreProjectAnalysisData dao = new QueryPreProjectAnalysisData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePreProjectAnalysisData.EXITPORT_CAPTIONS);
			for(BasePreProjectAnalysisData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


