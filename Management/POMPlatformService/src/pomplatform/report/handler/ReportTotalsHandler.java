package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportTotals;
import pomplatform.report.bean.ConditionReportTotals;
import pomplatform.report.query.QueryReportTotals;
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

public class ReportTotalsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportTotalsHandler.class);

	public static BaseCollection<BaseReportTotals> executeQueryReportTotals(ConditionReportTotals c, KeyValuePair[] replacements ) throws Exception {
		QueryReportTotals dao = new QueryReportTotals();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportTotals> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportTotals c = new ConditionReportTotals();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportTotals> result = executeQueryReportTotals(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportTotals> result;
		ConditionReportTotals c = new ConditionReportTotals();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportTotals dao = new QueryReportTotals();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportTotals.ALL_CAPTIONS);
			for(BaseReportTotals b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


