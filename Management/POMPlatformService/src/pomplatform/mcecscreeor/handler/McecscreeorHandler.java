package pomplatform.mcecscreeor.handler;

import org.apache.log4j.Logger;
import pomplatform.mcecscreeor.bean.BaseMcecscreeor;
import pomplatform.mcecscreeor.bean.ConditionMcecscreeor;
import pomplatform.mcecscreeor.query.QueryMcecscreeor;
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

public class McecscreeorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McecscreeorHandler.class);

	public static BaseCollection<BaseMcecscreeor> executeQueryMcecscreeor(ConditionMcecscreeor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcecscreeor dao = new QueryMcecscreeor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcecscreeor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcecscreeor c = new ConditionMcecscreeor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcecscreeor> result = executeQueryMcecscreeor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcecscreeor> result;
		ConditionMcecscreeor c = new ConditionMcecscreeor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcecscreeor dao = new QueryMcecscreeor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcecscreeor.ALL_CAPTIONS);
			for(BaseMcecscreeor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


