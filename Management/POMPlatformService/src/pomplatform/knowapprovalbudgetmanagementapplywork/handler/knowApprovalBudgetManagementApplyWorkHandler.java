package pomplatform.knowapprovalbudgetmanagementapplywork.handler;

import org.apache.log4j.Logger;
import pomplatform.knowapprovalbudgetmanagementapplywork.bean.BaseknowApprovalBudgetManagementApplyWork;
import pomplatform.knowapprovalbudgetmanagementapplywork.bean.ConditionknowApprovalBudgetManagementApplyWork;
import pomplatform.knowapprovalbudgetmanagementapplywork.query.QueryknowApprovalBudgetManagementApplyWork;
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

public class knowApprovalBudgetManagementApplyWorkHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(knowApprovalBudgetManagementApplyWorkHandler.class);

	public static BaseCollection<BaseknowApprovalBudgetManagementApplyWork> executeQueryknowApprovalBudgetManagementApplyWork(ConditionknowApprovalBudgetManagementApplyWork c, KeyValuePair[] replacements ) throws Exception {
		QueryknowApprovalBudgetManagementApplyWork dao = new QueryknowApprovalBudgetManagementApplyWork();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseknowApprovalBudgetManagementApplyWork> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionknowApprovalBudgetManagementApplyWork c = new ConditionknowApprovalBudgetManagementApplyWork();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseknowApprovalBudgetManagementApplyWork> result = executeQueryknowApprovalBudgetManagementApplyWork(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseknowApprovalBudgetManagementApplyWork> result;
		ConditionknowApprovalBudgetManagementApplyWork c = new ConditionknowApprovalBudgetManagementApplyWork();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryknowApprovalBudgetManagementApplyWork dao = new QueryknowApprovalBudgetManagementApplyWork();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseknowApprovalBudgetManagementApplyWork.ALL_CAPTIONS);
			for(BaseknowApprovalBudgetManagementApplyWork b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


