package pomplatform.workflow.personnel.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnel.bean.BaseAuditOfEmployeeOnboard;
import pomplatform.workflow.personnel.bean.ConditionAuditOfEmployeeOnboard;
import pomplatform.workflow.personnel.query.QueryAuditOfEmployeeOnboard;
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

public class AuditOfEmployeeOnboardHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AuditOfEmployeeOnboardHandler.class);

	public static BaseCollection<BaseAuditOfEmployeeOnboard> executeQueryAuditOfEmployeeOnboard(ConditionAuditOfEmployeeOnboard c, KeyValuePair[] replacements ) throws Exception {
		QueryAuditOfEmployeeOnboard dao = new QueryAuditOfEmployeeOnboard();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAuditOfEmployeeOnboard> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAuditOfEmployeeOnboard c = new ConditionAuditOfEmployeeOnboard();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAuditOfEmployeeOnboard> result = executeQueryAuditOfEmployeeOnboard(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAuditOfEmployeeOnboard> result;
		ConditionAuditOfEmployeeOnboard c = new ConditionAuditOfEmployeeOnboard();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAuditOfEmployeeOnboard dao = new QueryAuditOfEmployeeOnboard();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAuditOfEmployeeOnboard.ALL_CAPTIONS);
			for(BaseAuditOfEmployeeOnboard b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


