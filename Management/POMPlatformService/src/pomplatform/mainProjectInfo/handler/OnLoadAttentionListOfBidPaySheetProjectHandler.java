package pomplatform.mainProjectInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.mainProjectInfo.bean.BaseOnLoadAttentionListOfBidPaySheetProject;
import pomplatform.mainProjectInfo.bean.ConditionOnLoadAttentionListOfBidPaySheetProject;
import pomplatform.mainProjectInfo.query.QueryOnLoadAttentionListOfBidPaySheetProject;
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

public class OnLoadAttentionListOfBidPaySheetProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttentionListOfBidPaySheetProjectHandler.class);

	public static BaseCollection<BaseOnLoadAttentionListOfBidPaySheetProject> executeQueryOnLoadAttentionListOfBidPaySheetProject(ConditionOnLoadAttentionListOfBidPaySheetProject c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttentionListOfBidPaySheetProject dao = new QueryOnLoadAttentionListOfBidPaySheetProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttentionListOfBidPaySheetProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttentionListOfBidPaySheetProject c = new ConditionOnLoadAttentionListOfBidPaySheetProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttentionListOfBidPaySheetProject> result = executeQueryOnLoadAttentionListOfBidPaySheetProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttentionListOfBidPaySheetProject> result;
		ConditionOnLoadAttentionListOfBidPaySheetProject c = new ConditionOnLoadAttentionListOfBidPaySheetProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttentionListOfBidPaySheetProject dao = new QueryOnLoadAttentionListOfBidPaySheetProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttentionListOfBidPaySheetProject.ALL_CAPTIONS);
			for(BaseOnLoadAttentionListOfBidPaySheetProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


