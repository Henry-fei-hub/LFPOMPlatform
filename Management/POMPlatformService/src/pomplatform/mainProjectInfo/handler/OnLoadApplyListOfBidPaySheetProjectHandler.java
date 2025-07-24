package pomplatform.mainProjectInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.mainProjectInfo.bean.BaseOnLoadApplyListOfBidPaySheetProject;
import pomplatform.mainProjectInfo.bean.ConditionOnLoadApplyListOfBidPaySheetProject;
import pomplatform.mainProjectInfo.query.QueryOnLoadApplyListOfBidPaySheetProject;
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

public class OnLoadApplyListOfBidPaySheetProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfBidPaySheetProjectHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfBidPaySheetProject> executeQueryOnLoadApplyListOfBidPaySheetProject(ConditionOnLoadApplyListOfBidPaySheetProject c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfBidPaySheetProject dao = new QueryOnLoadApplyListOfBidPaySheetProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfBidPaySheetProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfBidPaySheetProject c = new ConditionOnLoadApplyListOfBidPaySheetProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfBidPaySheetProject> result = executeQueryOnLoadApplyListOfBidPaySheetProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfBidPaySheetProject> result;
		ConditionOnLoadApplyListOfBidPaySheetProject c = new ConditionOnLoadApplyListOfBidPaySheetProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfBidPaySheetProject dao = new QueryOnLoadApplyListOfBidPaySheetProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfBidPaySheetProject.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfBidPaySheetProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


