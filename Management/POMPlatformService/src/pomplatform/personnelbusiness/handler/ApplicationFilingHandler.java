package pomplatform.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.personnelbusiness.bean.BaseApplicationFiling;
import pomplatform.personnelbusiness.bean.ConditionApplicationFiling;
import pomplatform.personnelbusiness.query.QueryApplicationFiling;
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

public class ApplicationFilingHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ApplicationFilingHandler.class);

	public static BaseCollection<BaseApplicationFiling> executeQueryApplicationFiling(ConditionApplicationFiling c, KeyValuePair[] replacements ) throws Exception {
		QueryApplicationFiling dao = new QueryApplicationFiling();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseApplicationFiling> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionApplicationFiling c = new ConditionApplicationFiling();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseApplicationFiling> result = executeQueryApplicationFiling(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseApplicationFiling> result;
		ConditionApplicationFiling c = new ConditionApplicationFiling();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryApplicationFiling dao = new QueryApplicationFiling();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseApplicationFiling.ALL_CAPTIONS);
			for(BaseApplicationFiling b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


