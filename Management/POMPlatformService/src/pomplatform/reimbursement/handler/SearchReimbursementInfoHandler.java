package pomplatform.reimbursement.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursement.bean.BaseSearchReimbursementInfo;
import pomplatform.reimbursement.bean.ConditionSearchReimbursementInfo;
import pomplatform.reimbursement.query.QuerySearchReimbursementInfo;
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

public class SearchReimbursementInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SearchReimbursementInfoHandler.class);

	public static BaseCollection<BaseSearchReimbursementInfo> executeQuerySearchReimbursementInfo(ConditionSearchReimbursementInfo c, KeyValuePair[] replacements ) throws Exception {
		QuerySearchReimbursementInfo dao = new QuerySearchReimbursementInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSearchReimbursementInfo> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSearchReimbursementInfo c = new ConditionSearchReimbursementInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSearchReimbursementInfo> result = executeQuerySearchReimbursementInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSearchReimbursementInfo> result;
		ConditionSearchReimbursementInfo c = new ConditionSearchReimbursementInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySearchReimbursementInfo dao = new QuerySearchReimbursementInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSearchReimbursementInfo.ALL_CAPTIONS);
			for(BaseSearchReimbursementInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


