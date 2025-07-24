package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseApplyListOfMainProjectReport;
import pomplatform.workflow.bean.ConditionApplyListOfMainProjectReport;
import pomplatform.workflow.query.QueryApplyListOfMainProjectReport;
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

public class ApplyListOfMainProjectReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ApplyListOfMainProjectReportHandler.class);

	public static BaseCollection<BaseApplyListOfMainProjectReport> executeQueryApplyListOfMainProjectReport(ConditionApplyListOfMainProjectReport c, KeyValuePair[] replacements ) throws Exception {
		QueryApplyListOfMainProjectReport dao = new QueryApplyListOfMainProjectReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseApplyListOfMainProjectReport> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionApplyListOfMainProjectReport c = new ConditionApplyListOfMainProjectReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseApplyListOfMainProjectReport> result = executeQueryApplyListOfMainProjectReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseApplyListOfMainProjectReport> result;
		ConditionApplyListOfMainProjectReport c = new ConditionApplyListOfMainProjectReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryApplyListOfMainProjectReport dao = new QueryApplyListOfMainProjectReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseApplyListOfMainProjectReport.ALL_CAPTIONS);
			for(BaseApplyListOfMainProjectReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


