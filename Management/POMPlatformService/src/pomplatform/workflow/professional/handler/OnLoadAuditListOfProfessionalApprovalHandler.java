package pomplatform.workflow.professional.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.professional.bean.BaseOnLoadAuditListOfProfessionalApproval;
import pomplatform.workflow.professional.bean.ConditionOnLoadAuditListOfProfessionalApproval;
import pomplatform.workflow.professional.query.QueryOnLoadAuditListOfProfessionalApproval;
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

public class OnLoadAuditListOfProfessionalApprovalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfProfessionalApprovalHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfProfessionalApproval> executeQueryOnLoadAuditListOfProfessionalApproval(ConditionOnLoadAuditListOfProfessionalApproval c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfProfessionalApproval dao = new QueryOnLoadAuditListOfProfessionalApproval();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfProfessionalApproval> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfProfessionalApproval c = new ConditionOnLoadAuditListOfProfessionalApproval();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfProfessionalApproval> result = executeQueryOnLoadAuditListOfProfessionalApproval(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfProfessionalApproval> result;
		ConditionOnLoadAuditListOfProfessionalApproval c = new ConditionOnLoadAuditListOfProfessionalApproval();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfProfessionalApproval dao = new QueryOnLoadAuditListOfProfessionalApproval();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfProfessionalApproval.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfProfessionalApproval b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


