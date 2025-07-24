package pomplatform.stagemodel.handler;

import org.apache.log4j.Logger;
import pomplatform.stagemodel.bean.BaseContractStageAuditDesigner;
import pomplatform.stagemodel.bean.ConditionContractStageAuditDesigner;
import pomplatform.stagemodel.query.QueryContractStageAuditDesigner;
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

public class ContractStageAuditDesignerHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ContractStageAuditDesignerHandler.class);

	public static BaseCollection<BaseContractStageAuditDesigner> executeQueryContractStageAuditDesigner(ConditionContractStageAuditDesigner c, KeyValuePair[] replacements ) throws Exception {
		QueryContractStageAuditDesigner dao = new QueryContractStageAuditDesigner();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseContractStageAuditDesigner> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionContractStageAuditDesigner c = new ConditionContractStageAuditDesigner();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseContractStageAuditDesigner> result = executeQueryContractStageAuditDesigner(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseContractStageAuditDesigner> result;
		ConditionContractStageAuditDesigner c = new ConditionContractStageAuditDesigner();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryContractStageAuditDesigner dao = new QueryContractStageAuditDesigner();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseContractStageAuditDesigner.ALL_CAPTIONS);
			for(BaseContractStageAuditDesigner b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


