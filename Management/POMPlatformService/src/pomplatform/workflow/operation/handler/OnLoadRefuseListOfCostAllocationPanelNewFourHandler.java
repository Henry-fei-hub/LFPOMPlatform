package pomplatform.workflow.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.operation.bean.BaseOnLoadRefuseListOfCostAllocationPanelNewFour;
import pomplatform.workflow.operation.bean.ConditionOnLoadRefuseListOfCostAllocationPanelNewFour;
import pomplatform.workflow.operation.query.QueryOnLoadRefuseListOfCostAllocationPanelNewFour;
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

public class OnLoadRefuseListOfCostAllocationPanelNewFourHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadRefuseListOfCostAllocationPanelNewFourHandler.class);

	public static BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewFour> executeQueryOnLoadRefuseListOfCostAllocationPanelNewFour(ConditionOnLoadRefuseListOfCostAllocationPanelNewFour c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadRefuseListOfCostAllocationPanelNewFour dao = new QueryOnLoadRefuseListOfCostAllocationPanelNewFour();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewFour> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadRefuseListOfCostAllocationPanelNewFour c = new ConditionOnLoadRefuseListOfCostAllocationPanelNewFour();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewFour> result = executeQueryOnLoadRefuseListOfCostAllocationPanelNewFour(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewFour> result;
		ConditionOnLoadRefuseListOfCostAllocationPanelNewFour c = new ConditionOnLoadRefuseListOfCostAllocationPanelNewFour();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadRefuseListOfCostAllocationPanelNewFour dao = new QueryOnLoadRefuseListOfCostAllocationPanelNewFour();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadRefuseListOfCostAllocationPanelNewFour.ALL_CAPTIONS);
			for(BaseOnLoadRefuseListOfCostAllocationPanelNewFour b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


