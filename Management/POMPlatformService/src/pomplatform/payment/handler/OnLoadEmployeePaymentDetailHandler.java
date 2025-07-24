package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnLoadEmployeePaymentDetail;
import pomplatform.payment.bean.ConditionOnLoadEmployeePaymentDetail;
import pomplatform.payment.query.QueryOnLoadEmployeePaymentDetail;
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

public class OnLoadEmployeePaymentDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadEmployeePaymentDetailHandler.class);

	public static BaseCollection<BaseOnLoadEmployeePaymentDetail> executeQueryOnLoadEmployeePaymentDetail(ConditionOnLoadEmployeePaymentDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadEmployeePaymentDetail dao = new QueryOnLoadEmployeePaymentDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadEmployeePaymentDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadEmployeePaymentDetail c = new ConditionOnLoadEmployeePaymentDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadEmployeePaymentDetail> result = executeQueryOnLoadEmployeePaymentDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadEmployeePaymentDetail> result;
		ConditionOnLoadEmployeePaymentDetail c = new ConditionOnLoadEmployeePaymentDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadEmployeePaymentDetail dao = new QueryOnLoadEmployeePaymentDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadEmployeePaymentDetail.ALL_CAPTIONS);
			for(BaseOnLoadEmployeePaymentDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


