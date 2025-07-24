package pomplatform.mobile.approvalcount.handler;

import org.apache.log4j.Logger;
import pomplatform.mobile.approvalcount.bean.BaseMyApprovalSummary;
import pomplatform.mobile.approvalcount.bean.ConditionMyApprovalSummary;
import pomplatform.mobile.approvalcount.query.QueryMyApprovalSummary;
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

public class MyApprovalSummaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MyApprovalSummaryHandler.class);

	public static BaseCollection<BaseMyApprovalSummary> executeQueryMyApprovalSummary(ConditionMyApprovalSummary c, KeyValuePair[] replacements ) throws Exception {
		QueryMyApprovalSummary dao = new QueryMyApprovalSummary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMyApprovalSummary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMyApprovalSummary c = new ConditionMyApprovalSummary();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMyApprovalSummary> result = executeQueryMyApprovalSummary(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMyApprovalSummary> result;
		ConditionMyApprovalSummary c = new ConditionMyApprovalSummary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMyApprovalSummary dao = new QueryMyApprovalSummary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMyApprovalSummary.ALL_CAPTIONS);
			for(BaseMyApprovalSummary b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


