package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseOnRevenueSureWarn;
import pomplatform.project.bean.ConditionOnRevenueSureWarn;
import pomplatform.project.query.QueryOnRevenueSureWarn;
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

public class OnRevenueSureWarnHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnRevenueSureWarnHandler.class);

	public static BaseCollection<BaseOnRevenueSureWarn> executeQueryOnRevenueSureWarn(ConditionOnRevenueSureWarn c, KeyValuePair[] replacements ) throws Exception {
		QueryOnRevenueSureWarn dao = new QueryOnRevenueSureWarn();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnRevenueSureWarn> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnRevenueSureWarn c = new ConditionOnRevenueSureWarn();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnRevenueSureWarn> result = executeQueryOnRevenueSureWarn(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnRevenueSureWarn> result;
		ConditionOnRevenueSureWarn c = new ConditionOnRevenueSureWarn();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnRevenueSureWarn dao = new QueryOnRevenueSureWarn();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnRevenueSureWarn.ALL_CAPTIONS);
			for(BaseOnRevenueSureWarn b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


