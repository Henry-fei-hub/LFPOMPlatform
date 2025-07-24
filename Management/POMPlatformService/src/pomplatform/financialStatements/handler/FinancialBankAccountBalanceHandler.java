package pomplatform.financialStatements.handler;

import org.apache.log4j.Logger;
import pomplatform.financialStatements.bean.BaseFinancialBankAccountBalance;
import pomplatform.financialStatements.bean.ConditionFinancialBankAccountBalance;
import pomplatform.financialStatements.query.QueryFinancialBankAccountBalance;
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

public class FinancialBankAccountBalanceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FinancialBankAccountBalanceHandler.class);

	public static BaseCollection<BaseFinancialBankAccountBalance> executeQueryFinancialBankAccountBalance(ConditionFinancialBankAccountBalance c, KeyValuePair[] replacements ) throws Exception {
		QueryFinancialBankAccountBalance dao = new QueryFinancialBankAccountBalance();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFinancialBankAccountBalance> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFinancialBankAccountBalance c = new ConditionFinancialBankAccountBalance();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFinancialBankAccountBalance> result = executeQueryFinancialBankAccountBalance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFinancialBankAccountBalance> result;
		ConditionFinancialBankAccountBalance c = new ConditionFinancialBankAccountBalance();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFinancialBankAccountBalance dao = new QueryFinancialBankAccountBalance();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFinancialBankAccountBalance.ALL_CAPTIONS);
			for(BaseFinancialBankAccountBalance b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


