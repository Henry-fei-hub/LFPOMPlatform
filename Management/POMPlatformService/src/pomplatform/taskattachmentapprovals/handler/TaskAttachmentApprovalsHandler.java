package pomplatform.taskattachmentapprovals.handler;

import org.apache.log4j.Logger;
import pomplatform.taskattachmentapprovals.bean.BaseTaskAttachmentApprovals;
import pomplatform.taskattachmentapprovals.bean.ConditionTaskAttachmentApprovals;
import pomplatform.taskattachmentapprovals.query.QueryTaskAttachmentApprovals;
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

public class TaskAttachmentApprovalsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(TaskAttachmentApprovalsHandler.class);

	public static BaseCollection<BaseTaskAttachmentApprovals> executeQueryTaskAttachmentApprovals(ConditionTaskAttachmentApprovals c, KeyValuePair[] replacements ) throws Exception {
		QueryTaskAttachmentApprovals dao = new QueryTaskAttachmentApprovals();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseTaskAttachmentApprovals> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionTaskAttachmentApprovals c = new ConditionTaskAttachmentApprovals();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseTaskAttachmentApprovals> result = executeQueryTaskAttachmentApprovals(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseTaskAttachmentApprovals> result;
		ConditionTaskAttachmentApprovals c = new ConditionTaskAttachmentApprovals();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryTaskAttachmentApprovals dao = new QueryTaskAttachmentApprovals();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseTaskAttachmentApprovals.ALL_CAPTIONS);
			for(BaseTaskAttachmentApprovals b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


