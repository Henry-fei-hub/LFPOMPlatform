package pomplatform.invoice.handler;

import org.apache.log4j.Logger;
import pomplatform.invoice.bean.BaseInvoiceVoucher;
import pomplatform.invoice.bean.ConditionInvoiceVoucher;
import pomplatform.invoice.query.QueryInvoiceVoucher;
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

public class InvoiceVoucherHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(InvoiceVoucherHandler.class);

	public static BaseCollection<BaseInvoiceVoucher> executeQueryInvoiceVoucher(ConditionInvoiceVoucher c, KeyValuePair[] replacements ) throws Exception {
		QueryInvoiceVoucher dao = new QueryInvoiceVoucher();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseInvoiceVoucher> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionInvoiceVoucher c = new ConditionInvoiceVoucher();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseInvoiceVoucher> result = executeQueryInvoiceVoucher(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseInvoiceVoucher> result;
		ConditionInvoiceVoucher c = new ConditionInvoiceVoucher();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryInvoiceVoucher dao = new QueryInvoiceVoucher();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseInvoiceVoucher.ALL_CAPTIONS);
			for(BaseInvoiceVoucher b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


