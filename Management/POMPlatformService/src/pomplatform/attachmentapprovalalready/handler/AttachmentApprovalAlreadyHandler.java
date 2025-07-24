package pomplatform.attachmentapprovalalready.handler;

import org.apache.log4j.Logger;
import pomplatform.attachmentapprovalalready.bean.BaseAttachmentApprovalAlready;
import pomplatform.attachmentapprovalalready.bean.ConditionAttachmentApprovalAlready;
import pomplatform.attachmentapprovalalready.query.QueryAttachmentApprovalAlready;
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

public class AttachmentApprovalAlreadyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AttachmentApprovalAlreadyHandler.class);

	public static BaseCollection<BaseAttachmentApprovalAlready> executeQueryAttachmentApprovalAlready(ConditionAttachmentApprovalAlready c, KeyValuePair[] replacements ) throws Exception {
		QueryAttachmentApprovalAlready dao = new QueryAttachmentApprovalAlready();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAttachmentApprovalAlready> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAttachmentApprovalAlready c = new ConditionAttachmentApprovalAlready();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAttachmentApprovalAlready> result = executeQueryAttachmentApprovalAlready(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAttachmentApprovalAlready> result;
		ConditionAttachmentApprovalAlready c = new ConditionAttachmentApprovalAlready();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAttachmentApprovalAlready dao = new QueryAttachmentApprovalAlready();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAttachmentApprovalAlready.ALL_CAPTIONS);
			for(BaseAttachmentApprovalAlready b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


