package pomplatform.projectAttachmentManage.handler;

import org.apache.log4j.Logger;
import pomplatform.projectAttachmentManage.bean.BaseProjectAttachmentManage;
import pomplatform.projectAttachmentManage.bean.ConditionProjectAttachmentManage;
import pomplatform.projectAttachmentManage.query.QueryProjectAttachmentManage;
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

public class ProjectAttachmentManageHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ProjectAttachmentManageHandler.class);

	public static BaseCollection<BaseProjectAttachmentManage> executeQueryProjectAttachmentManage(ConditionProjectAttachmentManage c, KeyValuePair[] replacements ) throws Exception {
		QueryProjectAttachmentManage dao = new QueryProjectAttachmentManage();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseProjectAttachmentManage> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionProjectAttachmentManage c = new ConditionProjectAttachmentManage();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseProjectAttachmentManage> result = executeQueryProjectAttachmentManage(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseProjectAttachmentManage> result;
		ConditionProjectAttachmentManage c = new ConditionProjectAttachmentManage();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryProjectAttachmentManage dao = new QueryProjectAttachmentManage();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseProjectAttachmentManage.ALL_CAPTIONS);
			for(BaseProjectAttachmentManage b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


