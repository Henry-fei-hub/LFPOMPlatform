package pomplatform.attachment.handler;

import org.apache.log4j.Logger;
import pomplatform.attachment.bean.BaseOnAttachmentLinkInvoices;
import pomplatform.attachment.bean.ConditionOnAttachmentLinkInvoices;
import pomplatform.attachment.query.QueryOnAttachmentLinkInvoices;
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

public class OnAttachmentLinkInvoicesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnAttachmentLinkInvoicesHandler.class);

	public static BaseCollection<BaseOnAttachmentLinkInvoices> executeQueryOnAttachmentLinkInvoices(ConditionOnAttachmentLinkInvoices c, KeyValuePair[] replacements ) throws Exception {
		QueryOnAttachmentLinkInvoices dao = new QueryOnAttachmentLinkInvoices();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnAttachmentLinkInvoices> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnAttachmentLinkInvoices c = new ConditionOnAttachmentLinkInvoices();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnAttachmentLinkInvoices> result = executeQueryOnAttachmentLinkInvoices(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnAttachmentLinkInvoices> result;
		ConditionOnAttachmentLinkInvoices c = new ConditionOnAttachmentLinkInvoices();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnAttachmentLinkInvoices dao = new QueryOnAttachmentLinkInvoices();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnAttachmentLinkInvoices.ALL_CAPTIONS);
			for(BaseOnAttachmentLinkInvoices b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


