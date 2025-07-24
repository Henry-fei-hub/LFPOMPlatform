package pomplatform.workflow.personnel.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnel.bean.BaseOnLoadAuditListOfPersonnel;
import pomplatform.workflow.personnel.bean.ConditionOnLoadAuditListOfPersonnel;
import pomplatform.workflow.personnel.query.QueryOnLoadAuditListOfPersonnel;
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

public class OnLoadAuditListOfPersonnelHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfPersonnelHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfPersonnel> executeQueryOnLoadAuditListOfPersonnel(ConditionOnLoadAuditListOfPersonnel c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfPersonnel dao = new QueryOnLoadAuditListOfPersonnel();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfPersonnel> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfPersonnel c = new ConditionOnLoadAuditListOfPersonnel();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfPersonnel> result = executeQueryOnLoadAuditListOfPersonnel(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfPersonnel> result;
		ConditionOnLoadAuditListOfPersonnel c = new ConditionOnLoadAuditListOfPersonnel();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfPersonnel dao = new QueryOnLoadAuditListOfPersonnel();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfPersonnel.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfPersonnel b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


