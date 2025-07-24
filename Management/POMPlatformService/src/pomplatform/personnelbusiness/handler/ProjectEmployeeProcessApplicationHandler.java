package pomplatform.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.personnelbusiness.bean.BaseProjectEmployeeProcessApplication;
import pomplatform.personnelbusiness.bean.ConditionProjectEmployeeProcessApplication;
import pomplatform.personnelbusiness.query.QueryProjectEmployeeProcessApplication;
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

public class ProjectEmployeeProcessApplicationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectEmployeeProcessApplicationHandler.class);

	public static BaseCollection<BaseProjectEmployeeProcessApplication> executeQueryProjectEmployeeProcessApplication(ConditionProjectEmployeeProcessApplication c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectEmployeeProcessApplication dao = new QueryProjectEmployeeProcessApplication();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectEmployeeProcessApplication> result = dao.execute( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProjectEmployee daoProjectEmployee = new ProjectEmployee();
			for(BaseProjectEmployeeProcessApplication bean : result.getCollections()){
				daoProjectEmployee.setConditionBusinessId("=", bean.getPersonnelBusinessId());
				bean.setDetailProjectEmployee(daoProjectEmployee.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectEmployeeProcessApplication c = new ConditionProjectEmployeeProcessApplication();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectEmployeeProcessApplication> result = executeQueryProjectEmployeeProcessApplication(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectEmployeeProcessApplication> result;
		ConditionProjectEmployeeProcessApplication c = new ConditionProjectEmployeeProcessApplication();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectEmployeeProcessApplication dao = new QueryProjectEmployeeProcessApplication();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectEmployeeProcessApplication.ALL_CAPTIONS);
			for(BaseProjectEmployeeProcessApplication b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


