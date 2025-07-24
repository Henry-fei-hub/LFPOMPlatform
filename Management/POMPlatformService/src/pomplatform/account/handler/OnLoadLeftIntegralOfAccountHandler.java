package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadLeftIntegralOfAccount;
import pomplatform.account.bean.ConditionOnLoadLeftIntegralOfAccount;
import pomplatform.account.query.QueryOnLoadLeftIntegralOfAccount;
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

public class OnLoadLeftIntegralOfAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadLeftIntegralOfAccountHandler.class);

	public static BaseCollection<BaseOnLoadLeftIntegralOfAccount> executeQueryOnLoadLeftIntegralOfAccount(ConditionOnLoadLeftIntegralOfAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadLeftIntegralOfAccount dao = new QueryOnLoadLeftIntegralOfAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadLeftIntegralOfAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadLeftIntegralOfAccount c = new ConditionOnLoadLeftIntegralOfAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadLeftIntegralOfAccount> result = executeQueryOnLoadLeftIntegralOfAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadLeftIntegralOfAccount> result;
		ConditionOnLoadLeftIntegralOfAccount c = new ConditionOnLoadLeftIntegralOfAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadLeftIntegralOfAccount dao = new QueryOnLoadLeftIntegralOfAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadLeftIntegralOfAccount.ALL_CAPTIONS);
			for(BaseOnLoadLeftIntegralOfAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


