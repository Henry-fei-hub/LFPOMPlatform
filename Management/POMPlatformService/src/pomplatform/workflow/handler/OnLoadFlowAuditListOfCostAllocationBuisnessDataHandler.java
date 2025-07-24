package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadFlowAuditListOfCostAllocationBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowAuditListOfCostAllocationBuisnessData;
import pomplatform.workflow.query.QueryOnLoadFlowAuditListOfCostAllocationBuisnessData;
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

public class OnLoadFlowAuditListOfCostAllocationBuisnessDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadFlowAuditListOfCostAllocationBuisnessDataHandler.class);

	public static BaseCollection<BaseOnLoadFlowAuditListOfCostAllocationBuisnessData> executeQueryOnLoadFlowAuditListOfCostAllocationBuisnessData(ConditionOnLoadFlowAuditListOfCostAllocationBuisnessData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadFlowAuditListOfCostAllocationBuisnessData dao = new QueryOnLoadFlowAuditListOfCostAllocationBuisnessData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadFlowAuditListOfCostAllocationBuisnessData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadFlowAuditListOfCostAllocationBuisnessData c = new ConditionOnLoadFlowAuditListOfCostAllocationBuisnessData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadFlowAuditListOfCostAllocationBuisnessData> result = executeQueryOnLoadFlowAuditListOfCostAllocationBuisnessData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadFlowAuditListOfCostAllocationBuisnessData> result;
		ConditionOnLoadFlowAuditListOfCostAllocationBuisnessData c = new ConditionOnLoadFlowAuditListOfCostAllocationBuisnessData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadFlowAuditListOfCostAllocationBuisnessData dao = new QueryOnLoadFlowAuditListOfCostAllocationBuisnessData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadFlowAuditListOfCostAllocationBuisnessData.ALL_CAPTIONS);
			for(BaseOnLoadFlowAuditListOfCostAllocationBuisnessData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


