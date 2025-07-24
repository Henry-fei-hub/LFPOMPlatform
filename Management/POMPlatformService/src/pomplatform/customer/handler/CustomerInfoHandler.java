package pomplatform.customer.handler;

import org.apache.log4j.Logger;
import pomplatform.customer.bean.BaseCustomerInfo;
import pomplatform.customer.bean.ConditionCustomerInfo;
import pomplatform.customer.query.QueryCustomerInfo;
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

public class CustomerInfoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CustomerInfoHandler.class);

	public static BaseCollection<BaseCustomerInfo> executeQueryCustomerInfo(ConditionCustomerInfo c, KeyValuePair[] replacements ) throws Exception {
		QueryCustomerInfo dao = new QueryCustomerInfo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCustomerInfo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCustomerInfo c = new ConditionCustomerInfo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCustomerInfo> result = executeQueryCustomerInfo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCustomerInfo> result;
		ConditionCustomerInfo c = new ConditionCustomerInfo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCustomerInfo dao = new QueryCustomerInfo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCustomerInfo.ALL_CAPTIONS);
			for(BaseCustomerInfo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


