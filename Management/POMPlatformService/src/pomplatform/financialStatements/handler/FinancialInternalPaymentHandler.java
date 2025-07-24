package pomplatform.financialStatements.handler;

import org.apache.log4j.Logger;
import pomplatform.financialStatements.bean.BaseFinancialInternalPayment;
import pomplatform.financialStatements.bean.ConditionFinancialInternalPayment;
import pomplatform.financialStatements.query.QueryFinancialInternalPayment;
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

public class FinancialInternalPaymentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FinancialInternalPaymentHandler.class);

	public static BaseCollection<BaseFinancialInternalPayment> executeQueryFinancialInternalPayment(ConditionFinancialInternalPayment c, KeyValuePair[] replacements ) throws Exception {
		QueryFinancialInternalPayment dao = new QueryFinancialInternalPayment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFinancialInternalPayment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFinancialInternalPayment c = new ConditionFinancialInternalPayment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFinancialInternalPayment> result = executeQueryFinancialInternalPayment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFinancialInternalPayment> result;
		ConditionFinancialInternalPayment c = new ConditionFinancialInternalPayment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFinancialInternalPayment dao = new QueryFinancialInternalPayment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFinancialInternalPayment.ALL_CAPTIONS);
			for(BaseFinancialInternalPayment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


