package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadProjectAdvanceDetailOfPlateAccount;
import pomplatform.account.bean.ConditionOnLoadProjectAdvanceDetailOfPlateAccount;
import pomplatform.account.query.QueryOnLoadProjectAdvanceDetailOfPlateAccount;
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

public class OnLoadProjectAdvanceDetailOfPlateAccountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadProjectAdvanceDetailOfPlateAccountHandler.class);

	public static BaseCollection<BaseOnLoadProjectAdvanceDetailOfPlateAccount> executeQueryOnLoadProjectAdvanceDetailOfPlateAccount(ConditionOnLoadProjectAdvanceDetailOfPlateAccount c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadProjectAdvanceDetailOfPlateAccount dao = new QueryOnLoadProjectAdvanceDetailOfPlateAccount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadProjectAdvanceDetailOfPlateAccount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadProjectAdvanceDetailOfPlateAccount c = new ConditionOnLoadProjectAdvanceDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadProjectAdvanceDetailOfPlateAccount> result = executeQueryOnLoadProjectAdvanceDetailOfPlateAccount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadProjectAdvanceDetailOfPlateAccount> result;
		ConditionOnLoadProjectAdvanceDetailOfPlateAccount c = new ConditionOnLoadProjectAdvanceDetailOfPlateAccount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadProjectAdvanceDetailOfPlateAccount dao = new QueryOnLoadProjectAdvanceDetailOfPlateAccount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadProjectAdvanceDetailOfPlateAccount.ALL_CAPTIONS);
			for(BaseOnLoadProjectAdvanceDetailOfPlateAccount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


