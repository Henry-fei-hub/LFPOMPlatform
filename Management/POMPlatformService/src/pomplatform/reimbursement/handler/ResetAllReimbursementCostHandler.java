package pomplatform.reimbursement.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursement.bean.BaseResetAllReimbursementCost;
import pomplatform.reimbursement.bean.ConditionResetAllReimbursementCost;
import pomplatform.reimbursement.query.QueryResetAllReimbursementCost;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class ResetAllReimbursementCostHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ResetAllReimbursementCostHandler.class);

	public static BaseCollection<BaseResetAllReimbursementCost> executeQueryResetAllReimbursementCost(ConditionResetAllReimbursementCost c, KeyValuePair[] replacements ) throws Exception {
		QueryResetAllReimbursementCost dao = new QueryResetAllReimbursementCost();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseResetAllReimbursementCost> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionResetAllReimbursementCost c = new ConditionResetAllReimbursementCost();
		c.setDataFromJSON(creteria);
		if(null != c.getStartTime()){
			c.setStartTime(DateUtil.getNextDayOfDay(c.getStartTime(), 0));
		}
		if(null != c.getEndTime()){
			c.setEndTime(DateUtil.getNextDayOfDay(c.getEndTime(), 1));
		}
		if(null != c.getStartCompleteTime()){
			c.setStartCompleteTime(DateUtil.getNextDayOfDay(c.getStartCompleteTime(), 0));
		}
		if(null != c.getEndCompleteTime()){
			c.setEndCompleteTime(DateUtil.getNextDayOfDay(c.getEndCompleteTime(), 1));
		}
		BaseCollection<BaseResetAllReimbursementCost> result = executeQueryResetAllReimbursementCost(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseResetAllReimbursementCost> result;
		ConditionResetAllReimbursementCost c = new ConditionResetAllReimbursementCost();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		if(null != c.getStartTime()){
			c.setStartTime(DateUtil.getNextDayOfDay(c.getStartTime(), 0));
		}
		if(null != c.getEndTime()){
			c.setEndTime(DateUtil.getNextDayOfDay(c.getEndTime(), 1));
		}
		if(null != c.getStartCompleteTime()){
			c.setStartCompleteTime(DateUtil.getNextDayOfDay(c.getStartCompleteTime(), 0));
		}
		if(null != c.getEndCompleteTime()){
			c.setEndCompleteTime(DateUtil.getNextDayOfDay(c.getEndCompleteTime(), 1));
		}
		QueryResetAllReimbursementCost dao = new QueryResetAllReimbursementCost();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseResetAllReimbursementCost.ALL_CAPTIONS);
			for(BaseResetAllReimbursementCost b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


