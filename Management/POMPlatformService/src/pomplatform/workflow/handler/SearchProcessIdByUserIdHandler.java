package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseSearchProcessIdByUserId;
import pomplatform.workflow.bean.ConditionSearchProcessIdByUserId;
import pomplatform.workflow.query.QuerySearchProcessIdByUserId;
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

public class SearchProcessIdByUserIdHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SearchProcessIdByUserIdHandler.class);

	public static BaseCollection<BaseSearchProcessIdByUserId> executeQuerySearchProcessIdByUserId(ConditionSearchProcessIdByUserId c, KeyValuePair[] replacements ) throws Exception {
		QuerySearchProcessIdByUserId dao = new QuerySearchProcessIdByUserId();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSearchProcessIdByUserId> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSearchProcessIdByUserId c = new ConditionSearchProcessIdByUserId();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSearchProcessIdByUserId> result = executeQuerySearchProcessIdByUserId(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSearchProcessIdByUserId> result;
		ConditionSearchProcessIdByUserId c = new ConditionSearchProcessIdByUserId();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySearchProcessIdByUserId dao = new QuerySearchProcessIdByUserId();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSearchProcessIdByUserId.ALL_CAPTIONS);
			for(BaseSearchProcessIdByUserId b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


