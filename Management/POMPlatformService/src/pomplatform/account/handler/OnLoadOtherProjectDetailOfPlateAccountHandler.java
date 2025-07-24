package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadOtherProjectDetailOfPlateAccount;
import pomplatform.account.bean.ConditionOnLoadOtherProjectDetailOfPlateAccount;
import pomplatform.account.query.QueryOnLoadOtherProjectDetailOfPlateAccount;
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

public class OnLoadOtherProjectDetailOfPlateAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadOtherProjectDetailOfPlateAccountHandler.class);

	public static BaseCollection<BaseOnLoadOtherProjectDetailOfPlateAccount> executeQueryOnLoadOtherProjectDetailOfPlateAccount(ConditionOnLoadOtherProjectDetailOfPlateAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadOtherProjectDetailOfPlateAccount dao = new QueryOnLoadOtherProjectDetailOfPlateAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadOtherProjectDetailOfPlateAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadOtherProjectDetailOfPlateAccount c = new ConditionOnLoadOtherProjectDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadOtherProjectDetailOfPlateAccount> result = executeQueryOnLoadOtherProjectDetailOfPlateAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadOtherProjectDetailOfPlateAccount> result;
		ConditionOnLoadOtherProjectDetailOfPlateAccount c = new ConditionOnLoadOtherProjectDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadOtherProjectDetailOfPlateAccount dao = new QueryOnLoadOtherProjectDetailOfPlateAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadOtherProjectDetailOfPlateAccount.ALL_CAPTIONS);
			for(BaseOnLoadOtherProjectDetailOfPlateAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


