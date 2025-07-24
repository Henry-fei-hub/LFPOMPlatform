package pomplatform.workflow.professional.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.professional.bean.BaseOnLoadApplyListOfProfessionalApproval;
import pomplatform.workflow.professional.bean.ConditionOnLoadApplyListOfProfessionalApproval;
import pomplatform.workflow.professional.query.QueryOnLoadApplyListOfProfessionalApproval;
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

public class OnLoadApplyListOfProfessionalApprovalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadApplyListOfProfessionalApprovalHandler.class);

	public static BaseCollection<BaseOnLoadApplyListOfProfessionalApproval> executeQueryOnLoadApplyListOfProfessionalApproval(ConditionOnLoadApplyListOfProfessionalApproval c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadApplyListOfProfessionalApproval dao = new QueryOnLoadApplyListOfProfessionalApproval();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadApplyListOfProfessionalApproval> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadApplyListOfProfessionalApproval c = new ConditionOnLoadApplyListOfProfessionalApproval();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadApplyListOfProfessionalApproval> result = executeQueryOnLoadApplyListOfProfessionalApproval(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadApplyListOfProfessionalApproval> result;
		ConditionOnLoadApplyListOfProfessionalApproval c = new ConditionOnLoadApplyListOfProfessionalApproval();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadApplyListOfProfessionalApproval dao = new QueryOnLoadApplyListOfProfessionalApproval();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadApplyListOfProfessionalApproval.ALL_CAPTIONS);
			for(BaseOnLoadApplyListOfProfessionalApproval b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


