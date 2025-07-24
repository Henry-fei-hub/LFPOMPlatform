package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadPlateDataOfAccount;
import pomplatform.account.bean.ConditionOnLoadPlateDataOfAccount;
import pomplatform.account.query.QueryOnLoadPlateDataOfAccount;
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

public class OnLoadPlateDataOfAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadPlateDataOfAccountHandler.class);

	public static BaseCollection<BaseOnLoadPlateDataOfAccount> executeQueryOnLoadPlateDataOfAccount(ConditionOnLoadPlateDataOfAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadPlateDataOfAccount dao = new QueryOnLoadPlateDataOfAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadPlateDataOfAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadPlateDataOfAccount c = new ConditionOnLoadPlateDataOfAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadPlateDataOfAccount> result = executeQueryOnLoadPlateDataOfAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadPlateDataOfAccount> result;
		ConditionOnLoadPlateDataOfAccount c = new ConditionOnLoadPlateDataOfAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadPlateDataOfAccount dao = new QueryOnLoadPlateDataOfAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadPlateDataOfAccount.ALL_CAPTIONS);
			for(BaseOnLoadPlateDataOfAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


