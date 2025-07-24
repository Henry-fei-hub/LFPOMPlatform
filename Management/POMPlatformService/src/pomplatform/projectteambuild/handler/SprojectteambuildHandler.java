package pomplatform.projectteambuild.handler;

import org.apache.log4j.Logger;
import pomplatform.projectteambuild.bean.BaseSprojectteambuild;
import pomplatform.projectteambuild.bean.ConditionSprojectteambuild;
import pomplatform.projectteambuild.query.QuerySprojectteambuild;
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
import delicacy.common.BaseCollection;

public class SprojectteambuildHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SprojectteambuildHandler.class);

	public static BaseCollection<BaseSprojectteambuild> executeQuerySprojectteambuild(ConditionSprojectteambuild c, KeyValuePair[] replacements ) throws Exception {
		QuerySprojectteambuild dao = new QuerySprojectteambuild();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSprojectteambuild> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProjectEmployee daoProjectEmployee = new ProjectEmployee();
			for(BaseSprojectteambuild bean : result.getCollections()){
				daoProjectEmployee.setConditionProjectId("=", bean.getProjectId());
				bean.setDetailProjectEmployee(daoProjectEmployee.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSprojectteambuild c = new ConditionSprojectteambuild();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSprojectteambuild> result = executeQuerySprojectteambuild(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSprojectteambuild> result;
		ConditionSprojectteambuild c = new ConditionSprojectteambuild();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySprojectteambuild dao = new QuerySprojectteambuild();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "UTF-8")){
			ps.println(BaseSprojectteambuild.ALL_CAPTIONS);
			for(BaseSprojectteambuild b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


