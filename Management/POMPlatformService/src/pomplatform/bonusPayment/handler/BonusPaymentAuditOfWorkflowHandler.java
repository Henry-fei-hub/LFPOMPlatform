package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BaseBonusPaymentAuditOfWorkflow;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentAuditOfWorkflow;
import pomplatform.bonusPayment.query.QueryBonusPaymentAuditOfWorkflow;
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

public class BonusPaymentAuditOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BonusPaymentAuditOfWorkflowHandler.class);

	public static BaseCollection<BaseBonusPaymentAuditOfWorkflow> executeQueryBonusPaymentAuditOfWorkflow(ConditionBonusPaymentAuditOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryBonusPaymentAuditOfWorkflow dao = new QueryBonusPaymentAuditOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBonusPaymentAuditOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBonusPaymentAuditOfWorkflow c = new ConditionBonusPaymentAuditOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBonusPaymentAuditOfWorkflow> result = executeQueryBonusPaymentAuditOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBonusPaymentAuditOfWorkflow> result;
		ConditionBonusPaymentAuditOfWorkflow c = new ConditionBonusPaymentAuditOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBonusPaymentAuditOfWorkflow dao = new QueryBonusPaymentAuditOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBonusPaymentAuditOfWorkflow.ALL_CAPTIONS);
			for(BaseBonusPaymentAuditOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


