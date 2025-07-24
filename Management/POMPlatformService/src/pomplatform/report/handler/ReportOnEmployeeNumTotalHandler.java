package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseReportOnEmployeeNumTotal;
import pomplatform.report.bean.ConditionReportOnEmployeeNumTotal;
import pomplatform.report.query.QueryReportOnEmployeeNumTotal;
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

public class ReportOnEmployeeNumTotalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportOnEmployeeNumTotalHandler.class);

	public static BaseCollection<BaseReportOnEmployeeNumTotal> executeQueryReportOnEmployeeNumTotal(ConditionReportOnEmployeeNumTotal c, KeyValuePair[] replacements ) throws Exception {
		QueryReportOnEmployeeNumTotal dao = new QueryReportOnEmployeeNumTotal();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportOnEmployeeNumTotal> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportOnEmployeeNumTotal c = new ConditionReportOnEmployeeNumTotal();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportOnEmployeeNumTotal> result = executeQueryReportOnEmployeeNumTotal(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportOnEmployeeNumTotal> result;
		ConditionReportOnEmployeeNumTotal c = new ConditionReportOnEmployeeNumTotal();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportOnEmployeeNumTotal dao = new QueryReportOnEmployeeNumTotal();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportOnEmployeeNumTotal.ALL_CAPTIONS);
			for(BaseReportOnEmployeeNumTotal b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


