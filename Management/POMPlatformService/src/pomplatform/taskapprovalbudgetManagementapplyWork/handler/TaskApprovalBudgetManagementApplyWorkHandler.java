package pomplatform.taskapprovalbudgetManagementapplyWork.handler;

import org.apache.log4j.Logger;
import pomplatform.taskapprovalbudgetManagementapplyWork.bean.BaseTaskApprovalBudgetManagementApplyWork;
import pomplatform.taskapprovalbudgetManagementapplyWork.bean.ConditionTaskApprovalBudgetManagementApplyWork;
import pomplatform.taskapprovalbudgetManagementapplyWork.query.QueryTaskApprovalBudgetManagementApplyWork;
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

public class TaskApprovalBudgetManagementApplyWorkHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TaskApprovalBudgetManagementApplyWorkHandler.class);

	public static BaseCollection<BaseTaskApprovalBudgetManagementApplyWork> executeQueryTaskApprovalBudgetManagementApplyWork(ConditionTaskApprovalBudgetManagementApplyWork c, KeyValuePair[] replacements ) throws Exception {
		QueryTaskApprovalBudgetManagementApplyWork dao = new QueryTaskApprovalBudgetManagementApplyWork();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTaskApprovalBudgetManagementApplyWork> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTaskApprovalBudgetManagementApplyWork c = new ConditionTaskApprovalBudgetManagementApplyWork();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTaskApprovalBudgetManagementApplyWork> result = executeQueryTaskApprovalBudgetManagementApplyWork(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTaskApprovalBudgetManagementApplyWork> result;
		ConditionTaskApprovalBudgetManagementApplyWork c = new ConditionTaskApprovalBudgetManagementApplyWork();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTaskApprovalBudgetManagementApplyWork dao = new QueryTaskApprovalBudgetManagementApplyWork();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTaskApprovalBudgetManagementApplyWork.ALL_CAPTIONS);
			for(BaseTaskApprovalBudgetManagementApplyWork b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


