package pomplatform.sreimbursementpackagesummaryrror.handler;

import org.apache.log4j.Logger;
import pomplatform.sreimbursementpackagesummaryrror.bean.BaseSreimbursementpackagesummaryrror;
import pomplatform.sreimbursementpackagesummaryrror.bean.ConditionSreimbursementpackagesummaryrror;
import pomplatform.sreimbursementpackagesummaryrror.query.QuerySreimbursementpackagesummaryrror;
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

public class SreimbursementpackagesummaryrrorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SreimbursementpackagesummaryrrorHandler.class);

	public static BaseCollection<BaseSreimbursementpackagesummaryrror> executeQuerySreimbursementpackagesummaryrror(ConditionSreimbursementpackagesummaryrror c, KeyValuePair[] replacements ) throws Exception {
		QuerySreimbursementpackagesummaryrror dao = new QuerySreimbursementpackagesummaryrror();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSreimbursementpackagesummaryrror> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSreimbursementpackagesummaryrror c = new ConditionSreimbursementpackagesummaryrror();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSreimbursementpackagesummaryrror> result = executeQuerySreimbursementpackagesummaryrror(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSreimbursementpackagesummaryrror> result;
		ConditionSreimbursementpackagesummaryrror c = new ConditionSreimbursementpackagesummaryrror();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySreimbursementpackagesummaryrror dao = new QuerySreimbursementpackagesummaryrror();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSreimbursementpackagesummaryrror.ALL_CAPTIONS);
			for(BaseSreimbursementpackagesummaryrror b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


