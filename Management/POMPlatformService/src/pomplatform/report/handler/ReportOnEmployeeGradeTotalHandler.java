package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeGradeTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeGradeTotal;
import pomplatform.report.query.QueryReportOnEmployeeGradeTotal;
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

public class ReportOnEmployeeGradeTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeGradeTotalHandler.class);

	public static BaseCollection<BaseReportOnEmployeeGradeTotal> executeQueryReportOnEmployeeGradeTotal(ConditionReportOnEmployeeGradeTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeGradeTotal dao = new QueryReportOnEmployeeGradeTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeGradeTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeGradeTotal c = new ConditionReportOnEmployeeGradeTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeGradeTotal> result = executeQueryReportOnEmployeeGradeTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeGradeTotal> result;
		ConditionReportOnEmployeeGradeTotal c = new ConditionReportOnEmployeeGradeTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeGradeTotal dao = new QueryReportOnEmployeeGradeTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeGradeTotal.ALL_CAPTIONS);
			for(BaseReportOnEmployeeGradeTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


