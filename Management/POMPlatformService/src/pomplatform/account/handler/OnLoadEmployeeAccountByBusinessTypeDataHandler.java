package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseOnLoadEmployeeAccountByBusinessTypeData;
import pomplatform.account.bean.ConditionOnLoadEmployeeAccountByBusinessTypeData;
import pomplatform.account.query.QueryOnLoadEmployeeAccountByBusinessTypeData;
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

public class OnLoadEmployeeAccountByBusinessTypeDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadEmployeeAccountByBusinessTypeDataHandler.class);

	public static BaseCollection<BaseOnLoadEmployeeAccountByBusinessTypeData> executeQueryOnLoadEmployeeAccountByBusinessTypeData(ConditionOnLoadEmployeeAccountByBusinessTypeData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadEmployeeAccountByBusinessTypeData dao = new QueryOnLoadEmployeeAccountByBusinessTypeData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadEmployeeAccountByBusinessTypeData> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadEmployeeAccountByBusinessTypeData c = new ConditionOnLoadEmployeeAccountByBusinessTypeData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadEmployeeAccountByBusinessTypeData> result = executeQueryOnLoadEmployeeAccountByBusinessTypeData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadEmployeeAccountByBusinessTypeData> result;
		ConditionOnLoadEmployeeAccountByBusinessTypeData c = new ConditionOnLoadEmployeeAccountByBusinessTypeData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadEmployeeAccountByBusinessTypeData dao = new QueryOnLoadEmployeeAccountByBusinessTypeData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadEmployeeAccountByBusinessTypeData.ALL_CAPTIONS);
			for(BaseOnLoadEmployeeAccountByBusinessTypeData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


