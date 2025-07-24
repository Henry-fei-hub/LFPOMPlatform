package pomplatform.mainProjectInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.mainProjectInfo.bean.BaseOnLoadAuditListOfBidPaySheetProject;
import pomplatform.mainProjectInfo.bean.ConditionOnLoadAuditListOfBidPaySheetProject;
import pomplatform.mainProjectInfo.query.QueryOnLoadAuditListOfBidPaySheetProject;
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

public class OnLoadAuditListOfBidPaySheetProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfBidPaySheetProjectHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfBidPaySheetProject> executeQueryOnLoadAuditListOfBidPaySheetProject(ConditionOnLoadAuditListOfBidPaySheetProject c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfBidPaySheetProject dao = new QueryOnLoadAuditListOfBidPaySheetProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfBidPaySheetProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfBidPaySheetProject c = new ConditionOnLoadAuditListOfBidPaySheetProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfBidPaySheetProject> result = executeQueryOnLoadAuditListOfBidPaySheetProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfBidPaySheetProject> result;
		ConditionOnLoadAuditListOfBidPaySheetProject c = new ConditionOnLoadAuditListOfBidPaySheetProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfBidPaySheetProject dao = new QueryOnLoadAuditListOfBidPaySheetProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfBidPaySheetProject.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfBidPaySheetProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


