package pomplatform.reimbursementpackage.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursementpackage.bean.BaseSalarySendDataPay;
import pomplatform.reimbursementpackage.bean.ConditionSalarySendDataPay;
import pomplatform.reimbursementpackage.query.QuerySalarySendDataPay;
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

public class SalarySendDataPayHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SalarySendDataPayHandler.class);

	public static BaseCollection<BaseSalarySendDataPay> executeQuerySalarySendDataPay(ConditionSalarySendDataPay c, KeyValuePair[] replacements ) throws Exception {
		QuerySalarySendDataPay dao = new QuerySalarySendDataPay();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSalarySendDataPay> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSalarySendDataPay c = new ConditionSalarySendDataPay();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSalarySendDataPay> result = executeQuerySalarySendDataPay(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSalarySendDataPay> result;
		ConditionSalarySendDataPay c = new ConditionSalarySendDataPay();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySalarySendDataPay dao = new QuerySalarySendDataPay();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSalarySendDataPay.ALL_CAPTIONS);
			for(BaseSalarySendDataPay b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


