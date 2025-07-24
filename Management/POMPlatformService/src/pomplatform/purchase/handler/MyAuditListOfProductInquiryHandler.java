package pomplatform.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.purchase.bean.BaseMyAuditListOfProductInquiry;
import pomplatform.purchase.bean.ConditionMyAuditListOfProductInquiry;
import pomplatform.purchase.query.QueryMyAuditListOfProductInquiry;
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

public class MyAuditListOfProductInquiryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MyAuditListOfProductInquiryHandler.class);

	public static BaseCollection<BaseMyAuditListOfProductInquiry> executeQueryMyAuditListOfProductInquiry(ConditionMyAuditListOfProductInquiry c, KeyValuePair[] replacements ) throws Exception {
		QueryMyAuditListOfProductInquiry dao = new QueryMyAuditListOfProductInquiry();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMyAuditListOfProductInquiry> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMyAuditListOfProductInquiry c = new ConditionMyAuditListOfProductInquiry();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMyAuditListOfProductInquiry> result = executeQueryMyAuditListOfProductInquiry(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMyAuditListOfProductInquiry> result;
		ConditionMyAuditListOfProductInquiry c = new ConditionMyAuditListOfProductInquiry();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMyAuditListOfProductInquiry dao = new QueryMyAuditListOfProductInquiry();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMyAuditListOfProductInquiry.ALL_CAPTIONS);
			for(BaseMyAuditListOfProductInquiry b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


