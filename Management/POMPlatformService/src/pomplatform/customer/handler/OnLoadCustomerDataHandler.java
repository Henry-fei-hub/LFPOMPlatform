package pomplatform.customer.handler;

import org.apache.log4j.Logger;
import pomplatform.customer.bean.BaseOnLoadCustomerData;
import pomplatform.customer.bean.ConditionOnLoadCustomerData;
import pomplatform.customer.query.QueryOnLoadCustomerData;
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

public class OnLoadCustomerDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadCustomerDataHandler.class);

	public static BaseCollection<BaseOnLoadCustomerData> executeQueryOnLoadCustomerData(ConditionOnLoadCustomerData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadCustomerData dao = new QueryOnLoadCustomerData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadCustomerData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadCustomerData c = new ConditionOnLoadCustomerData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadCustomerData> result = executeQueryOnLoadCustomerData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadCustomerData> result;
		ConditionOnLoadCustomerData c = new ConditionOnLoadCustomerData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadCustomerData dao = new QueryOnLoadCustomerData();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadCustomerData.ALL_CAPTIONS);
			for(BaseOnLoadCustomerData b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


