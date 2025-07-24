package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnloadEmployeePaymentMonthDetail;
import pomplatform.payment.bean.ConditionOnloadEmployeePaymentMonthDetail;
import pomplatform.payment.query.QueryOnloadEmployeePaymentMonthDetail;
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

public class OnloadEmployeePaymentMonthDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnloadEmployeePaymentMonthDetailHandler.class);

	public static BaseCollection<BaseOnloadEmployeePaymentMonthDetail> executeQueryOnloadEmployeePaymentMonthDetail(ConditionOnloadEmployeePaymentMonthDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryOnloadEmployeePaymentMonthDetail dao = new QueryOnloadEmployeePaymentMonthDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnloadEmployeePaymentMonthDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnloadEmployeePaymentMonthDetail c = new ConditionOnloadEmployeePaymentMonthDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnloadEmployeePaymentMonthDetail> result = executeQueryOnloadEmployeePaymentMonthDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnloadEmployeePaymentMonthDetail> result;
		ConditionOnloadEmployeePaymentMonthDetail c = new ConditionOnloadEmployeePaymentMonthDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnloadEmployeePaymentMonthDetail dao = new QueryOnloadEmployeePaymentMonthDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnloadEmployeePaymentMonthDetail.DOWNLOAD_CAPTIONS);
			for(BaseOnloadEmployeePaymentMonthDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


