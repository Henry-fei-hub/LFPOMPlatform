package pomplatform.scapitaldistributionor.handler;

import org.apache.log4j.Logger;
import pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionsApplyOfWorkflow;
import pomplatform.scapitaldistributionor.bean.ConditionCapitalDistributionsApplyOfWorkflow;
import pomplatform.scapitaldistributionor.query.QueryCapitalDistributionsApplyOfWorkflow;
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

public class CapitalDistributionsApplyOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalDistributionsApplyOfWorkflowHandler.class);

	public static BaseCollection<BaseCapitalDistributionsApplyOfWorkflow> executeQueryCapitalDistributionsApplyOfWorkflow(ConditionCapitalDistributionsApplyOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalDistributionsApplyOfWorkflow dao = new QueryCapitalDistributionsApplyOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalDistributionsApplyOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalDistributionsApplyOfWorkflow c = new ConditionCapitalDistributionsApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCapitalDistributionsApplyOfWorkflow> result = executeQueryCapitalDistributionsApplyOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalDistributionsApplyOfWorkflow> result;
		ConditionCapitalDistributionsApplyOfWorkflow c = new ConditionCapitalDistributionsApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalDistributionsApplyOfWorkflow dao = new QueryCapitalDistributionsApplyOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalDistributionsApplyOfWorkflow.ALL_CAPTIONS);
			for(BaseCapitalDistributionsApplyOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


