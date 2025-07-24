package pomplatform.PooledInspectionReport.handler;

import org.apache.log4j.Logger;
import pomplatform.PooledInspectionReport.bean.BasePooledInspectionReport;
import pomplatform.PooledInspectionReport.bean.ConditionPooledInspectionReport;
import pomplatform.PooledInspectionReport.query.QueryPooledInspectionReport;
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

public class PooledInspectionReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PooledInspectionReportHandler.class);

	public static BaseCollection<BasePooledInspectionReport> executeQueryPooledInspectionReport(ConditionPooledInspectionReport c, KeyValuePair[] replacements ) throws Exception {
		QueryPooledInspectionReport dao = new QueryPooledInspectionReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePooledInspectionReport> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPooledInspectionReport c = new ConditionPooledInspectionReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePooledInspectionReport> result = executeQueryPooledInspectionReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePooledInspectionReport> result;
		ConditionPooledInspectionReport c = new ConditionPooledInspectionReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPooledInspectionReport dao = new QueryPooledInspectionReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePooledInspectionReport.ALL_CAPTIONS);
			for(BasePooledInspectionReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


