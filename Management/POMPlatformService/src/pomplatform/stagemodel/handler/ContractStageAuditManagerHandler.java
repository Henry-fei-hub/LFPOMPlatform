package pomplatform.stagemodel.handler;

import org.apache.log4j.Logger;
import pomplatform.stagemodel.bean.BaseContractStageAuditManager;
import pomplatform.stagemodel.bean.ConditionContractStageAuditManager;
import pomplatform.stagemodel.query.QueryContractStageAuditManager;
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

public class ContractStageAuditManagerHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractStageAuditManagerHandler.class);

	public static BaseCollection<BaseContractStageAuditManager> executeQueryContractStageAuditManager(ConditionContractStageAuditManager c, KeyValuePair[] replacements ) throws Exception {
		QueryContractStageAuditManager dao = new QueryContractStageAuditManager();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractStageAuditManager> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractStageAuditManager c = new ConditionContractStageAuditManager();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractStageAuditManager> result = executeQueryContractStageAuditManager(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractStageAuditManager> result;
		ConditionContractStageAuditManager c = new ConditionContractStageAuditManager();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractStageAuditManager dao = new QueryContractStageAuditManager();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractStageAuditManager.ALL_CAPTIONS);
			for(BaseContractStageAuditManager b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


