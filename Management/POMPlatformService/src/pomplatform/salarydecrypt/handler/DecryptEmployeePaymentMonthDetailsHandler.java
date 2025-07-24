package pomplatform.salarydecrypt.handler;

import org.apache.log4j.Logger;
import pomplatform.salarydecrypt.bean.BaseDecryptEmployeePaymentMonthDetails;
import pomplatform.salarydecrypt.bean.ConditionDecryptEmployeePaymentMonthDetails;
import pomplatform.salarydecrypt.query.QueryDecryptEmployeePaymentMonthDetails;
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

public class DecryptEmployeePaymentMonthDetailsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(DecryptEmployeePaymentMonthDetailsHandler.class);

	public static BaseCollection<BaseDecryptEmployeePaymentMonthDetails> executeQueryDecryptEmployeePaymentMonthDetails(ConditionDecryptEmployeePaymentMonthDetails c, KeyValuePair[] replacements ) throws Exception {
		QueryDecryptEmployeePaymentMonthDetails dao = new QueryDecryptEmployeePaymentMonthDetails();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseDecryptEmployeePaymentMonthDetails> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionDecryptEmployeePaymentMonthDetails c = new ConditionDecryptEmployeePaymentMonthDetails();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseDecryptEmployeePaymentMonthDetails> result = executeQueryDecryptEmployeePaymentMonthDetails(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseDecryptEmployeePaymentMonthDetails> result;
		ConditionDecryptEmployeePaymentMonthDetails c = new ConditionDecryptEmployeePaymentMonthDetails();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryDecryptEmployeePaymentMonthDetails dao = new QueryDecryptEmployeePaymentMonthDetails();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseDecryptEmployeePaymentMonthDetails.ALL_CAPTIONS);
			for(BaseDecryptEmployeePaymentMonthDetails b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


