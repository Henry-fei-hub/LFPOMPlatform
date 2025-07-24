package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportCapitaDepartmentDetail;
import pomplatform.report.bean.ConditionReportCapitaDepartmentDetail;
import pomplatform.report.query.QueryReportCapitaDepartmentDetail;
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

public class ReportCapitaDepartmentDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportCapitaDepartmentDetailHandler.class);

	public static BaseCollection<BaseReportCapitaDepartmentDetail> executeQueryReportCapitaDepartmentDetail(ConditionReportCapitaDepartmentDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryReportCapitaDepartmentDetail dao = new QueryReportCapitaDepartmentDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportCapitaDepartmentDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportCapitaDepartmentDetail c = new ConditionReportCapitaDepartmentDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportCapitaDepartmentDetail> result = executeQueryReportCapitaDepartmentDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportCapitaDepartmentDetail> result;
		ConditionReportCapitaDepartmentDetail c = new ConditionReportCapitaDepartmentDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportCapitaDepartmentDetail dao = new QueryReportCapitaDepartmentDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportCapitaDepartmentDetail.ALL_CAPTIONS);
			for(BaseReportCapitaDepartmentDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


