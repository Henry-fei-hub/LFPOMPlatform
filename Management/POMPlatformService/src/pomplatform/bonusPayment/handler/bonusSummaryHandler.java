package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BasebonusSummary;
import pomplatform.bonusPayment.bean.ConditionbonusSummary;
import pomplatform.bonusPayment.query.QuerybonusSummary;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class bonusSummaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(bonusSummaryHandler.class);

	public static BaseCollection<BasebonusSummary> executeQuerybonusSummary(ConditionbonusSummary c, KeyValuePair[] replacements ) throws Exception {
		QuerybonusSummary dao = new QuerybonusSummary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasebonusSummary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionbonusSummary c = new ConditionbonusSummary();
		c.setDataFromJSON(creteria);
		Date firstStart = c.getFirstStart();
		Calendar ca =Calendar.getInstance();
		ca.setTime(firstStart);
		int year = ca.get(Calendar.YEAR);
		BaseCollection<BasebonusSummary> result = executeQuerybonusSummary(c, c.getKeyValues());
		if(!BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
			List<BasebonusSummary> collections = result.getCollections();
			for (BasebonusSummary basebonusSummary : collections) {
				basebonusSummary.setYear(year+"");
			}
		}
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasebonusSummary> result;
		ConditionbonusSummary c = new ConditionbonusSummary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerybonusSummary dao = new QuerybonusSummary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		Date firstStart = c.getFirstStart();
		Calendar ca =Calendar.getInstance();
		ca.setTime(firstStart);
		int year = ca.get(Calendar.YEAR);
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasebonusSummary.ALL_CAPTIONS);
			for(BasebonusSummary b : result.getCollections()){
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


