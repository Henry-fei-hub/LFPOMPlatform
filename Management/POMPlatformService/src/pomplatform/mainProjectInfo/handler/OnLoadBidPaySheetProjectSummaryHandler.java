package pomplatform.mainProjectInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.mainProjectInfo.bean.BaseOnLoadBidPaySheetProjectSummary;
import pomplatform.mainProjectInfo.bean.ConditionOnLoadBidPaySheetProjectSummary;
import pomplatform.mainProjectInfo.query.QueryOnLoadBidPaySheetProjectSummary;
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

public class OnLoadBidPaySheetProjectSummaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadBidPaySheetProjectSummaryHandler.class);

	public static BaseCollection<BaseOnLoadBidPaySheetProjectSummary> executeQueryOnLoadBidPaySheetProjectSummary(ConditionOnLoadBidPaySheetProjectSummary c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadBidPaySheetProjectSummary dao = new QueryOnLoadBidPaySheetProjectSummary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadBidPaySheetProjectSummary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadBidPaySheetProjectSummary c = new ConditionOnLoadBidPaySheetProjectSummary();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadBidPaySheetProjectSummary> result = executeQueryOnLoadBidPaySheetProjectSummary(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadBidPaySheetProjectSummary> result;
		ConditionOnLoadBidPaySheetProjectSummary c = new ConditionOnLoadBidPaySheetProjectSummary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadBidPaySheetProjectSummary dao = new QueryOnLoadBidPaySheetProjectSummary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadBidPaySheetProjectSummary.DOWN_CAPTIONS);
			for(BaseOnLoadBidPaySheetProjectSummary b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


