package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;

import pomplatform.bonusPayment.bean.BasebonusSummary;
import pomplatform.bonusPayment.bean.BasebonusSummaryDetail;
import pomplatform.bonusPayment.bean.ConditionbonusSummaryDetail;
import pomplatform.bonusPayment.query.QuerybonusSummaryDetail;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class bonusSummaryDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(bonusSummaryDetailHandler.class);

	public static BaseCollection<BasebonusSummaryDetail> executeQuerybonusSummaryDetail(ConditionbonusSummaryDetail c, KeyValuePair[] replacements ) throws Exception {
		QuerybonusSummaryDetail dao = new QuerybonusSummaryDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasebonusSummaryDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionbonusSummaryDetail c = new ConditionbonusSummaryDetail();
		c.setDataFromJSON(creteria);
		Date firstend = c.getFirstend();
		Calendar ca =Calendar.getInstance();
		ca.setTime(firstend);
		int year = ca.get(Calendar.YEAR);
		BaseCollection<BasebonusSummaryDetail> result = executeQuerybonusSummaryDetail(c, c.getKeyValues());
		if(!BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
			List<BasebonusSummaryDetail> collections = result.getCollections();
			for (BasebonusSummaryDetail basebonusSummary : collections) {
				basebonusSummary.setYear(year+"");
			}
		}
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasebonusSummaryDetail> result;
		ConditionbonusSummaryDetail c = new ConditionbonusSummaryDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerybonusSummaryDetail dao = new QuerybonusSummaryDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		Date firstend = c.getFirstend();
		Calendar ca =Calendar.getInstance();
		ca.setTime(firstend);
		int year = ca.get(Calendar.YEAR);
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasebonusSummaryDetail.ALL_CAPTIONS);
			for(BasebonusSummaryDetail b : result.getCollections()){
				b.setYear(year+"");
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


