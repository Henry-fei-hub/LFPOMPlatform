package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadFlowAuditOfEmployeeOnboardBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowAuditOfEmployeeOnboardBuisnessData;
import pomplatform.workflow.query.QueryOnLoadFlowAuditOfEmployeeOnboardBuisnessData;
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

public class OnLoadFlowAuditOfEmployeeOnboardBuisnessDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadFlowAuditOfEmployeeOnboardBuisnessDataHandler.class);

	public static BaseCollection<BaseOnLoadFlowAuditOfEmployeeOnboardBuisnessData> executeQueryOnLoadFlowAuditOfEmployeeOnboardBuisnessData(ConditionOnLoadFlowAuditOfEmployeeOnboardBuisnessData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadFlowAuditOfEmployeeOnboardBuisnessData dao = new QueryOnLoadFlowAuditOfEmployeeOnboardBuisnessData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadFlowAuditOfEmployeeOnboardBuisnessData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadFlowAuditOfEmployeeOnboardBuisnessData c = new ConditionOnLoadFlowAuditOfEmployeeOnboardBuisnessData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadFlowAuditOfEmployeeOnboardBuisnessData> result = executeQueryOnLoadFlowAuditOfEmployeeOnboardBuisnessData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadFlowAuditOfEmployeeOnboardBuisnessData> result;
		ConditionOnLoadFlowAuditOfEmployeeOnboardBuisnessData c = new ConditionOnLoadFlowAuditOfEmployeeOnboardBuisnessData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadFlowAuditOfEmployeeOnboardBuisnessData dao = new QueryOnLoadFlowAuditOfEmployeeOnboardBuisnessData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadFlowAuditOfEmployeeOnboardBuisnessData.ALL_CAPTIONS);
			for(BaseOnLoadFlowAuditOfEmployeeOnboardBuisnessData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


