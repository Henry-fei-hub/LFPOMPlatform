package pomplatform.ManageProjectByProject.handler;

import org.apache.log4j.Logger;
import pomplatform.ManageProjectByProject.bean.BaseManageProjectByProject;
import pomplatform.ManageProjectByProject.bean.ConditionManageProjectByProject;
import pomplatform.ManageProjectByProject.query.QueryManageProjectByProject;
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

public class ManageProjectByProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ManageProjectByProjectHandler.class);

	public static BaseCollection<BaseManageProjectByProject> executeQueryManageProjectByProject(ConditionManageProjectByProject c, KeyValuePair[] replacements ) throws Exception {
		QueryManageProjectByProject dao = new QueryManageProjectByProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseManageProjectByProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionManageProjectByProject c = new ConditionManageProjectByProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseManageProjectByProject> result = executeQueryManageProjectByProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseManageProjectByProject> result;
		ConditionManageProjectByProject c = new ConditionManageProjectByProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryManageProjectByProject dao = new QueryManageProjectByProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseManageProjectByProject.ALL_CAPTIONS);
			for(BaseManageProjectByProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


