package pomplatform.scapitaldistributionor.handler;

import org.apache.log4j.Logger;
import pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionsAuditOfWorkflow;
import pomplatform.scapitaldistributionor.bean.ConditionCapitalDistributionsAuditOfWorkflow;
import pomplatform.scapitaldistributionor.query.QueryCapitalDistributionsAuditOfWorkflow;
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

public class CapitalDistributionsAuditOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalDistributionsAuditOfWorkflowHandler.class);

	public static BaseCollection<BaseCapitalDistributionsAuditOfWorkflow> executeQueryCapitalDistributionsAuditOfWorkflow(ConditionCapitalDistributionsAuditOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalDistributionsAuditOfWorkflow dao = new QueryCapitalDistributionsAuditOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalDistributionsAuditOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalDistributionsAuditOfWorkflow c = new ConditionCapitalDistributionsAuditOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCapitalDistributionsAuditOfWorkflow> result = executeQueryCapitalDistributionsAuditOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalDistributionsAuditOfWorkflow> result;
		ConditionCapitalDistributionsAuditOfWorkflow c = new ConditionCapitalDistributionsAuditOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalDistributionsAuditOfWorkflow dao = new QueryCapitalDistributionsAuditOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalDistributionsAuditOfWorkflow.ALL_CAPTIONS);
			for(BaseCapitalDistributionsAuditOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


