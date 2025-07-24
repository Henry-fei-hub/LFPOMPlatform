package pomplatform.managementTeamProject.handler;

import org.apache.log4j.Logger;
import pomplatform.managementTeamProject.bean.BaseMManagementTeamProject;
import pomplatform.managementTeamProject.bean.ConditionMManagementTeamProject;
import pomplatform.managementTeamProject.query.QueryMManagementTeamProject;
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

public class MManagementTeamProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MManagementTeamProjectHandler.class);

	public static BaseCollection<BaseMManagementTeamProject> executeQueryMManagementTeamProject(ConditionMManagementTeamProject c, KeyValuePair[] replacements ) throws Exception {
		QueryMManagementTeamProject dao = new QueryMManagementTeamProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMManagementTeamProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMManagementTeamProject c = new ConditionMManagementTeamProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMManagementTeamProject> result = executeQueryMManagementTeamProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMManagementTeamProject> result;
		ConditionMManagementTeamProject c = new ConditionMManagementTeamProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMManagementTeamProject dao = new QueryMManagementTeamProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseMManagementTeamProject.ALL_CAPTIONS);
			for(BaseMManagementTeamProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


