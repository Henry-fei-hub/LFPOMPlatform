package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseSendIntegralOfEmpPaymentDetail;
import pomplatform.payment.bean.ConditionSendIntegralOfEmpPaymentDetail;
import pomplatform.payment.query.QuerySendIntegralOfEmpPaymentDetail;
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

public class SendIntegralOfEmpPaymentDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SendIntegralOfEmpPaymentDetailHandler.class);

	public static BaseCollection<BaseSendIntegralOfEmpPaymentDetail> executeQuerySendIntegralOfEmpPaymentDetail(ConditionSendIntegralOfEmpPaymentDetail c, KeyValuePair[] replacements ) throws Exception {
		QuerySendIntegralOfEmpPaymentDetail dao = new QuerySendIntegralOfEmpPaymentDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSendIntegralOfEmpPaymentDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSendIntegralOfEmpPaymentDetail c = new ConditionSendIntegralOfEmpPaymentDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSendIntegralOfEmpPaymentDetail> result = executeQuerySendIntegralOfEmpPaymentDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSendIntegralOfEmpPaymentDetail> result;
		ConditionSendIntegralOfEmpPaymentDetail c = new ConditionSendIntegralOfEmpPaymentDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySendIntegralOfEmpPaymentDetail dao = new QuerySendIntegralOfEmpPaymentDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSendIntegralOfEmpPaymentDetail.ALL_CAPTIONS);
			for(BaseSendIntegralOfEmpPaymentDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


