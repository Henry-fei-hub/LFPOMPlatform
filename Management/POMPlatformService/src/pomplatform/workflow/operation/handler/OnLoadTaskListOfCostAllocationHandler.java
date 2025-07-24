package pomplatform.workflow.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.operation.bean.BaseOnLoadTaskListOfCostAllocation;
import pomplatform.workflow.operation.bean.ConditionOnLoadTaskListOfCostAllocation;
import pomplatform.workflow.operation.query.QueryOnLoadTaskListOfCostAllocation;
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

public class OnLoadTaskListOfCostAllocationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadTaskListOfCostAllocationHandler.class);

	public static BaseCollection<BaseOnLoadTaskListOfCostAllocation> executeQueryOnLoadTaskListOfCostAllocation(ConditionOnLoadTaskListOfCostAllocation c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadTaskListOfCostAllocation dao = new QueryOnLoadTaskListOfCostAllocation();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadTaskListOfCostAllocation> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadTaskListOfCostAllocation c = new ConditionOnLoadTaskListOfCostAllocation();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadTaskListOfCostAllocation> result = executeQueryOnLoadTaskListOfCostAllocation(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadTaskListOfCostAllocation> result;
		ConditionOnLoadTaskListOfCostAllocation c = new ConditionOnLoadTaskListOfCostAllocation();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadTaskListOfCostAllocation dao = new QueryOnLoadTaskListOfCostAllocation();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadTaskListOfCostAllocation.ALL_CAPTIONS);
			for(BaseOnLoadTaskListOfCostAllocation b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


