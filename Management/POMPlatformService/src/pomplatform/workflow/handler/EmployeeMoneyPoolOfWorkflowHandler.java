package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseEmployeeMoneyPoolOfWorkflow;
import pomplatform.workflow.bean.ConditionEmployeeMoneyPoolOfWorkflow;
import pomplatform.workflow.query.QueryEmployeeMoneyPoolOfWorkflow;
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

public class EmployeeMoneyPoolOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeMoneyPoolOfWorkflowHandler.class);

	public static BaseCollection<BaseEmployeeMoneyPoolOfWorkflow> executeQueryEmployeeMoneyPoolOfWorkflow(ConditionEmployeeMoneyPoolOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeMoneyPoolOfWorkflow dao = new QueryEmployeeMoneyPoolOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeMoneyPoolOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeMoneyPoolOfWorkflow c = new ConditionEmployeeMoneyPoolOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeMoneyPoolOfWorkflow> result = executeQueryEmployeeMoneyPoolOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeMoneyPoolOfWorkflow> result;
		ConditionEmployeeMoneyPoolOfWorkflow c = new ConditionEmployeeMoneyPoolOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeMoneyPoolOfWorkflow dao = new QueryEmployeeMoneyPoolOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeMoneyPoolOfWorkflow.ALL_CAPTIONS);
			for(BaseEmployeeMoneyPoolOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


