package pomplatform.k3code.handler;

import org.apache.log4j.Logger;
import pomplatform.k3code.bean.BaseCustomerK3Code;
import pomplatform.k3code.bean.ConditionCustomerK3Code;
import pomplatform.k3code.query.QueryCustomerK3Code;
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

public class CustomerK3CodeHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CustomerK3CodeHandler.class);

	public static BaseCollection<BaseCustomerK3Code> executeQueryCustomerK3Code(ConditionCustomerK3Code c, KeyValuePair[] replacements ) throws Exception {
		QueryCustomerK3Code dao = new QueryCustomerK3Code();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCustomerK3Code> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCustomerK3Code c = new ConditionCustomerK3Code();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCustomerK3Code> result = executeQueryCustomerK3Code(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCustomerK3Code> result;
		ConditionCustomerK3Code c = new ConditionCustomerK3Code();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCustomerK3Code dao = new QueryCustomerK3Code();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCustomerK3Code.ALL_CAPTIONS);
			for(BaseCustomerK3Code b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


