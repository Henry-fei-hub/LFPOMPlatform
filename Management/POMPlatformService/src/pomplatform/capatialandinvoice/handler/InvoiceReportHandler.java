package pomplatform.capatialandinvoice.handler;

import org.apache.log4j.Logger;
import pomplatform.capatialandinvoice.bean.BaseInvoiceReport;
import pomplatform.capatialandinvoice.bean.ConditionInvoiceReport;
import pomplatform.capatialandinvoice.query.QueryInvoiceReport;
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

public class InvoiceReportHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(InvoiceReportHandler.class);

	public static BaseCollection<BaseInvoiceReport> executeQueryInvoiceReport(ConditionInvoiceReport c, KeyValuePair[] replacements ) throws Exception {
		QueryInvoiceReport dao = new QueryInvoiceReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseInvoiceReport> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionInvoiceReport c = new ConditionInvoiceReport();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseInvoiceReport> result = executeQueryInvoiceReport(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseInvoiceReport> result;
		ConditionInvoiceReport c = new ConditionInvoiceReport();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryInvoiceReport dao = new QueryInvoiceReport();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseInvoiceReport.ALL_CAPTIONS);
			for(BaseInvoiceReport b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


