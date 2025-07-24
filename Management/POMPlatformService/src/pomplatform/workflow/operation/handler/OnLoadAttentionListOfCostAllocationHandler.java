package pomplatform.workflow.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.operation.bean.BaseOnLoadAttentionListOfCostAllocation;
import pomplatform.workflow.operation.bean.ConditionOnLoadAttentionListOfCostAllocation;
import pomplatform.workflow.operation.query.QueryOnLoadAttentionListOfCostAllocation;
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

public class OnLoadAttentionListOfCostAllocationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttentionListOfCostAllocationHandler.class);

	public static BaseCollection<BaseOnLoadAttentionListOfCostAllocation> executeQueryOnLoadAttentionListOfCostAllocation(ConditionOnLoadAttentionListOfCostAllocation c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttentionListOfCostAllocation dao = new QueryOnLoadAttentionListOfCostAllocation();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttentionListOfCostAllocation> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttentionListOfCostAllocation c = new ConditionOnLoadAttentionListOfCostAllocation();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttentionListOfCostAllocation> result = executeQueryOnLoadAttentionListOfCostAllocation(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttentionListOfCostAllocation> result;
		ConditionOnLoadAttentionListOfCostAllocation c = new ConditionOnLoadAttentionListOfCostAllocation();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttentionListOfCostAllocation dao = new QueryOnLoadAttentionListOfCostAllocation();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttentionListOfCostAllocation.ALL_CAPTIONS);
			for(BaseOnLoadAttentionListOfCostAllocation b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


