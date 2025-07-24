package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseEmployeeMoneyApplyOfWorkflow;
import pomplatform.workflow.bean.ConditionEmployeeMoneyApplyOfWorkflow;
import pomplatform.workflow.query.QueryEmployeeMoneyApplyOfWorkflow;
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

public class EmployeeMoneyApplyOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeMoneyApplyOfWorkflowHandler.class);

	public static BaseCollection<BaseEmployeeMoneyApplyOfWorkflow> executeQueryEmployeeMoneyApplyOfWorkflow(ConditionEmployeeMoneyApplyOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryEmployeeMoneyApplyOfWorkflow dao = new QueryEmployeeMoneyApplyOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeMoneyApplyOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionEmployeeMoneyApplyOfWorkflow c = new ConditionEmployeeMoneyApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseEmployeeMoneyApplyOfWorkflow> result = executeQueryEmployeeMoneyApplyOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseEmployeeMoneyApplyOfWorkflow> result;
		ConditionEmployeeMoneyApplyOfWorkflow c = new ConditionEmployeeMoneyApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryEmployeeMoneyApplyOfWorkflow dao = new QueryEmployeeMoneyApplyOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeMoneyApplyOfWorkflow.ALL_CAPTIONS);
			for(BaseEmployeeMoneyApplyOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


