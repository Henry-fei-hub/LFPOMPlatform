package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadProjectSettlementDetailOfPlateAccount;
import pomplatform.account.bean.ConditionOnLoadProjectSettlementDetailOfPlateAccount;
import pomplatform.account.query.QueryOnLoadProjectSettlementDetailOfPlateAccount;
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

public class OnLoadProjectSettlementDetailOfPlateAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectSettlementDetailOfPlateAccountHandler.class);

	public static BaseCollection<BaseOnLoadProjectSettlementDetailOfPlateAccount> executeQueryOnLoadProjectSettlementDetailOfPlateAccount(ConditionOnLoadProjectSettlementDetailOfPlateAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectSettlementDetailOfPlateAccount dao = new QueryOnLoadProjectSettlementDetailOfPlateAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectSettlementDetailOfPlateAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectSettlementDetailOfPlateAccount c = new ConditionOnLoadProjectSettlementDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectSettlementDetailOfPlateAccount> result = executeQueryOnLoadProjectSettlementDetailOfPlateAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectSettlementDetailOfPlateAccount> result;
		ConditionOnLoadProjectSettlementDetailOfPlateAccount c = new ConditionOnLoadProjectSettlementDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectSettlementDetailOfPlateAccount dao = new QueryOnLoadProjectSettlementDetailOfPlateAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectSettlementDetailOfPlateAccount.ALL_CAPTIONS);
			for(BaseOnLoadProjectSettlementDetailOfPlateAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


