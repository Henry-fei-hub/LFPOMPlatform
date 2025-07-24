package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseOnPayMoneyManageBusiness;
import pomplatform.workflow.bean.ConditionOnPayMoneyManageBusiness;
import pomplatform.workflow.query.QueryOnPayMoneyManageBusiness;
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

public class OnPayMoneyManageBusinessHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnPayMoneyManageBusinessHandler.class);

	public static BaseCollection<BaseOnPayMoneyManageBusiness> executeQueryOnPayMoneyManageBusiness(ConditionOnPayMoneyManageBusiness c, KeyValuePair[] replacements ) throws Exception {
		QueryOnPayMoneyManageBusiness dao = new QueryOnPayMoneyManageBusiness();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnPayMoneyManageBusiness> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnPayMoneyManageBusiness c = new ConditionOnPayMoneyManageBusiness();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnPayMoneyManageBusiness> result = executeQueryOnPayMoneyManageBusiness(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnPayMoneyManageBusiness> result;
		ConditionOnPayMoneyManageBusiness c = new ConditionOnPayMoneyManageBusiness();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnPayMoneyManageBusiness dao = new QueryOnPayMoneyManageBusiness();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnPayMoneyManageBusiness.ALL_CAPTIONS);
			for(BaseOnPayMoneyManageBusiness b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


