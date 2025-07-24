package pomplatform.attachmentapprovalapply.handler;

import org.apache.log4j.Logger;
import pomplatform.attachmentapprovalapply.bean.BaseAttachmentApprovalApply;
import pomplatform.attachmentapprovalapply.bean.ConditionAttachmentApprovalApply;
import pomplatform.attachmentapprovalapply.query.QueryAttachmentApprovalApply;
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

public class AttachmentApprovalApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AttachmentApprovalApplyHandler.class);

	public static BaseCollection<BaseAttachmentApprovalApply> executeQueryAttachmentApprovalApply(ConditionAttachmentApprovalApply c, KeyValuePair[] replacements ) throws Exception {
		QueryAttachmentApprovalApply dao = new QueryAttachmentApprovalApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAttachmentApprovalApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAttachmentApprovalApply c = new ConditionAttachmentApprovalApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAttachmentApprovalApply> result = executeQueryAttachmentApprovalApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAttachmentApprovalApply> result;
		ConditionAttachmentApprovalApply c = new ConditionAttachmentApprovalApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAttachmentApprovalApply dao = new QueryAttachmentApprovalApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAttachmentApprovalApply.ALL_CAPTIONS);
			for(BaseAttachmentApprovalApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


