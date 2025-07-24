package pomplatform.payment.handler;

import org.apache.log4j.Logger;
import pomplatform.payment.bean.BaseOnLoadShiftAndDayPayment;
import pomplatform.payment.bean.ConditionOnLoadShiftAndDayPayment;
import pomplatform.payment.query.QueryOnLoadShiftAndDayPayment;
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

public class OnLoadShiftAndDayPaymentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadShiftAndDayPaymentHandler.class);

	public static BaseCollection<BaseOnLoadShiftAndDayPayment> executeQueryOnLoadShiftAndDayPayment(ConditionOnLoadShiftAndDayPayment c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadShiftAndDayPayment dao = new QueryOnLoadShiftAndDayPayment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadShiftAndDayPayment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadShiftAndDayPayment c = new ConditionOnLoadShiftAndDayPayment();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadShiftAndDayPayment> result = executeQueryOnLoadShiftAndDayPayment(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadShiftAndDayPayment> result;
		ConditionOnLoadShiftAndDayPayment c = new ConditionOnLoadShiftAndDayPayment();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadShiftAndDayPayment dao = new QueryOnLoadShiftAndDayPayment();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadShiftAndDayPayment.ALL_CAPTIONS);
			for(BaseOnLoadShiftAndDayPayment b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


