package pomplatform.attachment.handler;

import org.apache.log4j.Logger;
import pomplatform.attachment.bean.BaseOnUpdateAttachmentLinkInvoiceApplys;
import pomplatform.attachment.bean.ConditionOnUpdateAttachmentLinkInvoiceApplys;
import pomplatform.attachment.query.QueryOnUpdateAttachmentLinkInvoiceApplys;
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

public class OnUpdateAttachmentLinkInvoiceApplysHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnUpdateAttachmentLinkInvoiceApplysHandler.class);

	public static BaseCollection<BaseOnUpdateAttachmentLinkInvoiceApplys> executeQueryOnUpdateAttachmentLinkInvoiceApplys(ConditionOnUpdateAttachmentLinkInvoiceApplys c, KeyValuePair[] replacements ) throws Exception {
		QueryOnUpdateAttachmentLinkInvoiceApplys dao = new QueryOnUpdateAttachmentLinkInvoiceApplys();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnUpdateAttachmentLinkInvoiceApplys> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnUpdateAttachmentLinkInvoiceApplys c = new ConditionOnUpdateAttachmentLinkInvoiceApplys();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnUpdateAttachmentLinkInvoiceApplys> result = executeQueryOnUpdateAttachmentLinkInvoiceApplys(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnUpdateAttachmentLinkInvoiceApplys> result;
		ConditionOnUpdateAttachmentLinkInvoiceApplys c = new ConditionOnUpdateAttachmentLinkInvoiceApplys();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnUpdateAttachmentLinkInvoiceApplys dao = new QueryOnUpdateAttachmentLinkInvoiceApplys();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnUpdateAttachmentLinkInvoiceApplys.ALL_CAPTIONS);
			for(BaseOnUpdateAttachmentLinkInvoiceApplys b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


