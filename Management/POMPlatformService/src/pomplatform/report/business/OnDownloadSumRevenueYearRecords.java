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
import pomplatform.report.bean.BaseReportOfSumRevenueYearRecords;
import pomplatform.report.bean.ConditionReportOfSumRevenueYearRecords;
import pomplatform.report.query.QueryReportOfSumRevenueYearRecords;

public class OnDownloadSumRevenueYearRecords implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnDownloadSumRevenueYearRecords.class);

	public static BaseCollection<BaseReportOfSumRevenueYearRecords> executeQueryInsurance(ConditionReportOfSumRevenueYearRecords c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOfSumRevenueYearRecords dao = new QueryReportOfSumRevenueYearRecords();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOfSumRevenueYearRecords> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOfSumRevenueYearRecords c = new ConditionReportOfSumRevenueYearRecords();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOfSumRevenueYearRecords> result = executeQueryInsurance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOfSumRevenueYearRecords> result;
		ConditionReportOfSumRevenueYearRecords c = new ConditionReportOfSumRevenueYearRecords();
		c.setDataFromJSON(creteria);
		QueryReportOfSumRevenueYearRecords dao = new QueryReportOfSumRevenueYearRecords();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOfSumRevenueYearRecords.ALL_CAPTIONS);
			for(BaseReportOfSumRevenueYearRecords b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


