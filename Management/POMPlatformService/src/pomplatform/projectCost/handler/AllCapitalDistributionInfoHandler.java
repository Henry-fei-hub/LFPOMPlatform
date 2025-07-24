package pomplatform.projectCost.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import pomplatform.projectCost.bean.BaseAllCapitalDistributionInfo;
import pomplatform.projectCost.bean.ConditionAllCapitalDistributionInfo;
import pomplatform.projectCost.query.QueryAllCapitalDistributionInfo;

public class AllCapitalDistributionInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AllCapitalDistributionInfoHandler.class);

	public static BaseCollection<BaseAllCapitalDistributionInfo> executeQueryAllCapitalDistributionInfo(ConditionAllCapitalDistributionInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryAllCapitalDistributionInfo dao = new QueryAllCapitalDistributionInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAllCapitalDistributionInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAllCapitalDistributionInfo c = new ConditionAllCapitalDistributionInfo();
		c.setDataFromJSON(creteria);
		if(null != c.getStartDistributeTime()){
			c.setStartDistributeTime(DateUtil.getNextDayOfDay(c.getStartDistributeTime(), 0));
		}
		if(null != c.getEndDistributeTime()){
			c.setEndDistributeTime(DateUtil.getNextDayOfDay(c.getEndDistributeTime(), 1));
		}
		if(null != c.getStartHappenDate()){
			c.setStartHappenDate(DateUtil.getNextDayOfDay(c.getStartHappenDate(), 0));
		}
		if(null != c.getEndHappenDate()){
			c.setEndHappenDate(DateUtil.getNextDayOfDay(c.getEndHappenDate(), 1));
		}
		BaseCollection<BaseAllCapitalDistributionInfo> result = executeQueryAllCapitalDistributionInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAllCapitalDistributionInfo> result;
		ConditionAllCapitalDistributionInfo c = new ConditionAllCapitalDistributionInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		if(null != c.getStartDistributeTime()){
			c.setStartDistributeTime(DateUtil.getNextDayOfDay(c.getStartDistributeTime(), 0));
		}
		if(null != c.getEndDistributeTime()){
			c.setEndDistributeTime(DateUtil.getNextDayOfDay(c.getEndDistributeTime(), 1));
		}
		if(null != c.getStartHappenDate()){
			c.setStartHappenDate(DateUtil.getNextDayOfDay(c.getStartHappenDate(), 0));
		}
		if(null != c.getEndHappenDate()){
			c.setEndHappenDate(DateUtil.getNextDayOfDay(c.getEndHappenDate(), 1));
		}
		QueryAllCapitalDistributionInfo dao = new QueryAllCapitalDistributionInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAllCapitalDistributionInfo.ALL_CAPTIONS);
			for(BaseAllCapitalDistributionInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


