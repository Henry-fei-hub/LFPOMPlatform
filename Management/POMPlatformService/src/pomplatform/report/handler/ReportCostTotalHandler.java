package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportCostTotal;
import pomplatform.report.bean.ConditionReportCostTotal;
import pomplatform.report.query.QueryReportCostTotal;
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

public class ReportCostTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportCostTotalHandler.class);

	public static BaseCollection<BaseReportCostTotal> executeQueryReportCostTotal(ConditionReportCostTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportCostTotal dao = new QueryReportCostTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportCostTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportCostTotal c = new ConditionReportCostTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportCostTotal> result = executeQueryReportCostTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportCostTotal> result;
		ConditionReportCostTotal c = new ConditionReportCostTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportCostTotal dao = new QueryReportCostTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportCostTotal.ALL_CAPTIONS);
			for(BaseReportCostTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


