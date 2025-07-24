package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadBusinessTypeDataOfAccount;
import pomplatform.account.bean.ConditionOnLoadBusinessTypeDataOfAccount;
import pomplatform.account.query.QueryOnLoadBusinessTypeDataOfAccount;
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

public class OnLoadBusinessTypeDataOfAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadBusinessTypeDataOfAccountHandler.class);

	public static BaseCollection<BaseOnLoadBusinessTypeDataOfAccount> executeQueryOnLoadBusinessTypeDataOfAccount(ConditionOnLoadBusinessTypeDataOfAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadBusinessTypeDataOfAccount dao = new QueryOnLoadBusinessTypeDataOfAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadBusinessTypeDataOfAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadBusinessTypeDataOfAccount c = new ConditionOnLoadBusinessTypeDataOfAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadBusinessTypeDataOfAccount> result = executeQueryOnLoadBusinessTypeDataOfAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadBusinessTypeDataOfAccount> result;
		ConditionOnLoadBusinessTypeDataOfAccount c = new ConditionOnLoadBusinessTypeDataOfAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadBusinessTypeDataOfAccount dao = new QueryOnLoadBusinessTypeDataOfAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadBusinessTypeDataOfAccount.ALL_CAPTIONS);
			for(BaseOnLoadBusinessTypeDataOfAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


