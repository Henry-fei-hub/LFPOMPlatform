package pomplatform.report.handler;

import org.apache.log4j.Logger;
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
import pomplatform.report.bean.BaseReportProjectWorkTime;
import pomplatform.report.bean.ConditionReportProjectWorkTime;
import pomplatform.report.query.QueryReportProjectWorkTime;

public class ReportProjectWorkTimeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReportProjectWorkTimeHandler.class);

	public static BaseCollection<BaseReportProjectWorkTime> executeQueryReportProjectWorkTime(ConditionReportProjectWorkTime c, KeyValuePair[] replacements ) throws Exception {
		QueryReportProjectWorkTime dao = new QueryReportProjectWorkTime();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReportProjectWorkTime> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReportProjectWorkTime c = new ConditionReportProjectWorkTime();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReportProjectWorkTime> result = executeQueryReportProjectWorkTime(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReportProjectWorkTime> result;
		ConditionReportProjectWorkTime c = new ConditionReportProjectWorkTime();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReportProjectWorkTime dao = new QueryReportProjectWorkTime();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReportProjectWorkTime.ALL_CAPTIONS);
			for(BaseReportProjectWorkTime b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


