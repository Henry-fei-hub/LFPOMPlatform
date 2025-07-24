package pomplatform.attachment.handler;

import org.apache.log4j.Logger;
import pomplatform.attachment.bean.BaseOnAttachmentLinkContractReceivables;
import pomplatform.attachment.bean.ConditionOnAttachmentLinkContractReceivables;
import pomplatform.attachment.query.QueryOnAttachmentLinkContractReceivables;
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

public class OnAttachmentLinkContractReceivablesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnAttachmentLinkContractReceivablesHandler.class);

	public static BaseCollection<BaseOnAttachmentLinkContractReceivables> executeQueryOnAttachmentLinkContractReceivables(ConditionOnAttachmentLinkContractReceivables c, KeyValuePair[] replacements ) throws Exception {
		QueryOnAttachmentLinkContractReceivables dao = new QueryOnAttachmentLinkContractReceivables();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnAttachmentLinkContractReceivables> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnAttachmentLinkContractReceivables c = new ConditionOnAttachmentLinkContractReceivables();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnAttachmentLinkContractReceivables> result = executeQueryOnAttachmentLinkContractReceivables(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnAttachmentLinkContractReceivables> result;
		ConditionOnAttachmentLinkContractReceivables c = new ConditionOnAttachmentLinkContractReceivables();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnAttachmentLinkContractReceivables dao = new QueryOnAttachmentLinkContractReceivables();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnAttachmentLinkContractReceivables.ALL_CAPTIONS);
			for(BaseOnAttachmentLinkContractReceivables b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


