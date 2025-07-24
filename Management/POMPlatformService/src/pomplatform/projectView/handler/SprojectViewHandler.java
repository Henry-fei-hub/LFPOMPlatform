package pomplatform.projectView.handler;

import org.apache.log4j.Logger;
import pomplatform.projectView.bean.BaseSprojectView;
import pomplatform.projectView.bean.ConditionSprojectView;
import pomplatform.projectView.query.QuerySprojectView;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.dao.ProjectCost;
import delicacy.common.BaseCollection;

public class SprojectViewHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectViewHandler.class);

	public static BaseCollection<BaseSprojectView> executeQuerySprojectView(ConditionSprojectView c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectView dao = new QuerySprojectView();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectView> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProjectEmployee daoProjectEmployee = new ProjectEmployee();
			ProjectCost daoProjectCost = new ProjectCost();
			for(BaseSprojectView bean : result.getCollections()){
				daoProjectEmployee.setConditionProjectId("=", bean.getProjectId());
				bean.setDetailProjectEmployee(daoProjectEmployee.conditionalLoad(null));
				daoProjectCost.setConditionProjectId("=", bean.getProjectId());
				bean.setDetailProjectCost(daoProjectCost.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectView c = new ConditionSprojectView();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectView> result = executeQuerySprojectView(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectView> result;
		ConditionSprojectView c = new ConditionSprojectView();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectView dao = new QuerySprojectView();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSprojectView.ALL_CAPTIONS);
			for(BaseSprojectView b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


