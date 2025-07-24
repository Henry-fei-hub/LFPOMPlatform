package pomplatform.financialStatements.handler;

import org.apache.log4j.Logger;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountInternalPayment;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountInternalPayment;
import pomplatform.financialStatements.query.QueryFinancialBankAccountInternalPayment;
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

public class FinancialBankAccountInternalPaymentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FinancialBankAccountInternalPaymentHandler.class);

	public static BaseCollection<BaseFinancialBankAccountInternalPayment> executeQueryFinancialBankAccountInternalPayment(ConditionFinancialBankAccountInternalPayment c, KeyValuePair[] replacements ) throws Exception {
		QueryFinancialBankAccountInternalPayment dao = new QueryFinancialBankAccountInternalPayment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFinancialBankAccountInternalPayment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFinancialBankAccountInternalPayment c = new ConditionFinancialBankAccountInternalPayment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFinancialBankAccountInternalPayment> result = executeQueryFinancialBankAccountInternalPayment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFinancialBankAccountInternalPayment> result;
		ConditionFinancialBankAccountInternalPayment c = new ConditionFinancialBankAccountInternalPayment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFinancialBankAccountInternalPayment dao = new QueryFinancialBankAccountInternalPayment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFinancialBankAccountInternalPayment.ALL_CAPTIONS);
			for(BaseFinancialBankAccountInternalPayment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


