package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportSureIntegralDetail;
import pomplatform.report.bean.ConditionReportSureIntegralDetail;
import pomplatform.report.query.QueryReportSureIntegralDetail;
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

public class ReportSureIntegralDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportSureIntegralDetailHandler.class);

	public static BaseCollection<BaseReportSureIntegralDetail> executeQueryReportSureIntegralDetail(ConditionReportSureIntegralDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryReportSureIntegralDetail dao = new QueryReportSureIntegralDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportSureIntegralDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportSureIntegralDetail c = new ConditionReportSureIntegralDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportSureIntegralDetail> result = executeQueryReportSureIntegralDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportSureIntegralDetail> result;
		ConditionReportSureIntegralDetail c = new ConditionReportSureIntegralDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportSureIntegralDetail dao = new QueryReportSureIntegralDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportSureIntegralDetail.ALL_CAPTIONS);
			for(BaseReportSureIntegralDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


