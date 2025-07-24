package pomplatform.report.business;

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
import pomplatform.report.bean.BaseReportOfEmployeeCostAnalysis;
import pomplatform.report.bean.ConditionReportOfEmployeeCostAnalysis;
import pomplatform.report.query.QueryReportOfEmployeeCostAnalysis;

public class onDownloadEmployeeCostAnalysy implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(onDownloadEmployeeCostAnalysy.class);

	public static BaseCollection<BaseReportOfEmployeeCostAnalysis> executeQueryInsurance(ConditionReportOfEmployeeCostAnalysis c, KeyValuePair[] replacements ) throws Exception {
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
		BaseCollection<BaseReportOfEmployeeCostAnalysis> result = executeQueryInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOfEmployeeCostAnalysis> result;
		ConditionReportOfEmployeeCostAnalysis c = new ConditionReportOfEmployeeCostAnalysis();
		c.setDataFromJSON(creteria);
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
			ps.println(BaseReportOfEmployeeCostAnalysis.DOWNLOAD_CAPTIONS);
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


