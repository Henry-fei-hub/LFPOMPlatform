package pomplatform.financialStatements.handler;

import org.apache.log4j.Logger;
import pomplatform.financialStatements.bean.BaseFinancialSubjectMoney;
import pomplatform.financialStatements.bean.ConditionFinancialSubjectMoney;
import pomplatform.financialStatements.query.QueryFinancialSubjectMoney;
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

public class FinancialSubjectMoneyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FinancialSubjectMoneyHandler.class);

	public static BaseCollection<BaseFinancialSubjectMoney> executeQueryFinancialSubjectMoney(ConditionFinancialSubjectMoney c, KeyValuePair[] replacements ) throws Exception {
		QueryFinancialSubjectMoney dao = new QueryFinancialSubjectMoney();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFinancialSubjectMoney> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFinancialSubjectMoney c = new ConditionFinancialSubjectMoney();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFinancialSubjectMoney> result = executeQueryFinancialSubjectMoney(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFinancialSubjectMoney> result;
		ConditionFinancialSubjectMoney c = new ConditionFinancialSubjectMoney();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFinancialSubjectMoney dao = new QueryFinancialSubjectMoney();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFinancialSubjectMoney.ALL_CAPTIONS);
			for(BaseFinancialSubjectMoney b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


