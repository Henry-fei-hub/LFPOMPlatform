package pomplatform.workflow.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.operation.bean.BaseOnLoadRefuseListOfCostAllocationPanelNewTwo;
import pomplatform.workflow.operation.bean.ConditionOnLoadRefuseListOfCostAllocationPanelNewTwo;
import pomplatform.workflow.operation.query.QueryOnLoadRefuseListOfCostAllocationPanelNewTwo;
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

public class OnLoadRefuseListOfCostAllocationPanelNewTwoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadRefuseListOfCostAllocationPanelNewTwoHandler.class);

	public static BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewTwo> executeQueryOnLoadRefuseListOfCostAllocationPanelNewTwo(ConditionOnLoadRefuseListOfCostAllocationPanelNewTwo c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadRefuseListOfCostAllocationPanelNewTwo dao = new QueryOnLoadRefuseListOfCostAllocationPanelNewTwo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewTwo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadRefuseListOfCostAllocationPanelNewTwo c = new ConditionOnLoadRefuseListOfCostAllocationPanelNewTwo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewTwo> result = executeQueryOnLoadRefuseListOfCostAllocationPanelNewTwo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadRefuseListOfCostAllocationPanelNewTwo> result;
		ConditionOnLoadRefuseListOfCostAllocationPanelNewTwo c = new ConditionOnLoadRefuseListOfCostAllocationPanelNewTwo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadRefuseListOfCostAllocationPanelNewTwo dao = new QueryOnLoadRefuseListOfCostAllocationPanelNewTwo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadRefuseListOfCostAllocationPanelNewTwo.ALL_CAPTIONS);
			for(BaseOnLoadRefuseListOfCostAllocationPanelNewTwo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


