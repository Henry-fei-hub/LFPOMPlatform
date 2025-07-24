package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeTurnoverTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeTurnoverTotal;
import pomplatform.report.query.QueryReportOnEmployeeTurnoverTotal;
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

public class ReportOnEmployeeTurnoverTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeTurnoverTotalHandler.class);

	public static BaseCollection<BaseReportOnEmployeeTurnoverTotal> executeQueryReportOnEmployeeTurnoverTotal(ConditionReportOnEmployeeTurnoverTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeTurnoverTotal dao = new QueryReportOnEmployeeTurnoverTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeTurnoverTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeTurnoverTotal c = new ConditionReportOnEmployeeTurnoverTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeTurnoverTotal> result = executeQueryReportOnEmployeeTurnoverTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeTurnoverTotal> result;
		ConditionReportOnEmployeeTurnoverTotal c = new ConditionReportOnEmployeeTurnoverTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeTurnoverTotal dao = new QueryReportOnEmployeeTurnoverTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeTurnoverTotal.ALL_CAPTIONS);
			for(BaseReportOnEmployeeTurnoverTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


