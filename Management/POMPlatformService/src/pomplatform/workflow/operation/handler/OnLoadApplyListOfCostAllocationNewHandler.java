package pomplatform.workflow.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.operation.bean.BaseOnLoadApplyListOfCostAllocationNew;
import pomplatform.workflow.operation.bean.ConditionOnLoadApplyListOfCostAllocationNew;
import pomplatform.workflow.operation.query.QueryOnLoadApplyListOfCostAllocationNew;
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

public class OnLoadApplyListOfCostAllocationNewHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfCostAllocationNewHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfCostAllocationNew> executeQueryOnLoadApplyListOfCostAllocationNew(ConditionOnLoadApplyListOfCostAllocationNew c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfCostAllocationNew dao = new QueryOnLoadApplyListOfCostAllocationNew();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfCostAllocationNew> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfCostAllocationNew c = new ConditionOnLoadApplyListOfCostAllocationNew();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfCostAllocationNew> result = executeQueryOnLoadApplyListOfCostAllocationNew(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfCostAllocationNew> result;
		ConditionOnLoadApplyListOfCostAllocationNew c = new ConditionOnLoadApplyListOfCostAllocationNew();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfCostAllocationNew dao = new QueryOnLoadApplyListOfCostAllocationNew();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfCostAllocationNew.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfCostAllocationNew b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


