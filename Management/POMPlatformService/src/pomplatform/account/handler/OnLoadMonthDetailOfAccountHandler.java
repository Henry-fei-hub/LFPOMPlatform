package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadMonthDetailOfAccount;
import pomplatform.account.bean.ConditionOnLoadMonthDetailOfAccount;
import pomplatform.account.query.QueryOnLoadMonthDetailOfAccount;
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

public class OnLoadMonthDetailOfAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadMonthDetailOfAccountHandler.class);

	public static BaseCollection<BaseOnLoadMonthDetailOfAccount> executeQueryOnLoadMonthDetailOfAccount(ConditionOnLoadMonthDetailOfAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadMonthDetailOfAccount dao = new QueryOnLoadMonthDetailOfAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadMonthDetailOfAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadMonthDetailOfAccount c = new ConditionOnLoadMonthDetailOfAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadMonthDetailOfAccount> result = executeQueryOnLoadMonthDetailOfAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadMonthDetailOfAccount> result;
		ConditionOnLoadMonthDetailOfAccount c = new ConditionOnLoadMonthDetailOfAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadMonthDetailOfAccount dao = new QueryOnLoadMonthDetailOfAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadMonthDetailOfAccount.ALL_CAPTIONS);
			for(BaseOnLoadMonthDetailOfAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


