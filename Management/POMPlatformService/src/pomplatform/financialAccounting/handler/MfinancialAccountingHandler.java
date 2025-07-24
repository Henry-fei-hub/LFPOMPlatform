package pomplatform.financialAccounting.handler;

import org.apache.log4j.Logger;
import pomplatform.financialAccounting.bean.BaseMfinancialAccounting;
import pomplatform.financialAccounting.bean.ConditionMfinancialAccounting;
import pomplatform.financialAccounting.query.QueryMfinancialAccounting;
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

public class MfinancialAccountingHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MfinancialAccountingHandler.class);

	public static BaseCollection<BaseMfinancialAccounting> executeQueryMfinancialAccounting(ConditionMfinancialAccounting c, KeyValuePair[] replacements ) throws Exception {
		QueryMfinancialAccounting dao = new QueryMfinancialAccounting();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMfinancialAccounting> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMfinancialAccounting c = new ConditionMfinancialAccounting();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMfinancialAccounting> result = executeQueryMfinancialAccounting(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMfinancialAccounting> result;
		ConditionMfinancialAccounting c = new ConditionMfinancialAccounting();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMfinancialAccounting dao = new QueryMfinancialAccounting();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMfinancialAccounting.ALL_CAPTIONS_1);
			for(BaseMfinancialAccounting b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


