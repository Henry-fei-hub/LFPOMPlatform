package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseProjectOfProjectManager;
import pomplatform.project.bean.ConditionProjectOfProjectManager;
import pomplatform.project.query.QueryProjectOfProjectManager;
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

public class ProjectOfProjectManagerHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectOfProjectManagerHandler.class);

	public static BaseCollection<BaseProjectOfProjectManager> executeQueryProjectOfProjectManager(ConditionProjectOfProjectManager c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectOfProjectManager dao = new QueryProjectOfProjectManager();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectOfProjectManager> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectOfProjectManager c = new ConditionProjectOfProjectManager();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectOfProjectManager> result = executeQueryProjectOfProjectManager(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectOfProjectManager> result;
		ConditionProjectOfProjectManager c = new ConditionProjectOfProjectManager();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectOfProjectManager dao = new QueryProjectOfProjectManager();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectOfProjectManager.ALL_CAPTIONS);
			for(BaseProjectOfProjectManager b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


