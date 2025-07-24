package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportMapTotals;
import pomplatform.report.bean.ConditionReportMapTotals;
import pomplatform.report.query.QueryReportMapTotals;
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

public class ReportMapTotalsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportMapTotalsHandler.class);

	public static BaseCollection<BaseReportMapTotals> executeQueryReportMapTotals(ConditionReportMapTotals c, KeyValuePair[] replacements ) throws Exception {
		QueryReportMapTotals dao = new QueryReportMapTotals();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportMapTotals> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportMapTotals c = new ConditionReportMapTotals();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportMapTotals> result = executeQueryReportMapTotals(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportMapTotals> result;
		ConditionReportMapTotals c = new ConditionReportMapTotals();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportMapTotals dao = new QueryReportMapTotals();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportMapTotals.ALL_CAPTIONS);
			for(BaseReportMapTotals b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


