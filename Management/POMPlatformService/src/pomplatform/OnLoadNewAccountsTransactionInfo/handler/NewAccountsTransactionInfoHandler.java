package pomplatform.OnLoadNewAccountsTransactionInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.OnLoadNewAccountsTransactionInfo.bean.BaseNewAccountsTransactionInfo;
import pomplatform.OnLoadNewAccountsTransactionInfo.bean.ConditionNewAccountsTransactionInfo;
import pomplatform.OnLoadNewAccountsTransactionInfo.query.QueryNewAccountsTransactionInfo;
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

public class NewAccountsTransactionInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NewAccountsTransactionInfoHandler.class);

	public static BaseCollection<BaseNewAccountsTransactionInfo> executeQueryNewAccountsTransactionInfo(ConditionNewAccountsTransactionInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryNewAccountsTransactionInfo dao = new QueryNewAccountsTransactionInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNewAccountsTransactionInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNewAccountsTransactionInfo c = new ConditionNewAccountsTransactionInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNewAccountsTransactionInfo> result = executeQueryNewAccountsTransactionInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNewAccountsTransactionInfo> result;
		ConditionNewAccountsTransactionInfo c = new ConditionNewAccountsTransactionInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNewAccountsTransactionInfo dao = new QueryNewAccountsTransactionInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNewAccountsTransactionInfo.ALL_CAPTIONS);
			for(BaseNewAccountsTransactionInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


