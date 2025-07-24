package pomplatform.projectReportRecordDetail.handler;

import org.apache.log4j.Logger;
import pomplatform.projectReportRecordDetail.bean.BaseProjectReportRecordDetail;
import pomplatform.projectReportRecordDetail.bean.ConditionProjectReportRecordDetail;
import pomplatform.projectReportRecordDetail.query.QueryProjectReportRecordDetail;
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

public class ProjectReportRecordDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectReportRecordDetailHandler.class);

	public static BaseCollection<BaseProjectReportRecordDetail> executeQueryProjectReportRecordDetail(ConditionProjectReportRecordDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectReportRecordDetail dao = new QueryProjectReportRecordDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectReportRecordDetail> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectReportRecordDetail c = new ConditionProjectReportRecordDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectReportRecordDetail> result = executeQueryProjectReportRecordDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectReportRecordDetail> result;
		ConditionProjectReportRecordDetail c = new ConditionProjectReportRecordDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectReportRecordDetail dao = new QueryProjectReportRecordDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectReportRecordDetail.ALL_CAPTIONS);
			for(BaseProjectReportRecordDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


