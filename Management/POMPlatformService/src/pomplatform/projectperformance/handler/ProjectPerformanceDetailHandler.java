package pomplatform.projectperformance.handler;

import org.apache.log4j.Logger;
import pomplatform.projectperformance.bean.BaseProjectPerformanceDetail;
import pomplatform.projectperformance.bean.ConditionProjectPerformanceDetail;
import pomplatform.projectperformance.query.QueryProjectPerformanceDetail;
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

public class ProjectPerformanceDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectPerformanceDetailHandler.class);

	public static BaseCollection<BaseProjectPerformanceDetail> executeQueryProjectPerformanceDetail(ConditionProjectPerformanceDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectPerformanceDetail dao = new QueryProjectPerformanceDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectPerformanceDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectPerformanceDetail c = new ConditionProjectPerformanceDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectPerformanceDetail> result = executeQueryProjectPerformanceDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectPerformanceDetail> result;
		ConditionProjectPerformanceDetail c = new ConditionProjectPerformanceDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectPerformanceDetail dao = new QueryProjectPerformanceDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectPerformanceDetail.ALL_CAPTIONS);
			for(BaseProjectPerformanceDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


