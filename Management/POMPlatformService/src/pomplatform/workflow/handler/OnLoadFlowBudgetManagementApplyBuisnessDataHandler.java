package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadFlowBudgetManagementApplyBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowBudgetManagementApplyBuisnessData;
import pomplatform.workflow.query.QueryOnLoadFlowBudgetManagementApplyBuisnessData;
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

public class OnLoadFlowBudgetManagementApplyBuisnessDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadFlowBudgetManagementApplyBuisnessDataHandler.class);

	public static BaseCollection<BaseOnLoadFlowBudgetManagementApplyBuisnessData> executeQueryOnLoadFlowBudgetManagementApplyBuisnessData(ConditionOnLoadFlowBudgetManagementApplyBuisnessData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadFlowBudgetManagementApplyBuisnessData dao = new QueryOnLoadFlowBudgetManagementApplyBuisnessData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadFlowBudgetManagementApplyBuisnessData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadFlowBudgetManagementApplyBuisnessData c = new ConditionOnLoadFlowBudgetManagementApplyBuisnessData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadFlowBudgetManagementApplyBuisnessData> result = executeQueryOnLoadFlowBudgetManagementApplyBuisnessData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadFlowBudgetManagementApplyBuisnessData> result;
		ConditionOnLoadFlowBudgetManagementApplyBuisnessData c = new ConditionOnLoadFlowBudgetManagementApplyBuisnessData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadFlowBudgetManagementApplyBuisnessData dao = new QueryOnLoadFlowBudgetManagementApplyBuisnessData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadFlowBudgetManagementApplyBuisnessData.ALL_CAPTIONS);
			for(BaseOnLoadFlowBudgetManagementApplyBuisnessData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


