package pomplatform.costallocation.handler;

import org.apache.log4j.Logger;
import pomplatform.costallocation.bean.BaseCostAllocationApply;
import pomplatform.costallocation.bean.ConditionCostAllocationApply;
import pomplatform.costallocation.query.QueryCostAllocationApply;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseCostAllocation;
import com.pomplatform.db.dao.CostAllocation;
import delicacy.common.BaseCollection;

public class CostAllocationApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CostAllocationApplyHandler.class);

	public static BaseCollection<BaseCostAllocationApply> executeQueryCostAllocationApply(ConditionCostAllocationApply c, KeyValuePair[] replacements ) throws Exception {
		QueryCostAllocationApply dao = new QueryCostAllocationApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCostAllocationApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			CostAllocation daoCostAllocation = new CostAllocation();
			for(BaseCostAllocationApply bean : result.getCollections()){
				daoCostAllocation.setConditionResetCostId("=", bean.getResetCostId());
				bean.setDetailCostAllocation(daoCostAllocation.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCostAllocationApply c = new ConditionCostAllocationApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCostAllocationApply> result = executeQueryCostAllocationApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCostAllocationApply> result;
		ConditionCostAllocationApply c = new ConditionCostAllocationApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCostAllocationApply dao = new QueryCostAllocationApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCostAllocationApply.ALL_CAPTIONS);
			for(BaseCostAllocationApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


