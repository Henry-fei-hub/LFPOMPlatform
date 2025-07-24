package pomplatform.company.handler;

import org.apache.log4j.Logger;
import pomplatform.company.bean.BaseJobManager;
import pomplatform.company.bean.ConditionJobManager;
import pomplatform.company.query.QueryJobManager;
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

public class JobManagerHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(JobManagerHandler.class);

	public static BaseCollection<BaseJobManager> executeQueryJobManager(ConditionJobManager c, KeyValuePair[] replacements ) throws Exception {
		QueryJobManager dao = new QueryJobManager();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseJobManager> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionJobManager c = new ConditionJobManager();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseJobManager> result = executeQueryJobManager(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseJobManager> result;
		ConditionJobManager c = new ConditionJobManager();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryJobManager dao = new QueryJobManager();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseJobManager.ALL_CAPTIONS);
			for(BaseJobManager b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


