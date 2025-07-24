package pomplatform.reimbursementpackage.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursementpackage.bean.BaseMCmbcPaymentDetailpor;
import pomplatform.reimbursementpackage.bean.ConditionMCmbcPaymentDetailpor;
import pomplatform.reimbursementpackage.query.QueryMCmbcPaymentDetailpor;
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

public class MCmbcPaymentDetailporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MCmbcPaymentDetailporHandler.class);

	public static BaseCollection<BaseMCmbcPaymentDetailpor> executeQueryMCmbcPaymentDetailpor(ConditionMCmbcPaymentDetailpor c, KeyValuePair[] replacements ) throws Exception {
		QueryMCmbcPaymentDetailpor dao = new QueryMCmbcPaymentDetailpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMCmbcPaymentDetailpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMCmbcPaymentDetailpor c = new ConditionMCmbcPaymentDetailpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMCmbcPaymentDetailpor> result = executeQueryMCmbcPaymentDetailpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMCmbcPaymentDetailpor> result;
		ConditionMCmbcPaymentDetailpor c = new ConditionMCmbcPaymentDetailpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMCmbcPaymentDetailpor dao = new QueryMCmbcPaymentDetailpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMCmbcPaymentDetailpor.ALL_CAPTIONS);
			for(BaseMCmbcPaymentDetailpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


