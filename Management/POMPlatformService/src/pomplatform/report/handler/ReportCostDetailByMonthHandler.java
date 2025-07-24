package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportCostDetailByMonth;
import pomplatform.report.bean.ConditionReportCostDetailByMonth;
import pomplatform.report.query.QueryReportCostDetailByMonth;
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

public class ReportCostDetailByMonthHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportCostDetailByMonthHandler.class);

	public static BaseCollection<BaseReportCostDetailByMonth> executeQueryReportCostDetailByMonth(ConditionReportCostDetailByMonth c, KeyValuePair[] replacements ) throws Exception {
		QueryReportCostDetailByMonth dao = new QueryReportCostDetailByMonth();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportCostDetailByMonth> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportCostDetailByMonth c = new ConditionReportCostDetailByMonth();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportCostDetailByMonth> result = executeQueryReportCostDetailByMonth(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportCostDetailByMonth> result;
		ConditionReportCostDetailByMonth c = new ConditionReportCostDetailByMonth();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportCostDetailByMonth dao = new QueryReportCostDetailByMonth();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportCostDetailByMonth.ALL_CAPTIONS);
			for(BaseReportCostDetailByMonth b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


