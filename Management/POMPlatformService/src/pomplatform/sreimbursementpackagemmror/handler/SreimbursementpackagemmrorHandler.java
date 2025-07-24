package pomplatform.sreimbursementpackagemmror.handler;

import org.apache.log4j.Logger;
import pomplatform.sreimbursementpackagemmror.bean.BaseSreimbursementpackagemmror;
import pomplatform.sreimbursementpackagemmror.bean.ConditionSreimbursementpackagemmror;
import pomplatform.sreimbursementpackagemmror.query.QuerySreimbursementpackagemmror;
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

public class SreimbursementpackagemmrorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SreimbursementpackagemmrorHandler.class);

	public static BaseCollection<BaseSreimbursementpackagemmror> executeQuerySreimbursementpackagemmror(ConditionSreimbursementpackagemmror c, KeyValuePair[] replacements ) throws Exception {
		QuerySreimbursementpackagemmror dao = new QuerySreimbursementpackagemmror();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSreimbursementpackagemmror> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSreimbursementpackagemmror c = new ConditionSreimbursementpackagemmror();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSreimbursementpackagemmror> result = executeQuerySreimbursementpackagemmror(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSreimbursementpackagemmror> result;
		ConditionSreimbursementpackagemmror c = new ConditionSreimbursementpackagemmror();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySreimbursementpackagemmror dao = new QuerySreimbursementpackagemmror();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSreimbursementpackagemmror.ALL_CAPTIONS);
			for(BaseSreimbursementpackagemmror b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


