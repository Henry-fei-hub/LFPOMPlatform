package pomplatform.newOutdesignconsiderationor.handler;

import org.apache.log4j.Logger;
import pomplatform.newOutdesignconsiderationor.bean.BaseSoutdesignconsiderationor;
import pomplatform.newOutdesignconsiderationor.bean.ConditionSoutdesignconsiderationor;
import pomplatform.newOutdesignconsiderationor.query.QuerySoutdesignconsiderationor;
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

public class SoutdesignconsiderationorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SoutdesignconsiderationorHandler.class);

	public static BaseCollection<BaseSoutdesignconsiderationor> executeQuerySoutdesignconsiderationor(ConditionSoutdesignconsiderationor c, KeyValuePair[] replacements ) throws Exception {
		QuerySoutdesignconsiderationor dao = new QuerySoutdesignconsiderationor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSoutdesignconsiderationor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSoutdesignconsiderationor c = new ConditionSoutdesignconsiderationor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSoutdesignconsiderationor> result = executeQuerySoutdesignconsiderationor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSoutdesignconsiderationor> result;
		ConditionSoutdesignconsiderationor c = new ConditionSoutdesignconsiderationor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySoutdesignconsiderationor dao = new QuerySoutdesignconsiderationor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSoutdesignconsiderationor.ALL_CAPTIONS);
			for(BaseSoutdesignconsiderationor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


