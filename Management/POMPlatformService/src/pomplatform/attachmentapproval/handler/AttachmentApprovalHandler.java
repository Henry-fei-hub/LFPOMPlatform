package pomplatform.attachmentapproval.handler;

import org.apache.log4j.Logger;
import pomplatform.attachmentapproval.bean.BaseAttachmentApproval;
import pomplatform.attachmentapproval.bean.ConditionAttachmentApproval;
import pomplatform.attachmentapproval.query.QueryAttachmentApproval;
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

public class AttachmentApprovalHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AttachmentApprovalHandler.class);

	public static BaseCollection<BaseAttachmentApproval> executeQueryAttachmentApproval(ConditionAttachmentApproval c, KeyValuePair[] replacements ) throws Exception {
		QueryAttachmentApproval dao = new QueryAttachmentApproval();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAttachmentApproval> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAttachmentApproval c = new ConditionAttachmentApproval();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAttachmentApproval> result = executeQueryAttachmentApproval(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAttachmentApproval> result;
		ConditionAttachmentApproval c = new ConditionAttachmentApproval();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAttachmentApproval dao = new QueryAttachmentApproval();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAttachmentApproval.ALL_CAPTIONS);
			for(BaseAttachmentApproval b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


