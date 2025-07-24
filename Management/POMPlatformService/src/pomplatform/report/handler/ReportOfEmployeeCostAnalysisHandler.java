package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOfEmployeeCostAnalysis;
import pomplatform.report.bean.ConditionReportOfEmployeeCostAnalysis;
import pomplatform.report.query.QueryReportOfEmployeeCostAnalysis;
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

public class ReportOfEmployeeCostAnalysisHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOfEmployeeCostAnalysisHandler.class);

	public static BaseCollection<BaseReportOfEmployeeCostAnalysis> executeQueryReportOfEmployeeCostAnalysis(ConditionReportOfEmployeeCostAnalysis c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOfEmployeeCostAnalysis dao = new QueryReportOfEmployeeCostAnalysis();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOfEmployeeCostAnalysis> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOfEmployeeCostAnalysis c = new ConditionReportOfEmployeeCostAnalysis();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOfEmployeeCostAnalysis> result = executeQueryReportOfEmployeeCostAnalysis(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOfEmployeeCostAnalysis> result;
		ConditionReportOfEmployeeCostAnalysis c = new ConditionReportOfEmployeeCostAnalysis();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOfEmployeeCostAnalysis dao = new QueryReportOfEmployeeCostAnalysis();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOfEmployeeCostAnalysis.ALL_CAPTIONS);
			for(BaseReportOfEmployeeCostAnalysis b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


