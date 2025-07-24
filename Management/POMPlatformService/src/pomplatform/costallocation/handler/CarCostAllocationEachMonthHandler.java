package pomplatform.costallocation.handler;

import org.apache.log4j.Logger;
import pomplatform.costallocation.bean.BaseCarCostAllocationEachMonth;
import pomplatform.costallocation.bean.ConditionCarCostAllocationEachMonth;
import pomplatform.costallocation.query.QueryCarCostAllocationEachMonth;
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

public class CarCostAllocationEachMonthHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CarCostAllocationEachMonthHandler.class);

	public static BaseCollection<BaseCarCostAllocationEachMonth> executeQueryCarCostAllocationEachMonth(ConditionCarCostAllocationEachMonth c, KeyValuePair[] replacements ) throws Exception {
		QueryCarCostAllocationEachMonth dao = new QueryCarCostAllocationEachMonth();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCarCostAllocationEachMonth> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCarCostAllocationEachMonth c = new ConditionCarCostAllocationEachMonth();
		c.setDataFromJSON(creteria);
		formatCondition(c);
		BaseCollection<BaseCarCostAllocationEachMonth> result = executeQueryCarCostAllocationEachMonth(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCarCostAllocationEachMonth> result;
		ConditionCarCostAllocationEachMonth c = new ConditionCarCostAllocationEachMonth();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		formatCondition(c);
		QueryCarCostAllocationEachMonth dao = new QueryCarCostAllocationEachMonth();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCarCostAllocationEachMonth.ALL_CAPTIONS);
			for(BaseCarCostAllocationEachMonth b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	public void formatCondition(ConditionCarCostAllocationEachMonth condition){
		if(null != condition.getStartTime()){
			condition.setStartTime(DateUtil.getNextDayOfDay(condition.getStartTime(), 0));
		}
		if(null != condition.getEndTime()){
			condition.setEndTime(DateUtil.getNextDayOfDay(condition.getEndTime(), 1));
		}
	}
	
	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


