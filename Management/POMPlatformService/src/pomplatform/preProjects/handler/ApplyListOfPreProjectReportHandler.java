package pomplatform.preProjects.handler;

import org.apache.log4j.Logger;
import pomplatform.preProjects.bean.BaseApplyListOfPreProjectReport;
import pomplatform.preProjects.bean.ConditionApplyListOfPreProjectReport;
import pomplatform.preProjects.query.QueryApplyListOfPreProjectReport;
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

public class ApplyListOfPreProjectReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ApplyListOfPreProjectReportHandler.class);

	public static BaseCollection<BaseApplyListOfPreProjectReport> executeQueryApplyListOfPreProjectReport(ConditionApplyListOfPreProjectReport c, KeyValuePair[] replacements ) throws Exception {
		QueryApplyListOfPreProjectReport dao = new QueryApplyListOfPreProjectReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseApplyListOfPreProjectReport> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionApplyListOfPreProjectReport c = new ConditionApplyListOfPreProjectReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseApplyListOfPreProjectReport> result = executeQueryApplyListOfPreProjectReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseApplyListOfPreProjectReport> result;
		ConditionApplyListOfPreProjectReport c = new ConditionApplyListOfPreProjectReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryApplyListOfPreProjectReport dao = new QueryApplyListOfPreProjectReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseApplyListOfPreProjectReport.ALL_CAPTIONS);
			for(BaseApplyListOfPreProjectReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


