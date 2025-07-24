package pomplatform.sreimbursementpackagedetailrror.handler;

import org.apache.log4j.Logger;
import pomplatform.sreimbursementpackagedetailrror.bean.BaseSreimbursementpackagedetailrror;
import pomplatform.sreimbursementpackagedetailrror.bean.ConditionSreimbursementpackagedetailrror;
import pomplatform.sreimbursementpackagedetailrror.query.QuerySreimbursementpackagedetailrror;
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

public class SreimbursementpackagedetailrrorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SreimbursementpackagedetailrrorHandler.class);

	public static BaseCollection<BaseSreimbursementpackagedetailrror> executeQuerySreimbursementpackagedetailrror(ConditionSreimbursementpackagedetailrror c, KeyValuePair[] replacements ) throws Exception {
		QuerySreimbursementpackagedetailrror dao = new QuerySreimbursementpackagedetailrror();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSreimbursementpackagedetailrror> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSreimbursementpackagedetailrror c = new ConditionSreimbursementpackagedetailrror();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSreimbursementpackagedetailrror> result = executeQuerySreimbursementpackagedetailrror(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSreimbursementpackagedetailrror> result;
		ConditionSreimbursementpackagedetailrror c = new ConditionSreimbursementpackagedetailrror();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySreimbursementpackagedetailrror dao = new QuerySreimbursementpackagedetailrror();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSreimbursementpackagedetailrror.ALL_CAPTIONS);
			for(BaseSreimbursementpackagedetailrror b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


