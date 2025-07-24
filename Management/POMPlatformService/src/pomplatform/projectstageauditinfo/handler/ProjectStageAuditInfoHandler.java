package pomplatform.projectstageauditinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.projectstageauditinfo.bean.BaseProjectStageAuditInfo;
import pomplatform.projectstageauditinfo.bean.ConditionProjectStageAuditInfo;
import pomplatform.projectstageauditinfo.query.QueryProjectStageAuditInfo;
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

public class ProjectStageAuditInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectStageAuditInfoHandler.class);

	public static BaseCollection<BaseProjectStageAuditInfo> executeQueryProjectStageAuditInfo(ConditionProjectStageAuditInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectStageAuditInfo dao = new QueryProjectStageAuditInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectStageAuditInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectStageAuditInfo c = new ConditionProjectStageAuditInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectStageAuditInfo> result = executeQueryProjectStageAuditInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectStageAuditInfo> result;
		ConditionProjectStageAuditInfo c = new ConditionProjectStageAuditInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectStageAuditInfo dao = new QueryProjectStageAuditInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectStageAuditInfo.ALL_CAPTIONS);
			for(BaseProjectStageAuditInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


