package pomplatform.workflow.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.operation.bean.BaseOnLoadAuditListOfCostAllocation;
import pomplatform.workflow.operation.bean.ConditionOnLoadAuditListOfCostAllocation;
import pomplatform.workflow.operation.query.QueryOnLoadAuditListOfCostAllocation;
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

public class OnLoadAuditListOfCostAllocationHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfCostAllocationHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfCostAllocation> executeQueryOnLoadAuditListOfCostAllocation(ConditionOnLoadAuditListOfCostAllocation c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfCostAllocation dao = new QueryOnLoadAuditListOfCostAllocation();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfCostAllocation> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfCostAllocation c = new ConditionOnLoadAuditListOfCostAllocation();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfCostAllocation> result = executeQueryOnLoadAuditListOfCostAllocation(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfCostAllocation> result;
		ConditionOnLoadAuditListOfCostAllocation c = new ConditionOnLoadAuditListOfCostAllocation();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfCostAllocation dao = new QueryOnLoadAuditListOfCostAllocation();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfCostAllocation.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfCostAllocation b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


