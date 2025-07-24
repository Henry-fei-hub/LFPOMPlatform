package pomplatform.soutdesignconsiderationoor.handler;

import org.apache.log4j.Logger;
import pomplatform.soutdesignconsiderationoor.bean.BaseSoutdesignconsiderationoor;
import pomplatform.soutdesignconsiderationoor.bean.ConditionSoutdesignconsiderationoor;
import pomplatform.soutdesignconsiderationoor.query.QuerySoutdesignconsiderationoor;
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

public class SoutdesignconsiderationoorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SoutdesignconsiderationoorHandler.class);

	public static BaseCollection<BaseSoutdesignconsiderationoor> executeQuerySoutdesignconsiderationoor(ConditionSoutdesignconsiderationoor c, KeyValuePair[] replacements ) throws Exception {
		QuerySoutdesignconsiderationoor dao = new QuerySoutdesignconsiderationoor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSoutdesignconsiderationoor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSoutdesignconsiderationoor c = new ConditionSoutdesignconsiderationoor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSoutdesignconsiderationoor> result = executeQuerySoutdesignconsiderationoor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSoutdesignconsiderationoor> result;
		ConditionSoutdesignconsiderationoor c = new ConditionSoutdesignconsiderationoor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySoutdesignconsiderationoor dao = new QuerySoutdesignconsiderationoor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSoutdesignconsiderationoor.ALL_CAPTIONS);
			for(BaseSoutdesignconsiderationoor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


