package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportCostDetail;
import pomplatform.report.bean.ConditionReportCostDetail;
import pomplatform.report.query.QueryReportCostDetail;
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

public class ReportCostDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportCostDetailHandler.class);

	public static BaseCollection<BaseReportCostDetail> executeQueryReportCostDetail(ConditionReportCostDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryReportCostDetail dao = new QueryReportCostDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportCostDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportCostDetail c = new ConditionReportCostDetail();
		c.setDataFromJSON(creteria);
		if(null != c.getStartCreateTime()){
			c.setStartCreateTime(DateUtil.getNextDayOfDay(c.getStartCreateTime(), 0));
		}
		if(null != c.getEndCreateTime()){
			c.setEndCreateTime(DateUtil.getNextDayOfDay(c.getEndCreateTime(), 1));
		}
		if(null != c.getStartCompleteTime()){
			c.setStartCompleteTime(DateUtil.getNextDayOfDay(c.getStartCompleteTime(), 0));
		}
		if(null != c.getEndCompleteTime()){
			c.setEndCompleteTime(DateUtil.getNextDayOfDay(c.getEndCompleteTime(), 1));
		}
		BaseCollection<BaseReportCostDetail> result = executeQueryReportCostDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportCostDetail> result;
		ConditionReportCostDetail c = new ConditionReportCostDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		if(null != c.getStartCreateTime()){
			c.setStartCreateTime(DateUtil.getNextDayOfDay(c.getStartCreateTime(), 0));
		}
		if(null != c.getEndCreateTime()){
			c.setEndCreateTime(DateUtil.getNextDayOfDay(c.getEndCreateTime(), 1));
		}
		if(null != c.getStartCompleteTime()){
			c.setStartCompleteTime(DateUtil.getNextDayOfDay(c.getStartCompleteTime(), 0));
		}
		if(null != c.getEndCompleteTime()){
			c.setEndCompleteTime(DateUtil.getNextDayOfDay(c.getEndCompleteTime(), 1));
		}
		QueryReportCostDetail dao = new QueryReportCostDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportCostDetail.ALL_CAPTIONS);
			for(BaseReportCostDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


