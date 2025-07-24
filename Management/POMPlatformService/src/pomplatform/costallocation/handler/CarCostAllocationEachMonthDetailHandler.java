package pomplatform.costallocation.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import pomplatform.costallocation.bean.BaseCarCostAllocationEachMonthDetail;
import pomplatform.costallocation.bean.ConditionCarCostAllocationEachMonthDetail;
import pomplatform.costallocation.query.QueryCarCostAllocationEachMonthDetail;

public class CarCostAllocationEachMonthDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CarCostAllocationEachMonthDetailHandler.class);

	public static BaseCollection<BaseCarCostAllocationEachMonthDetail> executeQueryCarCostAllocationEachMonthDetail(ConditionCarCostAllocationEachMonthDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryCarCostAllocationEachMonthDetail dao = new QueryCarCostAllocationEachMonthDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCarCostAllocationEachMonthDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCarCostAllocationEachMonthDetail c = new ConditionCarCostAllocationEachMonthDetail();
		c.setDataFromJSON(creteria);
		formatCondition(c);
		BaseCollection<BaseCarCostAllocationEachMonthDetail> result = executeQueryCarCostAllocationEachMonthDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCarCostAllocationEachMonthDetail> result;
		ConditionCarCostAllocationEachMonthDetail c = new ConditionCarCostAllocationEachMonthDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		formatCondition(c);
		QueryCarCostAllocationEachMonthDetail dao = new QueryCarCostAllocationEachMonthDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCarCostAllocationEachMonthDetail.ALL_CAPTIONS);
			for(BaseCarCostAllocationEachMonthDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

	public void formatCondition(ConditionCarCostAllocationEachMonthDetail condition) throws Exception{
		if(null != condition.getStartTime()){
			condition.setStartTime(DateUtil.getNextDayOfDay(condition.getStartTime(), 0));
		}
		if(null != condition.getEndTime()){
			condition.setEndTime(DateUtil.getNextDayOfDay(condition.getEndTime(), 1));
		}
		if(null != condition.getYear() && null != condition.getMonth()){
			Date date = DateUtil.createDate(condition.getYear(), condition.getMonth(), 1);
			condition.setStartTime(DateUtil.getFirstDay(date));
			condition.setEndTime(DateUtil.getFirstDayOfNextMonth(date));
		}
	}
}


