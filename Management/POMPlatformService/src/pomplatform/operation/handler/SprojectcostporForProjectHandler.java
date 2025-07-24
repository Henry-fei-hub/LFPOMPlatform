package pomplatform.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.operation.bean.BaseSprojectcostporForProject;
import pomplatform.operation.bean.ConditionSprojectcostporForProject;
import pomplatform.operation.query.QuerySprojectcostporForProject;
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

public class SprojectcostporForProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectcostporForProjectHandler.class);

	public static BaseCollection<BaseSprojectcostporForProject> executeQuerySprojectcostporForProject(ConditionSprojectcostporForProject c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectcostporForProject dao = new QuerySprojectcostporForProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectcostporForProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectcostporForProject c = new ConditionSprojectcostporForProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectcostporForProject> result = executeQuerySprojectcostporForProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectcostporForProject> result;
		ConditionSprojectcostporForProject c = new ConditionSprojectcostporForProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectcostporForProject dao = new QuerySprojectcostporForProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSprojectcostporForProject.ALL_CAPTIONS);
			for(BaseSprojectcostporForProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


