package pomplatform.mobile.approvalcount.handler;

import org.apache.log4j.Logger;
import pomplatform.mobile.approvalcount.bean.BaseMyApprovalProcessDetail;
import pomplatform.mobile.approvalcount.bean.ConditionMyApprovalProcessDetail;
import pomplatform.mobile.approvalcount.query.QueryMyApprovalProcessDetail;
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

public class MyApprovalProcessDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MyApprovalProcessDetailHandler.class);

	public static BaseCollection<BaseMyApprovalProcessDetail> executeQueryMyApprovalProcessDetail(ConditionMyApprovalProcessDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryMyApprovalProcessDetail dao = new QueryMyApprovalProcessDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMyApprovalProcessDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMyApprovalProcessDetail c = new ConditionMyApprovalProcessDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMyApprovalProcessDetail> result = executeQueryMyApprovalProcessDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMyApprovalProcessDetail> result;
		ConditionMyApprovalProcessDetail c = new ConditionMyApprovalProcessDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMyApprovalProcessDetail dao = new QueryMyApprovalProcessDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMyApprovalProcessDetail.ALL_CAPTIONS);
			for(BaseMyApprovalProcessDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


