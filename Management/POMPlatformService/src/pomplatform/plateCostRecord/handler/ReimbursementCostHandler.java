package pomplatform.plateCostRecord.handler;

import org.apache.log4j.Logger;
import pomplatform.plateCostRecord.bean.BaseReimbursementCost;
import pomplatform.plateCostRecord.bean.ConditionReimbursementCost;
import pomplatform.plateCostRecord.query.QueryReimbursementCost;
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

public class ReimbursementCostHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReimbursementCostHandler.class);

	public static BaseCollection<BaseReimbursementCost> executeQueryReimbursementCost(ConditionReimbursementCost c, KeyValuePair[] replacements ) throws Exception {
		QueryReimbursementCost dao = new QueryReimbursementCost();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReimbursementCost> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReimbursementCost c = new ConditionReimbursementCost();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReimbursementCost> result = executeQueryReimbursementCost(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReimbursementCost> result;
		ConditionReimbursementCost c = new ConditionReimbursementCost();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReimbursementCost dao = new QueryReimbursementCost();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReimbursementCost.ALL_CAPTIONS);
			for(BaseReimbursementCost b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


