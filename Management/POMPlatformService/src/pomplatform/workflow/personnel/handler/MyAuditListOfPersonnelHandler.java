package pomplatform.workflow.personnel.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnel.bean.BaseMyAuditListOfPersonnel;
import pomplatform.workflow.personnel.bean.ConditionMyAuditListOfPersonnel;
import pomplatform.workflow.personnel.query.QueryMyAuditListOfPersonnel;
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

public class MyAuditListOfPersonnelHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MyAuditListOfPersonnelHandler.class);

	public static BaseCollection<BaseMyAuditListOfPersonnel> executeQueryMyAuditListOfPersonnel(ConditionMyAuditListOfPersonnel c, KeyValuePair[] replacements ) throws Exception {
		QueryMyAuditListOfPersonnel dao = new QueryMyAuditListOfPersonnel();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMyAuditListOfPersonnel> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMyAuditListOfPersonnel c = new ConditionMyAuditListOfPersonnel();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMyAuditListOfPersonnel> result = executeQueryMyAuditListOfPersonnel(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMyAuditListOfPersonnel> result;
		ConditionMyAuditListOfPersonnel c = new ConditionMyAuditListOfPersonnel();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMyAuditListOfPersonnel dao = new QueryMyAuditListOfPersonnel();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMyAuditListOfPersonnel.ALL_CAPTIONS);
			for(BaseMyAuditListOfPersonnel b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


