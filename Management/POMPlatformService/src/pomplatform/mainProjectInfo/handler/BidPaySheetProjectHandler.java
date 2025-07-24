package pomplatform.mainProjectInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.mainProjectInfo.bean.BaseBidPaySheetProject;
import pomplatform.mainProjectInfo.bean.ConditionBidPaySheetProject;
import pomplatform.mainProjectInfo.query.QueryBidPaySheetProject;
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

public class BidPaySheetProjectHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BidPaySheetProjectHandler.class);

	public static BaseCollection<BaseBidPaySheetProject> executeQueryBidPaySheetProject(ConditionBidPaySheetProject c, KeyValuePair[] replacements ) throws Exception {
		QueryBidPaySheetProject dao = new QueryBidPaySheetProject();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBidPaySheetProject> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBidPaySheetProject c = new ConditionBidPaySheetProject();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBidPaySheetProject> result = executeQueryBidPaySheetProject(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBidPaySheetProject> result;
		ConditionBidPaySheetProject c = new ConditionBidPaySheetProject();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBidPaySheetProject dao = new QueryBidPaySheetProject();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBidPaySheetProject.ALL_CAPTIONS);
			for(BaseBidPaySheetProject b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


