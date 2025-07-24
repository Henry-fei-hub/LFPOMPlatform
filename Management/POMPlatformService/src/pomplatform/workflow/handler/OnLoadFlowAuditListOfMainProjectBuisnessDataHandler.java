package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadFlowAuditListOfMainProjectBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowAuditListOfMainProjectBuisnessData;
import pomplatform.workflow.query.QueryOnLoadFlowAuditListOfMainProjectBuisnessData;
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

public class OnLoadFlowAuditListOfMainProjectBuisnessDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadFlowAuditListOfMainProjectBuisnessDataHandler.class);

	public static BaseCollection<BaseOnLoadFlowAuditListOfMainProjectBuisnessData> executeQueryOnLoadFlowAuditListOfMainProjectBuisnessData(ConditionOnLoadFlowAuditListOfMainProjectBuisnessData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadFlowAuditListOfMainProjectBuisnessData dao = new QueryOnLoadFlowAuditListOfMainProjectBuisnessData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadFlowAuditListOfMainProjectBuisnessData> result = dao.runQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadFlowAuditListOfMainProjectBuisnessData c = new ConditionOnLoadFlowAuditListOfMainProjectBuisnessData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadFlowAuditListOfMainProjectBuisnessData> result = executeQueryOnLoadFlowAuditListOfMainProjectBuisnessData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadFlowAuditListOfMainProjectBuisnessData> result;
		ConditionOnLoadFlowAuditListOfMainProjectBuisnessData c = new ConditionOnLoadFlowAuditListOfMainProjectBuisnessData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadFlowAuditListOfMainProjectBuisnessData dao = new QueryOnLoadFlowAuditListOfMainProjectBuisnessData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadFlowAuditListOfMainProjectBuisnessData.ALL_CAPTIONS);
			for(BaseOnLoadFlowAuditListOfMainProjectBuisnessData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


