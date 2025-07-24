package pomplatform.awaitingapproval.handler;

import org.apache.log4j.Logger;
import pomplatform.awaitingapproval.bean.BaseAwaitingapproval;
import pomplatform.awaitingapproval.bean.ConditionAwaitingapproval;
import pomplatform.awaitingapproval.query.QueryAwaitingapproval;
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

public class AwaitingapprovalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AwaitingapprovalHandler.class);

	public static BaseCollection<BaseAwaitingapproval> executeQueryAwaitingapproval(ConditionAwaitingapproval c, KeyValuePair[] replacements ) throws Exception {
		QueryAwaitingapproval dao = new QueryAwaitingapproval();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAwaitingapproval> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAwaitingapproval c = new ConditionAwaitingapproval();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAwaitingapproval> result = executeQueryAwaitingapproval(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAwaitingapproval> result;
		ConditionAwaitingapproval c = new ConditionAwaitingapproval();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAwaitingapproval dao = new QueryAwaitingapproval();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAwaitingapproval.ALL_CAPTIONS);
			for(BaseAwaitingapproval b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


