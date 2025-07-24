package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjects.bean.BaseLoadCompetitionUnitsData;
import pomplatform.preProjects.bean.ConditionLoadCompetitionUnitsData;
import pomplatform.preProjects.query.QueryLoadCompetitionUnitsData;
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

public class LoadCompetitionUnitsDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(LoadCompetitionUnitsDataHandler.class);

	public static BaseCollection<BaseLoadCompetitionUnitsData> executeQueryLoadCompetitionUnitsData(ConditionLoadCompetitionUnitsData c, KeyValuePair[] replacements ) throws Exception {
		QueryLoadCompetitionUnitsData dao = new QueryLoadCompetitionUnitsData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseLoadCompetitionUnitsData> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionLoadCompetitionUnitsData c = new ConditionLoadCompetitionUnitsData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseLoadCompetitionUnitsData> result = executeQueryLoadCompetitionUnitsData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseLoadCompetitionUnitsData> result;
		ConditionLoadCompetitionUnitsData c = new ConditionLoadCompetitionUnitsData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryLoadCompetitionUnitsData dao = new QueryLoadCompetitionUnitsData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseLoadCompetitionUnitsData.ALL_CAPTIONS);
			for(BaseLoadCompetitionUnitsData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


