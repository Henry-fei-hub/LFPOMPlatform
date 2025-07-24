package pomplatform.workflow.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.operation.bean.BaseOnLoadRefuseListOfCostAllocation;
import pomplatform.workflow.operation.bean.ConditionOnLoadRefuseListOfCostAllocation;
import pomplatform.workflow.operation.query.QueryOnLoadRefuseListOfCostAllocation;
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

public class OnLoadRefuseListOfCostAllocationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadRefuseListOfCostAllocationHandler.class);

	public static BaseCollection<BaseOnLoadRefuseListOfCostAllocation> executeQueryOnLoadRefuseListOfCostAllocation(ConditionOnLoadRefuseListOfCostAllocation c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadRefuseListOfCostAllocation dao = new QueryOnLoadRefuseListOfCostAllocation();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadRefuseListOfCostAllocation> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadRefuseListOfCostAllocation c = new ConditionOnLoadRefuseListOfCostAllocation();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadRefuseListOfCostAllocation> result = executeQueryOnLoadRefuseListOfCostAllocation(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadRefuseListOfCostAllocation> result;
		ConditionOnLoadRefuseListOfCostAllocation c = new ConditionOnLoadRefuseListOfCostAllocation();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadRefuseListOfCostAllocation dao = new QueryOnLoadRefuseListOfCostAllocation();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadRefuseListOfCostAllocation.ALL_CAPTIONS);
			for(BaseOnLoadRefuseListOfCostAllocation b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


