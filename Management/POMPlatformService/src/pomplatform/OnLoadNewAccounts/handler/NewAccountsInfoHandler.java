package pomplatform.OnLoadNewAccounts.handler;

import org.apache.log4j.Logger;
import pomplatform.OnLoadNewAccounts.bean.BaseNewAccountsInfo;
import pomplatform.OnLoadNewAccounts.bean.ConditionNewAccountsInfo;
import pomplatform.OnLoadNewAccounts.query.QueryNewAccountsInfo;
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

public class NewAccountsInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NewAccountsInfoHandler.class);

	public static BaseCollection<BaseNewAccountsInfo> executeQueryNewAccountsInfo(ConditionNewAccountsInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryNewAccountsInfo dao = new QueryNewAccountsInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNewAccountsInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNewAccountsInfo c = new ConditionNewAccountsInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNewAccountsInfo> result = executeQueryNewAccountsInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNewAccountsInfo> result;
		ConditionNewAccountsInfo c = new ConditionNewAccountsInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNewAccountsInfo dao = new QueryNewAccountsInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNewAccountsInfo.ALL_CAPTIONS);
			for(BaseNewAccountsInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


