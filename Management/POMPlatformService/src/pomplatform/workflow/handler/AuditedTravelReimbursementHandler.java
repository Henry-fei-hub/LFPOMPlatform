package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseAuditedTravelReimbursement;
import pomplatform.workflow.bean.ConditionAuditedTravelReimbursement;
import pomplatform.workflow.query.QueryAuditedTravelReimbursement;
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

public class AuditedTravelReimbursementHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AuditedTravelReimbursementHandler.class);

	public static BaseCollection<BaseAuditedTravelReimbursement> executeQueryAuditedTravelReimbursement(ConditionAuditedTravelReimbursement c, KeyValuePair[] replacements ) throws Exception {
		QueryAuditedTravelReimbursement dao = new QueryAuditedTravelReimbursement();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAuditedTravelReimbursement> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAuditedTravelReimbursement c = new ConditionAuditedTravelReimbursement();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAuditedTravelReimbursement> result = executeQueryAuditedTravelReimbursement(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAuditedTravelReimbursement> result;
		ConditionAuditedTravelReimbursement c = new ConditionAuditedTravelReimbursement();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAuditedTravelReimbursement dao = new QueryAuditedTravelReimbursement();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAuditedTravelReimbursement.ALL_CAPTIONS);
			for(BaseAuditedTravelReimbursement b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


