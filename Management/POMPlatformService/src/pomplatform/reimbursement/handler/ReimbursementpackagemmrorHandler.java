package pomplatform.reimbursement.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.reimbursement.bean.BaseReimbursementpackagemmror;
import pomplatform.reimbursement.bean.ConditionReimbursementpackagemmror;
import pomplatform.reimbursement.query.QueryReimbursementpackagemmror;

public class ReimbursementpackagemmrorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReimbursementpackagemmrorHandler.class);

	public static BaseCollection<BaseReimbursementpackagemmror> executeQueryReimbursementpackagemmror(ConditionReimbursementpackagemmror c, KeyValuePair[] replacements ) throws Exception {
		QueryReimbursementpackagemmror dao = new QueryReimbursementpackagemmror();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseReimbursementpackagemmror> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionReimbursementpackagemmror c = new ConditionReimbursementpackagemmror();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseReimbursementpackagemmror> result = executeQueryReimbursementpackagemmror(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseReimbursementpackagemmror> result;
		ConditionReimbursementpackagemmror c = new ConditionReimbursementpackagemmror();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryReimbursementpackagemmror dao = new QueryReimbursementpackagemmror();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseReimbursementpackagemmror.ALL_CAPTIONS);
			for(BaseReimbursementpackagemmror b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


