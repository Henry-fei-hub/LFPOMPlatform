package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadIntegralReturnOfAccount;
import pomplatform.account.bean.ConditionOnLoadIntegralReturnOfAccount;
import pomplatform.account.query.QueryOnLoadIntegralReturnOfAccount;
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

public class OnLoadIntegralReturnOfAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadIntegralReturnOfAccountHandler.class);

	public static BaseCollection<BaseOnLoadIntegralReturnOfAccount> executeQueryOnLoadIntegralReturnOfAccount(ConditionOnLoadIntegralReturnOfAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadIntegralReturnOfAccount dao = new QueryOnLoadIntegralReturnOfAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadIntegralReturnOfAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadIntegralReturnOfAccount c = new ConditionOnLoadIntegralReturnOfAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadIntegralReturnOfAccount> result = executeQueryOnLoadIntegralReturnOfAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadIntegralReturnOfAccount> result;
		ConditionOnLoadIntegralReturnOfAccount c = new ConditionOnLoadIntegralReturnOfAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadIntegralReturnOfAccount dao = new QueryOnLoadIntegralReturnOfAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadIntegralReturnOfAccount.ALL_CAPTIONS);
			for(BaseOnLoadIntegralReturnOfAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


