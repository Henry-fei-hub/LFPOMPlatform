package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BaseBonusPaymentAttentionOfWorkflow;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentAttentionOfWorkflow;
import pomplatform.bonusPayment.query.QueryBonusPaymentAttentionOfWorkflow;
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

public class BonusPaymentAttentionOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BonusPaymentAttentionOfWorkflowHandler.class);

	public static BaseCollection<BaseBonusPaymentAttentionOfWorkflow> executeQueryBonusPaymentAttentionOfWorkflow(ConditionBonusPaymentAttentionOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryBonusPaymentAttentionOfWorkflow dao = new QueryBonusPaymentAttentionOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBonusPaymentAttentionOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBonusPaymentAttentionOfWorkflow c = new ConditionBonusPaymentAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBonusPaymentAttentionOfWorkflow> result = executeQueryBonusPaymentAttentionOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBonusPaymentAttentionOfWorkflow> result;
		ConditionBonusPaymentAttentionOfWorkflow c = new ConditionBonusPaymentAttentionOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBonusPaymentAttentionOfWorkflow dao = new QueryBonusPaymentAttentionOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBonusPaymentAttentionOfWorkflow.ALL_CAPTIONS);
			for(BaseBonusPaymentAttentionOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


