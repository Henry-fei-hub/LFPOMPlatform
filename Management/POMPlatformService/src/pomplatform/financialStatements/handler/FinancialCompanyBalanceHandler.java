package pomplatform.financialStatements.handler;

import org.apache.log4j.Logger;
import pomplatform.financialStatements.bean.BaseFinancialCompanyBalance;
import pomplatform.financialStatements.bean.ConditionFinancialCompanyBalance;
import pomplatform.financialStatements.query.QueryFinancialCompanyBalance;
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

public class FinancialCompanyBalanceHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FinancialCompanyBalanceHandler.class);

	public static BaseCollection<BaseFinancialCompanyBalance> executeQueryFinancialCompanyBalance(ConditionFinancialCompanyBalance c, KeyValuePair[] replacements ) throws Exception {
		QueryFinancialCompanyBalance dao = new QueryFinancialCompanyBalance();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFinancialCompanyBalance> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFinancialCompanyBalance c = new ConditionFinancialCompanyBalance();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFinancialCompanyBalance> result = executeQueryFinancialCompanyBalance(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFinancialCompanyBalance> result;
		ConditionFinancialCompanyBalance c = new ConditionFinancialCompanyBalance();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFinancialCompanyBalance dao = new QueryFinancialCompanyBalance();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFinancialCompanyBalance.ALL_CAPTIONS);
			for(BaseFinancialCompanyBalance b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


