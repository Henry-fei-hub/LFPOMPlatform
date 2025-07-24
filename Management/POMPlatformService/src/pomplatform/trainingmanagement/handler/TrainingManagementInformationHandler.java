package pomplatform.trainingmanagement.handler;

import org.apache.log4j.Logger;
import pomplatform.trainingmanagement.bean.BaseTrainingManagementInformation;
import pomplatform.trainingmanagement.bean.ConditionTrainingManagementInformation;
import pomplatform.trainingmanagement.query.QueryTrainingManagementInformation;
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

public class TrainingManagementInformationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TrainingManagementInformationHandler.class);

	public static BaseCollection<BaseTrainingManagementInformation> executeQueryTrainingManagementInformation(ConditionTrainingManagementInformation c, KeyValuePair[] replacements ) throws Exception {
		QueryTrainingManagementInformation dao = new QueryTrainingManagementInformation();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTrainingManagementInformation> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTrainingManagementInformation c = new ConditionTrainingManagementInformation();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTrainingManagementInformation> result = executeQueryTrainingManagementInformation(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTrainingManagementInformation> result;
		ConditionTrainingManagementInformation c = new ConditionTrainingManagementInformation();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTrainingManagementInformation dao = new QueryTrainingManagementInformation();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTrainingManagementInformation.ALL_CAPTIONS);
			for(BaseTrainingManagementInformation b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


