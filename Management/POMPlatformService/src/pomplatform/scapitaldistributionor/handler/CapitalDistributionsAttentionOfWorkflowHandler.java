package pomplatform.scapitaldistributionor.handler;

import org.apache.log4j.Logger;
import pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionsAttentionOfWorkflow;
import pomplatform.scapitaldistributionor.bean.ConditionCapitalDistributionsAttentionOfWorkflow;
import pomplatform.scapitaldistributionor.query.QueryCapitalDistributionsAttentionOfWorkflow;
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

public class CapitalDistributionsAttentionOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalDistributionsAttentionOfWorkflowHandler.class);

	public static BaseCollection<BaseCapitalDistributionsAttentionOfWorkflow> executeQueryCapitalDistributionsAttentionOfWorkflow(ConditionCapitalDistributionsAttentionOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalDistributionsAttentionOfWorkflow dao = new QueryCapitalDistributionsAttentionOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalDistributionsAttentionOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalDistributionsAttentionOfWorkflow c = new ConditionCapitalDistributionsAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCapitalDistributionsAttentionOfWorkflow> result = executeQueryCapitalDistributionsAttentionOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalDistributionsAttentionOfWorkflow> result;
		ConditionCapitalDistributionsAttentionOfWorkflow c = new ConditionCapitalDistributionsAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalDistributionsAttentionOfWorkflow dao = new QueryCapitalDistributionsAttentionOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalDistributionsAttentionOfWorkflow.ALL_CAPTIONS);
			for(BaseCapitalDistributionsAttentionOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


