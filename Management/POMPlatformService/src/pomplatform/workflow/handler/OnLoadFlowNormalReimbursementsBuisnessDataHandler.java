package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadFlowNormalReimbursementsBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowNormalReimbursementsBuisnessData;
import pomplatform.workflow.query.QueryOnLoadFlowNormalReimbursementsBuisnessData;
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

public class OnLoadFlowNormalReimbursementsBuisnessDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadFlowNormalReimbursementsBuisnessDataHandler.class);

	public static BaseCollection<BaseOnLoadFlowNormalReimbursementsBuisnessData> executeQueryOnLoadFlowNormalReimbursementsBuisnessData(ConditionOnLoadFlowNormalReimbursementsBuisnessData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadFlowNormalReimbursementsBuisnessData dao = new QueryOnLoadFlowNormalReimbursementsBuisnessData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadFlowNormalReimbursementsBuisnessData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadFlowNormalReimbursementsBuisnessData c = new ConditionOnLoadFlowNormalReimbursementsBuisnessData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadFlowNormalReimbursementsBuisnessData> result = executeQueryOnLoadFlowNormalReimbursementsBuisnessData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadFlowNormalReimbursementsBuisnessData> result;
		ConditionOnLoadFlowNormalReimbursementsBuisnessData c = new ConditionOnLoadFlowNormalReimbursementsBuisnessData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadFlowNormalReimbursementsBuisnessData dao = new QueryOnLoadFlowNormalReimbursementsBuisnessData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadFlowNormalReimbursementsBuisnessData.ALL_CAPTIONS);
			for(BaseOnLoadFlowNormalReimbursementsBuisnessData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


