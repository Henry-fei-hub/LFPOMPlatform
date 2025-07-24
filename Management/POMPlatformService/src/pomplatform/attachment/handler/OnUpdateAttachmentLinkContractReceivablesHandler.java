package pomplatform.attachment.handler;

import org.apache.log4j.Logger;
import pomplatform.attachment.bean.BaseOnUpdateAttachmentLinkContractReceivables;
import pomplatform.attachment.bean.ConditionOnUpdateAttachmentLinkContractReceivables;
import pomplatform.attachment.query.QueryOnUpdateAttachmentLinkContractReceivables;
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

public class OnUpdateAttachmentLinkContractReceivablesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnUpdateAttachmentLinkContractReceivablesHandler.class);

	public static BaseCollection<BaseOnUpdateAttachmentLinkContractReceivables> executeQueryOnUpdateAttachmentLinkContractReceivables(ConditionOnUpdateAttachmentLinkContractReceivables c, KeyValuePair[] replacements ) throws Exception {
		QueryOnUpdateAttachmentLinkContractReceivables dao = new QueryOnUpdateAttachmentLinkContractReceivables();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnUpdateAttachmentLinkContractReceivables> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnUpdateAttachmentLinkContractReceivables c = new ConditionOnUpdateAttachmentLinkContractReceivables();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnUpdateAttachmentLinkContractReceivables> result = executeQueryOnUpdateAttachmentLinkContractReceivables(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnUpdateAttachmentLinkContractReceivables> result;
		ConditionOnUpdateAttachmentLinkContractReceivables c = new ConditionOnUpdateAttachmentLinkContractReceivables();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnUpdateAttachmentLinkContractReceivables dao = new QueryOnUpdateAttachmentLinkContractReceivables();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnUpdateAttachmentLinkContractReceivables.ALL_CAPTIONS);
			for(BaseOnUpdateAttachmentLinkContractReceivables b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


