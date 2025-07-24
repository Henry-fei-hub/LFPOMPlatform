package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinessLinkProcessInstance;
import pomplatform.workflow.personnelbusiness.bean.ConditionPersonnelBusinessLinkProcessInstance;
import pomplatform.workflow.personnelbusiness.query.QueryPersonnelBusinessLinkProcessInstance;
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

public class PersonnelBusinessLinkProcessInstanceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PersonnelBusinessLinkProcessInstanceHandler.class);

	public static BaseCollection<BasePersonnelBusinessLinkProcessInstance> executeQueryPersonnelBusinessLinkProcessInstance(ConditionPersonnelBusinessLinkProcessInstance c, KeyValuePair[] replacements ) throws Exception {
		QueryPersonnelBusinessLinkProcessInstance dao = new QueryPersonnelBusinessLinkProcessInstance();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePersonnelBusinessLinkProcessInstance> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPersonnelBusinessLinkProcessInstance c = new ConditionPersonnelBusinessLinkProcessInstance();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePersonnelBusinessLinkProcessInstance> result = executeQueryPersonnelBusinessLinkProcessInstance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePersonnelBusinessLinkProcessInstance> result;
		ConditionPersonnelBusinessLinkProcessInstance c = new ConditionPersonnelBusinessLinkProcessInstance();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPersonnelBusinessLinkProcessInstance dao = new QueryPersonnelBusinessLinkProcessInstance();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePersonnelBusinessLinkProcessInstance.ALL_CAPTIONS);
			for(BasePersonnelBusinessLinkProcessInstance b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


