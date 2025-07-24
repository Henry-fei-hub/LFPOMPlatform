package pomplatform.capatialandinvoice.handler;

import org.apache.log4j.Logger;
import pomplatform.capatialandinvoice.bean.BaseInvoiceReportDetail;
import pomplatform.capatialandinvoice.bean.ConditionInvoiceReportDetail;
import pomplatform.capatialandinvoice.query.QueryInvoiceReportDetail;
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

public class InvoiceReportDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(InvoiceReportDetailHandler.class);

	public static BaseCollection<BaseInvoiceReportDetail> executeQueryInvoiceReportDetail(ConditionInvoiceReportDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryInvoiceReportDetail dao = new QueryInvoiceReportDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseInvoiceReportDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionInvoiceReportDetail c = new ConditionInvoiceReportDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseInvoiceReportDetail> result = executeQueryInvoiceReportDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseInvoiceReportDetail> result;
		ConditionInvoiceReportDetail c = new ConditionInvoiceReportDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryInvoiceReportDetail dao = new QueryInvoiceReportDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseInvoiceReportDetail.EXPORT_CAPITIONS);
			for(BaseInvoiceReportDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


