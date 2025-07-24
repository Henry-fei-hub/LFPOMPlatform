package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadCommonTwoDetailOfPlateAccount;
import pomplatform.account.bean.ConditionOnLoadCommonTwoDetailOfPlateAccount;
import pomplatform.account.query.QueryOnLoadCommonTwoDetailOfPlateAccount;
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

public class OnLoadCommonTwoDetailOfPlateAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadCommonTwoDetailOfPlateAccountHandler.class);

	public static BaseCollection<BaseOnLoadCommonTwoDetailOfPlateAccount> executeQueryOnLoadCommonTwoDetailOfPlateAccount(ConditionOnLoadCommonTwoDetailOfPlateAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadCommonTwoDetailOfPlateAccount dao = new QueryOnLoadCommonTwoDetailOfPlateAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadCommonTwoDetailOfPlateAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadCommonTwoDetailOfPlateAccount c = new ConditionOnLoadCommonTwoDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadCommonTwoDetailOfPlateAccount> result = executeQueryOnLoadCommonTwoDetailOfPlateAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadCommonTwoDetailOfPlateAccount> result;
		ConditionOnLoadCommonTwoDetailOfPlateAccount c = new ConditionOnLoadCommonTwoDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadCommonTwoDetailOfPlateAccount dao = new QueryOnLoadCommonTwoDetailOfPlateAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadCommonTwoDetailOfPlateAccount.ALL_CAPTIONS);
			for(BaseOnLoadCommonTwoDetailOfPlateAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


