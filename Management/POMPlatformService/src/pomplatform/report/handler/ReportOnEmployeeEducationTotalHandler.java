package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeEducationTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeEducationTotal;
import pomplatform.report.query.QueryReportOnEmployeeEducationTotal;
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

public class ReportOnEmployeeEducationTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeEducationTotalHandler.class);

	public static BaseCollection<BaseReportOnEmployeeEducationTotal> executeQueryReportOnEmployeeEducationTotal(ConditionReportOnEmployeeEducationTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeEducationTotal dao = new QueryReportOnEmployeeEducationTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeEducationTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeEducationTotal c = new ConditionReportOnEmployeeEducationTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeEducationTotal> result = executeQueryReportOnEmployeeEducationTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeEducationTotal> result;
		ConditionReportOnEmployeeEducationTotal c = new ConditionReportOnEmployeeEducationTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeEducationTotal dao = new QueryReportOnEmployeeEducationTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeEducationTotal.ALL_CAPTIONS);
			for(BaseReportOnEmployeeEducationTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


