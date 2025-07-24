package pomplatform.trainingmanagement.handler;

import org.apache.log4j.Logger;
import pomplatform.trainingmanagement.bean.BaseTrainingmanagement;
import pomplatform.trainingmanagement.bean.ConditionTrainingmanagement;
import pomplatform.trainingmanagement.query.QueryTrainingmanagement;
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

public class TrainingmanagementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TrainingmanagementHandler.class);

	public static BaseCollection<BaseTrainingmanagement> executeQueryTrainingmanagement(ConditionTrainingmanagement c, KeyValuePair[] replacements ) throws Exception {
		QueryTrainingmanagement dao = new QueryTrainingmanagement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTrainingmanagement> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTrainingmanagement c = new ConditionTrainingmanagement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTrainingmanagement> result = executeQueryTrainingmanagement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTrainingmanagement> result;
		ConditionTrainingmanagement c = new ConditionTrainingmanagement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTrainingmanagement dao = new QueryTrainingmanagement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTrainingmanagement.ALL_CAPTIONS);
			for(BaseTrainingmanagement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


