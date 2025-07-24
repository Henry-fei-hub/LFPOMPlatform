package pomplatform.trainingmanagement.handler;

import org.apache.log4j.Logger;
import pomplatform.trainingmanagement.bean.BasetrainingManagementsApplyOfWorkflow;
import pomplatform.trainingmanagement.bean.ConditiontrainingManagementsApplyOfWorkflow;
import pomplatform.trainingmanagement.query.QuerytrainingManagementsApplyOfWorkflow;
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

public class trainingManagementsApplyOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(trainingManagementsApplyOfWorkflowHandler.class);

	public static BaseCollection<BasetrainingManagementsApplyOfWorkflow> executeQuerytrainingManagementsApplyOfWorkflow(ConditiontrainingManagementsApplyOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QuerytrainingManagementsApplyOfWorkflow dao = new QuerytrainingManagementsApplyOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasetrainingManagementsApplyOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditiontrainingManagementsApplyOfWorkflow c = new ConditiontrainingManagementsApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BasetrainingManagementsApplyOfWorkflow> result = executeQuerytrainingManagementsApplyOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasetrainingManagementsApplyOfWorkflow> result;
		ConditiontrainingManagementsApplyOfWorkflow c = new ConditiontrainingManagementsApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerytrainingManagementsApplyOfWorkflow dao = new QuerytrainingManagementsApplyOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasetrainingManagementsApplyOfWorkflow.ALL_CAPTIONS);
			for(BasetrainingManagementsApplyOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


