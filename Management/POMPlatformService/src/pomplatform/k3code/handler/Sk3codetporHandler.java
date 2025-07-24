package pomplatform.k3code.handler;

import org.apache.log4j.Logger;
import pomplatform.k3code.bean.BaseSk3codetpor;
import pomplatform.k3code.bean.ConditionSk3codetpor;
import pomplatform.k3code.query.QuerySk3codetpor;
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

public class Sk3codetporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(Sk3codetporHandler.class);

	public static BaseCollection<BaseSk3codetpor> executeQuerySk3codetpor(ConditionSk3codetpor c, KeyValuePair[] replacements ) throws Exception {
		QuerySk3codetpor dao = new QuerySk3codetpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSk3codetpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSk3codetpor c = new ConditionSk3codetpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSk3codetpor> result = executeQuerySk3codetpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSk3codetpor> result;
		ConditionSk3codetpor c = new ConditionSk3codetpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySk3codetpor dao = new QuerySk3codetpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSk3codetpor.ALL_CAPTIONS);
			for(BaseSk3codetpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


