package pomplatform.alreadyapprovalbudgetmanagementapplywork.handler;

import org.apache.log4j.Logger;
import pomplatform.alreadyapprovalbudgetmanagementapplywork.bean.BaseAlreadyApprovalBudgetManagementApplyWork;
import pomplatform.alreadyapprovalbudgetmanagementapplywork.bean.ConditionAlreadyApprovalBudgetManagementApplyWork;
import pomplatform.alreadyapprovalbudgetmanagementapplywork.query.QueryAlreadyApprovalBudgetManagementApplyWork;
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

public class AlreadyApprovalBudgetManagementApplyWorkHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AlreadyApprovalBudgetManagementApplyWorkHandler.class);

	public static BaseCollection<BaseAlreadyApprovalBudgetManagementApplyWork> executeQueryAlreadyApprovalBudgetManagementApplyWork(ConditionAlreadyApprovalBudgetManagementApplyWork c, KeyValuePair[] replacements ) throws Exception {
		QueryAlreadyApprovalBudgetManagementApplyWork dao = new QueryAlreadyApprovalBudgetManagementApplyWork();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAlreadyApprovalBudgetManagementApplyWork> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAlreadyApprovalBudgetManagementApplyWork c = new ConditionAlreadyApprovalBudgetManagementApplyWork();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAlreadyApprovalBudgetManagementApplyWork> result = executeQueryAlreadyApprovalBudgetManagementApplyWork(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAlreadyApprovalBudgetManagementApplyWork> result;
		ConditionAlreadyApprovalBudgetManagementApplyWork c = new ConditionAlreadyApprovalBudgetManagementApplyWork();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAlreadyApprovalBudgetManagementApplyWork dao = new QueryAlreadyApprovalBudgetManagementApplyWork();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAlreadyApprovalBudgetManagementApplyWork.ALL_CAPTIONS);
			for(BaseAlreadyApprovalBudgetManagementApplyWork b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


