package pomplatform.clientctractor.handler;

import org.apache.log4j.Logger;
import pomplatform.clientctractor.bean.BaseMclientctractor;
import pomplatform.clientctractor.bean.ConditionMclientctractor;
import pomplatform.clientctractor.query.QueryMclientctractor;
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

public class MclientctractorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MclientctractorHandler.class);

	public static BaseCollection<BaseMclientctractor> executeQueryMclientctractor(ConditionMclientctractor c, KeyValuePair[] replacements ) throws Exception {
		QueryMclientctractor dao = new QueryMclientctractor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMclientctractor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMclientctractor c = new ConditionMclientctractor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMclientctractor> result = executeQueryMclientctractor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMclientctractor> result;
		ConditionMclientctractor c = new ConditionMclientctractor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMclientctractor dao = new QueryMclientctractor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMclientctractor.ALL_CAPTIONS);
			for(BaseMclientctractor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


