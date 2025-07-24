package pomplatform.OnLoadNewAccounts.handler;

import org.apache.log4j.Logger;
import pomplatform.OnLoadNewAccounts.bean.BaseOneNewAccountsTransationsInfo;
import pomplatform.OnLoadNewAccounts.bean.ConditionOneNewAccountsTransationsInfo;
import pomplatform.OnLoadNewAccounts.query.QueryOneNewAccountsTransationsInfo;
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

public class OneNewAccountsTransationsInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OneNewAccountsTransationsInfoHandler.class);

	public static BaseCollection<BaseOneNewAccountsTransationsInfo> executeQueryOneNewAccountsTransationsInfo(ConditionOneNewAccountsTransationsInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryOneNewAccountsTransationsInfo dao = new QueryOneNewAccountsTransationsInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOneNewAccountsTransationsInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOneNewAccountsTransationsInfo c = new ConditionOneNewAccountsTransationsInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOneNewAccountsTransationsInfo> result = executeQueryOneNewAccountsTransationsInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOneNewAccountsTransationsInfo> result;
		ConditionOneNewAccountsTransationsInfo c = new ConditionOneNewAccountsTransationsInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOneNewAccountsTransationsInfo dao = new QueryOneNewAccountsTransationsInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOneNewAccountsTransationsInfo.ALL_CAPTIONS);
			for(BaseOneNewAccountsTransationsInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


