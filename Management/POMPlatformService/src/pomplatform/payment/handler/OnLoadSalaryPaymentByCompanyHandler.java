package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnLoadSalaryPaymentByCompany;
import pomplatform.payment.bean.ConditionOnLoadSalaryPaymentByCompany;
import pomplatform.payment.query.QueryOnLoadSalaryPaymentByCompany;
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

public class OnLoadSalaryPaymentByCompanyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadSalaryPaymentByCompanyHandler.class);

	public static BaseCollection<BaseOnLoadSalaryPaymentByCompany> executeQueryOnLoadSalaryPaymentByCompany(ConditionOnLoadSalaryPaymentByCompany c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadSalaryPaymentByCompany dao = new QueryOnLoadSalaryPaymentByCompany();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadSalaryPaymentByCompany> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadSalaryPaymentByCompany c = new ConditionOnLoadSalaryPaymentByCompany();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadSalaryPaymentByCompany> result = executeQueryOnLoadSalaryPaymentByCompany(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadSalaryPaymentByCompany> result;
		ConditionOnLoadSalaryPaymentByCompany c = new ConditionOnLoadSalaryPaymentByCompany();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadSalaryPaymentByCompany dao = new QueryOnLoadSalaryPaymentByCompany();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadSalaryPaymentByCompany.ALL_CAPTIONS);
			for(BaseOnLoadSalaryPaymentByCompany b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


