package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseRefuseListOfMainProjectReport;
import pomplatform.workflow.bean.ConditionRefuseListOfMainProjectReport;
import pomplatform.workflow.query.QueryRefuseListOfMainProjectReport;
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

public class RefuseListOfMainProjectReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(RefuseListOfMainProjectReportHandler.class);

	public static BaseCollection<BaseRefuseListOfMainProjectReport> executeQueryRefuseListOfMainProjectReport(ConditionRefuseListOfMainProjectReport c, KeyValuePair[] replacements ) throws Exception {
		QueryRefuseListOfMainProjectReport dao = new QueryRefuseListOfMainProjectReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseRefuseListOfMainProjectReport> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionRefuseListOfMainProjectReport c = new ConditionRefuseListOfMainProjectReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseRefuseListOfMainProjectReport> result = executeQueryRefuseListOfMainProjectReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseRefuseListOfMainProjectReport> result;
		ConditionRefuseListOfMainProjectReport c = new ConditionRefuseListOfMainProjectReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryRefuseListOfMainProjectReport dao = new QueryRefuseListOfMainProjectReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseRefuseListOfMainProjectReport.ALL_CAPTIONS);
			for(BaseRefuseListOfMainProjectReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


