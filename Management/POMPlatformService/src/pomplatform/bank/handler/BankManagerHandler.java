package pomplatform.bank.handler;

import org.apache.log4j.Logger;
import pomplatform.bank.bean.BaseBankManager;
import pomplatform.bank.bean.ConditionBankManager;
import pomplatform.bank.query.QueryBankManager;
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

public class BankManagerHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BankManagerHandler.class);

	public static BaseCollection<BaseBankManager> executeQueryBankManager(ConditionBankManager c, KeyValuePair[] replacements ) throws Exception {
		QueryBankManager dao = new QueryBankManager();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBankManager> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBankManager c = new ConditionBankManager();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBankManager> result = executeQueryBankManager(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBankManager> result;
		ConditionBankManager c = new ConditionBankManager();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBankManager dao = new QueryBankManager();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBankManager.ALL_CAPTIONS);
			for(BaseBankManager b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


