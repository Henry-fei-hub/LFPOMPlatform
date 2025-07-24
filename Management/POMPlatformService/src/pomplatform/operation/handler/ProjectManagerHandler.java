package pomplatform.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.operation.bean.BaseProjectManager;
import pomplatform.operation.bean.ConditionProjectManager;
import pomplatform.operation.query.QueryProjectManager;
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

public class ProjectManagerHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectManagerHandler.class);

	public static BaseCollection<BaseProjectManager> executeQueryProjectManager(ConditionProjectManager c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectManager dao = new QueryProjectManager();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectManager> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectManager c = new ConditionProjectManager();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectManager> result = executeQueryProjectManager(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectManager> result;
		ConditionProjectManager c = new ConditionProjectManager();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectManager dao = new QueryProjectManager();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectManager.ALL_CAPTIONS);
			for(BaseProjectManager b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


