package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadEmployeeAccountData;
import pomplatform.account.bean.ConditionOnLoadEmployeeAccountData;
import pomplatform.account.query.QueryOnLoadEmployeeAccountData;
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

public class OnLoadEmployeeAccountDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadEmployeeAccountDataHandler.class);

	public static BaseCollection<BaseOnLoadEmployeeAccountData> executeQueryOnLoadEmployeeAccountData(ConditionOnLoadEmployeeAccountData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadEmployeeAccountData dao = new QueryOnLoadEmployeeAccountData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadEmployeeAccountData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadEmployeeAccountData c = new ConditionOnLoadEmployeeAccountData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadEmployeeAccountData> result = executeQueryOnLoadEmployeeAccountData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadEmployeeAccountData> result;
		ConditionOnLoadEmployeeAccountData c = new ConditionOnLoadEmployeeAccountData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadEmployeeAccountData dao = new QueryOnLoadEmployeeAccountData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadEmployeeAccountData.ALL_CAPTIONS);
			for(BaseOnLoadEmployeeAccountData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


