package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadFlowEmployeeMoneyApplyBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowEmployeeMoneyApplyBuisnessData;
import pomplatform.workflow.query.QueryOnLoadFlowEmployeeMoneyApplyBuisnessData;
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

public class OnLoadFlowEmployeeMoneyApplyBuisnessDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadFlowEmployeeMoneyApplyBuisnessDataHandler.class);

	public static BaseCollection<BaseOnLoadFlowEmployeeMoneyApplyBuisnessData> executeQueryOnLoadFlowEmployeeMoneyApplyBuisnessData(ConditionOnLoadFlowEmployeeMoneyApplyBuisnessData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadFlowEmployeeMoneyApplyBuisnessData dao = new QueryOnLoadFlowEmployeeMoneyApplyBuisnessData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadFlowEmployeeMoneyApplyBuisnessData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadFlowEmployeeMoneyApplyBuisnessData c = new ConditionOnLoadFlowEmployeeMoneyApplyBuisnessData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadFlowEmployeeMoneyApplyBuisnessData> result = executeQueryOnLoadFlowEmployeeMoneyApplyBuisnessData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadFlowEmployeeMoneyApplyBuisnessData> result;
		ConditionOnLoadFlowEmployeeMoneyApplyBuisnessData c = new ConditionOnLoadFlowEmployeeMoneyApplyBuisnessData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadFlowEmployeeMoneyApplyBuisnessData dao = new QueryOnLoadFlowEmployeeMoneyApplyBuisnessData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadFlowEmployeeMoneyApplyBuisnessData.ALL_CAPTIONS);
			for(BaseOnLoadFlowEmployeeMoneyApplyBuisnessData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


