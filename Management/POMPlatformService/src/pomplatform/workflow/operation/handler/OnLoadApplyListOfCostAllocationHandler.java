package pomplatform.workflow.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.operation.bean.BaseOnLoadApplyListOfCostAllocation;
import pomplatform.workflow.operation.bean.ConditionOnLoadApplyListOfCostAllocation;
import pomplatform.workflow.operation.query.QueryOnLoadApplyListOfCostAllocation;
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

public class OnLoadApplyListOfCostAllocationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfCostAllocationHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfCostAllocation> executeQueryOnLoadApplyListOfCostAllocation(ConditionOnLoadApplyListOfCostAllocation c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfCostAllocation dao = new QueryOnLoadApplyListOfCostAllocation();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfCostAllocation> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfCostAllocation c = new ConditionOnLoadApplyListOfCostAllocation();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfCostAllocation> result = executeQueryOnLoadApplyListOfCostAllocation(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfCostAllocation> result;
		ConditionOnLoadApplyListOfCostAllocation c = new ConditionOnLoadApplyListOfCostAllocation();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfCostAllocation dao = new QueryOnLoadApplyListOfCostAllocation();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfCostAllocation.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfCostAllocation b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


