package pomplatform.projectAttachmentManage.handler;

import org.apache.log4j.Logger;
import pomplatform.projectAttachmentManage.bean.BaseNonconformityAttachmentDetail;
import pomplatform.projectAttachmentManage.bean.ConditionNonconformityAttachmentDetail;
import pomplatform.projectAttachmentManage.query.QueryNonconformityAttachmentDetail;
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

public class NonconformityAttachmentDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(NonconformityAttachmentDetailHandler.class);

	public static BaseCollection<BaseNonconformityAttachmentDetail> executeQueryNonconformityAttachmentDetail(ConditionNonconformityAttachmentDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryNonconformityAttachmentDetail dao = new QueryNonconformityAttachmentDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseNonconformityAttachmentDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionNonconformityAttachmentDetail c = new ConditionNonconformityAttachmentDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseNonconformityAttachmentDetail> result = executeQueryNonconformityAttachmentDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseNonconformityAttachmentDetail> result;
		ConditionNonconformityAttachmentDetail c = new ConditionNonconformityAttachmentDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryNonconformityAttachmentDetail dao = new QueryNonconformityAttachmentDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseNonconformityAttachmentDetail.ALL_CAPTIONS);
			for(BaseNonconformityAttachmentDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


