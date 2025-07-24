package pomplatform.scapitaldistributionor.handler;

import org.apache.log4j.Logger;
import pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionsPoolOfWorkflow;
import pomplatform.scapitaldistributionor.bean.ConditionCapitalDistributionsPoolOfWorkflow;
import pomplatform.scapitaldistributionor.query.QueryCapitalDistributionsPoolOfWorkflow;
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

public class CapitalDistributionsPoolOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalDistributionsPoolOfWorkflowHandler.class);

	public static BaseCollection<BaseCapitalDistributionsPoolOfWorkflow> executeQueryCapitalDistributionsPoolOfWorkflow(ConditionCapitalDistributionsPoolOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalDistributionsPoolOfWorkflow dao = new QueryCapitalDistributionsPoolOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalDistributionsPoolOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalDistributionsPoolOfWorkflow c = new ConditionCapitalDistributionsPoolOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCapitalDistributionsPoolOfWorkflow> result = executeQueryCapitalDistributionsPoolOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalDistributionsPoolOfWorkflow> result;
		ConditionCapitalDistributionsPoolOfWorkflow c = new ConditionCapitalDistributionsPoolOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalDistributionsPoolOfWorkflow dao = new QueryCapitalDistributionsPoolOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalDistributionsPoolOfWorkflow.ALL_CAPTIONS);
			for(BaseCapitalDistributionsPoolOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


