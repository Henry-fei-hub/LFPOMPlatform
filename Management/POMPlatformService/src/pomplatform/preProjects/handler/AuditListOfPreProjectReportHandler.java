package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjects.bean.BaseAuditListOfPreProjectReport;
import pomplatform.preProjects.bean.ConditionAuditListOfPreProjectReport;
import pomplatform.preProjects.query.QueryAuditListOfPreProjectReport;
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

public class AuditListOfPreProjectReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AuditListOfPreProjectReportHandler.class);

	public static BaseCollection<BaseAuditListOfPreProjectReport> executeQueryAuditListOfPreProjectReport(ConditionAuditListOfPreProjectReport c, KeyValuePair[] replacements ) throws Exception {
		QueryAuditListOfPreProjectReport dao = new QueryAuditListOfPreProjectReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAuditListOfPreProjectReport> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAuditListOfPreProjectReport c = new ConditionAuditListOfPreProjectReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAuditListOfPreProjectReport> result = executeQueryAuditListOfPreProjectReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAuditListOfPreProjectReport> result;
		ConditionAuditListOfPreProjectReport c = new ConditionAuditListOfPreProjectReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAuditListOfPreProjectReport dao = new QueryAuditListOfPreProjectReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAuditListOfPreProjectReport.ALL_CAPTIONS);
			for(BaseAuditListOfPreProjectReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


