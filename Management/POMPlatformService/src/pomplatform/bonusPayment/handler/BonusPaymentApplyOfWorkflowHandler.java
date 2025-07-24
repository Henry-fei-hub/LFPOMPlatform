package pomplatform.bonusPayment.handler;

import org.apache.log4j.Logger;
import pomplatform.bonusPayment.bean.BaseBonusPaymentApplyOfWorkflow;
import pomplatform.bonusPayment.bean.ConditionBonusPaymentApplyOfWorkflow;
import pomplatform.bonusPayment.query.QueryBonusPaymentApplyOfWorkflow;
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

public class BonusPaymentApplyOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BonusPaymentApplyOfWorkflowHandler.class);

	public static BaseCollection<BaseBonusPaymentApplyOfWorkflow> executeQueryBonusPaymentApplyOfWorkflow(ConditionBonusPaymentApplyOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QueryBonusPaymentApplyOfWorkflow dao = new QueryBonusPaymentApplyOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBonusPaymentApplyOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBonusPaymentApplyOfWorkflow c = new ConditionBonusPaymentApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBonusPaymentApplyOfWorkflow> result = executeQueryBonusPaymentApplyOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBonusPaymentApplyOfWorkflow> result;
		ConditionBonusPaymentApplyOfWorkflow c = new ConditionBonusPaymentApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBonusPaymentApplyOfWorkflow dao = new QueryBonusPaymentApplyOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBonusPaymentApplyOfWorkflow.ALL_CAPTIONS);
			for(BaseBonusPaymentApplyOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


