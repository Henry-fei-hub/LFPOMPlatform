package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjects.bean.BaseMainProjectCompetitionInfo;
import pomplatform.preProjects.bean.ConditionMainProjectCompetitionInfo;
import pomplatform.preProjects.query.QueryMainProjectCompetitionInfo;
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

public class MainProjectCompetitionInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MainProjectCompetitionInfoHandler.class);

	public static BaseCollection<BaseMainProjectCompetitionInfo> executeQueryMainProjectCompetitionInfo(ConditionMainProjectCompetitionInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryMainProjectCompetitionInfo dao = new QueryMainProjectCompetitionInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMainProjectCompetitionInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMainProjectCompetitionInfo c = new ConditionMainProjectCompetitionInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMainProjectCompetitionInfo> result = executeQueryMainProjectCompetitionInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMainProjectCompetitionInfo> result;
		ConditionMainProjectCompetitionInfo c = new ConditionMainProjectCompetitionInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMainProjectCompetitionInfo dao = new QueryMainProjectCompetitionInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMainProjectCompetitionInfo.ALL_CAPTIONS);
			for(BaseMainProjectCompetitionInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


