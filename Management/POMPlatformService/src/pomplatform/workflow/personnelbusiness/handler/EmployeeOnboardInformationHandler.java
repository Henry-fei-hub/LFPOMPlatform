package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeOnboardInformation;
import pomplatform.workflow.personnelbusiness.bean.ConditionEmployeeOnboardInformation;
import pomplatform.workflow.personnelbusiness.query.QueryEmployeeOnboardInformation;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseEmployeeEducationInformation;
import com.pomplatform.db.dao.EmployeeEducationInformation;
import com.pomplatform.db.bean.BaseEmployeeFamilyInformation;
import com.pomplatform.db.dao.EmployeeFamilyInformation;
import com.pomplatform.db.bean.BaseEmployeeRewardExperience;
import com.pomplatform.db.dao.EmployeeRewardExperience;
import com.pomplatform.db.bean.BaseEmployeeWorkExperience;
import com.pomplatform.db.dao.EmployeeWorkExperience;
import com.pomplatform.db.bean.BaseEmployeeTechnicalTitle;
import com.pomplatform.db.dao.EmployeeTechnicalTitle;
import delicacy.common.BaseCollection;

public class EmployeeOnboardInformationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeOnboardInformationHandler.class);

	public static BaseCollection<BaseEmployeeOnboardInformation> executeQueryEmployeeOnboardInformation(ConditionEmployeeOnboardInformation c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeOnboardInformation dao = new QueryEmployeeOnboardInformation();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeOnboardInformation> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			EmployeeEducationInformation daoEmployeeEducationInformation = new EmployeeEducationInformation();
			EmployeeFamilyInformation daoEmployeeFamilyInformation = new EmployeeFamilyInformation();
			EmployeeRewardExperience daoEmployeeRewardExperience = new EmployeeRewardExperience();
			EmployeeWorkExperience daoEmployeeWorkExperience = new EmployeeWorkExperience();
			EmployeeTechnicalTitle daoEmployeeTechnicalTitle = new EmployeeTechnicalTitle();
			for(BaseEmployeeOnboardInformation bean : result.getCollections()){
				daoEmployeeEducationInformation.setConditionEmployeeId("=", bean.getEmployeeId());
				bean.setDetailEmployeeEducationInformation(daoEmployeeEducationInformation.conditionalLoad(null));
				daoEmployeeFamilyInformation.setConditionEmployeeId("=", bean.getEmployeeId());
				bean.setDetailEmployeeFamilyInformation(daoEmployeeFamilyInformation.conditionalLoad(null));
				daoEmployeeRewardExperience.setConditionEmployeeId("=", bean.getEmployeeId());
				bean.setDetailEmployeeRewardExperience(daoEmployeeRewardExperience.conditionalLoad(null));
				daoEmployeeWorkExperience.setConditionEmployeeId("=", bean.getEmployeeId());
				bean.setDetailEmployeeWorkExperience(daoEmployeeWorkExperience.conditionalLoad(null));
				daoEmployeeTechnicalTitle.setConditionEmployeeId("=", bean.getEmployeeId());
				bean.setDetailEmployeeTechnicalTitle(daoEmployeeTechnicalTitle.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeOnboardInformation c = new ConditionEmployeeOnboardInformation();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeOnboardInformation> result = executeQueryEmployeeOnboardInformation(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeOnboardInformation> result;
		ConditionEmployeeOnboardInformation c = new ConditionEmployeeOnboardInformation();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeOnboardInformation dao = new QueryEmployeeOnboardInformation();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeOnboardInformation.ALL_CAPTIONS);
			for(BaseEmployeeOnboardInformation b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


