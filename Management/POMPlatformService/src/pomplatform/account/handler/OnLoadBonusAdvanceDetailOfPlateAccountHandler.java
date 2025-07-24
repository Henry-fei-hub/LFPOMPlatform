package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadBonusAdvanceDetailOfPlateAccount;
import pomplatform.account.bean.ConditionOnLoadBonusAdvanceDetailOfPlateAccount;
import pomplatform.account.query.QueryOnLoadBonusAdvanceDetailOfPlateAccount;
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

public class OnLoadBonusAdvanceDetailOfPlateAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadBonusAdvanceDetailOfPlateAccountHandler.class);

	public static BaseCollection<BaseOnLoadBonusAdvanceDetailOfPlateAccount> executeQueryOnLoadBonusAdvanceDetailOfPlateAccount(ConditionOnLoadBonusAdvanceDetailOfPlateAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadBonusAdvanceDetailOfPlateAccount dao = new QueryOnLoadBonusAdvanceDetailOfPlateAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadBonusAdvanceDetailOfPlateAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadBonusAdvanceDetailOfPlateAccount c = new ConditionOnLoadBonusAdvanceDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadBonusAdvanceDetailOfPlateAccount> result = executeQueryOnLoadBonusAdvanceDetailOfPlateAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadBonusAdvanceDetailOfPlateAccount> result;
		ConditionOnLoadBonusAdvanceDetailOfPlateAccount c = new ConditionOnLoadBonusAdvanceDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadBonusAdvanceDetailOfPlateAccount dao = new QueryOnLoadBonusAdvanceDetailOfPlateAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadBonusAdvanceDetailOfPlateAccount.ALL_CAPTIONS);
			for(BaseOnLoadBonusAdvanceDetailOfPlateAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


