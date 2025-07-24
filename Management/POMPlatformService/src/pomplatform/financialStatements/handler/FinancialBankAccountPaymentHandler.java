package pomplatform.financialStatements.handler;

import org.apache.log4j.Logger;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountPayment;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountPayment;
import pomplatform.financialStatements.query.QueryFinancialBankAccountPayment;
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

public class FinancialBankAccountPaymentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FinancialBankAccountPaymentHandler.class);

	public static BaseCollection<BaseFinancialBankAccountPayment> executeQueryFinancialBankAccountPayment(ConditionFinancialBankAccountPayment c, KeyValuePair[] replacements ) throws Exception {
		QueryFinancialBankAccountPayment dao = new QueryFinancialBankAccountPayment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFinancialBankAccountPayment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFinancialBankAccountPayment c = new ConditionFinancialBankAccountPayment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFinancialBankAccountPayment> result = executeQueryFinancialBankAccountPayment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFinancialBankAccountPayment> result;
		ConditionFinancialBankAccountPayment c = new ConditionFinancialBankAccountPayment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFinancialBankAccountPayment dao = new QueryFinancialBankAccountPayment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFinancialBankAccountPayment.ALL_CAPTIONS);
			for(BaseFinancialBankAccountPayment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


