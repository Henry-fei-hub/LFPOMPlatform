package pomplatform.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.purchase.bean.BaseOnLoadAuditListOfProductInquiry;
import pomplatform.purchase.bean.ConditionOnLoadAuditListOfProductInquiry;
import pomplatform.purchase.query.QueryOnLoadAuditListOfProductInquiry;
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

public class OnLoadAuditListOfProductInquiryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfProductInquiryHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfProductInquiry> executeQueryOnLoadAuditListOfProductInquiry(ConditionOnLoadAuditListOfProductInquiry c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfProductInquiry dao = new QueryOnLoadAuditListOfProductInquiry();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfProductInquiry> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfProductInquiry c = new ConditionOnLoadAuditListOfProductInquiry();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfProductInquiry> result = executeQueryOnLoadAuditListOfProductInquiry(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfProductInquiry> result;
		ConditionOnLoadAuditListOfProductInquiry c = new ConditionOnLoadAuditListOfProductInquiry();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfProductInquiry dao = new QueryOnLoadAuditListOfProductInquiry();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfProductInquiry.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfProductInquiry b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


