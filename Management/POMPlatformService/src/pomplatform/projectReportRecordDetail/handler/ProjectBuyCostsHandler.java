package pomplatform.projectReportRecordDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.projectReportRecordDetail.bean.BaseProjectBuyCosts;
import pomplatform.projectReportRecordDetail.bean.ConditionProjectBuyCosts;
import pomplatform.projectReportRecordDetail.query.QueryProjectBuyCosts;
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

public class ProjectBuyCostsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectBuyCostsHandler.class);

	public static BaseCollection<BaseProjectBuyCosts> executeQueryProjectBuyCosts(ConditionProjectBuyCosts c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectBuyCosts dao = new QueryProjectBuyCosts();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectBuyCosts> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectBuyCosts c = new ConditionProjectBuyCosts();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectBuyCosts> result = executeQueryProjectBuyCosts(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectBuyCosts> result;
		ConditionProjectBuyCosts c = new ConditionProjectBuyCosts();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectBuyCosts dao = new QueryProjectBuyCosts();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectBuyCosts.ALL_CAPTIONS);
			for(BaseProjectBuyCosts b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


