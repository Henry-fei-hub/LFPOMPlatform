package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnLoadFlowTravelReimbursementsApplyBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowTravelReimbursementsApplyBuisnessData;
import pomplatform.workflow.query.QueryOnLoadFlowTravelReimbursementsApplyBuisnessData;
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

public class OnLoadFlowTravelReimbursementsApplyBuisnessDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadFlowTravelReimbursementsApplyBuisnessDataHandler.class);

	public static BaseCollection<BaseOnLoadFlowTravelReimbursementsApplyBuisnessData> executeQueryOnLoadFlowTravelReimbursementsApplyBuisnessData(ConditionOnLoadFlowTravelReimbursementsApplyBuisnessData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadFlowTravelReimbursementsApplyBuisnessData dao = new QueryOnLoadFlowTravelReimbursementsApplyBuisnessData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadFlowTravelReimbursementsApplyBuisnessData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadFlowTravelReimbursementsApplyBuisnessData c = new ConditionOnLoadFlowTravelReimbursementsApplyBuisnessData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadFlowTravelReimbursementsApplyBuisnessData> result = executeQueryOnLoadFlowTravelReimbursementsApplyBuisnessData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadFlowTravelReimbursementsApplyBuisnessData> result;
		ConditionOnLoadFlowTravelReimbursementsApplyBuisnessData c = new ConditionOnLoadFlowTravelReimbursementsApplyBuisnessData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadFlowTravelReimbursementsApplyBuisnessData dao = new QueryOnLoadFlowTravelReimbursementsApplyBuisnessData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadFlowTravelReimbursementsApplyBuisnessData.ALL_CAPTIONS);
			for(BaseOnLoadFlowTravelReimbursementsApplyBuisnessData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


