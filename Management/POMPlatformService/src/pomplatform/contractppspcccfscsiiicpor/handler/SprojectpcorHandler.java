package pomplatform.contractppspcccfscsiiicpor.handler;

import org.apache.log4j.Logger;
import pomplatform.contractppspcccfscsiiicpor.bean.BaseSprojectpcor;
import pomplatform.contractppspcccfscsiiicpor.bean.ConditionSprojectpcor;
import pomplatform.contractppspcccfscsiiicpor.query.QuerySprojectpcor;
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

public class SprojectpcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectpcorHandler.class);

	public static BaseCollection<BaseSprojectpcor> executeQuerySprojectpcor(ConditionSprojectpcor c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectpcor dao = new QuerySprojectpcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectpcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectpcor c = new ConditionSprojectpcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectpcor> result = executeQuerySprojectpcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectpcor> result;
		ConditionSprojectpcor c = new ConditionSprojectpcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectpcor dao = new QuerySprojectpcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSprojectpcor.ALL_CAPTIONS);
			for(BaseSprojectpcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


