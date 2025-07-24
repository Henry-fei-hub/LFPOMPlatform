package pomplatform.report.handler;

import org.apache.log4j.Logger;
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
import pomplatform.report.bean.BaseReportEmployeeDailyHoursTotal;
import pomplatform.report.bean.ConditionReportEmployeeDailyHoursTotal;
import pomplatform.report.query.QueryReportEmployeeDailyHoursTotal;

public class ReportEmployeeDailyHoursTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportEmployeeDailyHoursTotalHandler.class);

	public static BaseCollection<BaseReportEmployeeDailyHoursTotal> executeQueryReportEmployeeDailyHoursTotal(ConditionReportEmployeeDailyHoursTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportEmployeeDailyHoursTotal dao = new QueryReportEmployeeDailyHoursTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportEmployeeDailyHoursTotal> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportEmployeeDailyHoursTotal c = new ConditionReportEmployeeDailyHoursTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportEmployeeDailyHoursTotal> result = executeQueryReportEmployeeDailyHoursTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportEmployeeDailyHoursTotal> result;
		ConditionReportEmployeeDailyHoursTotal c = new ConditionReportEmployeeDailyHoursTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportEmployeeDailyHoursTotal dao = new QueryReportEmployeeDailyHoursTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportEmployeeDailyHoursTotal.ALL_CAPTIONS);
			for(BaseReportEmployeeDailyHoursTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


