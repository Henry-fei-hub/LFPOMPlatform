package pomplatform.workflow.operation.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.operation.bean.BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID;
import pomplatform.workflow.operation.bean.ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID;
import pomplatform.workflow.operation.query.QueryOnLoadApplyListOfCostAllocationSerchEmplyeeID;
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

public class OnLoadApplyListOfCostAllocationSerchEmplyeeIDHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfCostAllocationSerchEmplyeeIDHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID> executeQueryOnLoadApplyListOfCostAllocationSerchEmplyeeID(ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfCostAllocationSerchEmplyeeID dao = new QueryOnLoadApplyListOfCostAllocationSerchEmplyeeID();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID c = new ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID> result = executeQueryOnLoadApplyListOfCostAllocationSerchEmplyeeID(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID> result;
		ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID c = new ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfCostAllocationSerchEmplyeeID dao = new QueryOnLoadApplyListOfCostAllocationSerchEmplyeeID();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfCostAllocationSerchEmplyeeID b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


