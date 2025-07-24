package pomplatform.InspectionReport.handler;

import org.apache.log4j.Logger;
import pomplatform.InspectionReport.bean.BaseInspectionReport;
import pomplatform.InspectionReport.bean.ConditionInspectionReport;
import pomplatform.InspectionReport.query.QueryInspectionReport;
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

public class InspectionReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(InspectionReportHandler.class);

	public static BaseCollection<BaseInspectionReport> executeQueryInspectionReport(ConditionInspectionReport c, KeyValuePair[] replacements ) throws Exception {
		QueryInspectionReport dao = new QueryInspectionReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseInspectionReport> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionInspectionReport c = new ConditionInspectionReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseInspectionReport> result = executeQueryInspectionReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseInspectionReport> result;
		ConditionInspectionReport c = new ConditionInspectionReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryInspectionReport dao = new QueryInspectionReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseInspectionReport.ALL_CAPTIONS);
			for(BaseInspectionReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


