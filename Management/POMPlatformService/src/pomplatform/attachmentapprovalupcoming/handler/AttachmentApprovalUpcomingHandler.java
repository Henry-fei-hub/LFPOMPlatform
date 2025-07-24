package pomplatform.attachmentapprovalupcoming.handler;

import org.apache.log4j.Logger;
import pomplatform.attachmentapprovalupcoming.bean.BaseAttachmentApprovalUpcoming;
import pomplatform.attachmentapprovalupcoming.bean.ConditionAttachmentApprovalUpcoming;
import pomplatform.attachmentapprovalupcoming.query.QueryAttachmentApprovalUpcoming;
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

public class AttachmentApprovalUpcomingHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AttachmentApprovalUpcomingHandler.class);

	public static BaseCollection<BaseAttachmentApprovalUpcoming> executeQueryAttachmentApprovalUpcoming(ConditionAttachmentApprovalUpcoming c, KeyValuePair[] replacements ) throws Exception {
		QueryAttachmentApprovalUpcoming dao = new QueryAttachmentApprovalUpcoming();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAttachmentApprovalUpcoming> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAttachmentApprovalUpcoming c = new ConditionAttachmentApprovalUpcoming();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAttachmentApprovalUpcoming> result = executeQueryAttachmentApprovalUpcoming(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAttachmentApprovalUpcoming> result;
		ConditionAttachmentApprovalUpcoming c = new ConditionAttachmentApprovalUpcoming();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAttachmentApprovalUpcoming dao = new QueryAttachmentApprovalUpcoming();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAttachmentApprovalUpcoming.ALL_CAPTIONS);
			for(BaseAttachmentApprovalUpcoming b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


