package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeSeniorityTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeSeniorityTotal;
import pomplatform.report.query.QueryReportOnEmployeeSeniorityTotal;
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

public class ReportOnEmployeeSeniorityTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeSeniorityTotalHandler.class);

	public static BaseCollection<BaseReportOnEmployeeSeniorityTotal> executeQueryReportOnEmployeeSeniorityTotal(ConditionReportOnEmployeeSeniorityTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeSeniorityTotal dao = new QueryReportOnEmployeeSeniorityTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeSeniorityTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeSeniorityTotal c = new ConditionReportOnEmployeeSeniorityTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeSeniorityTotal> result = executeQueryReportOnEmployeeSeniorityTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeSeniorityTotal> result;
		ConditionReportOnEmployeeSeniorityTotal c = new ConditionReportOnEmployeeSeniorityTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeSeniorityTotal dao = new QueryReportOnEmployeeSeniorityTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeSeniorityTotal.ALL_CAPTIONS);
			for(BaseReportOnEmployeeSeniorityTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


