package pomplatform.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.purchase.bean.BaseOnLoadAttentionListOfProductInquiry;
import pomplatform.purchase.bean.ConditionOnLoadAttentionListOfProductInquiry;
import pomplatform.purchase.query.QueryOnLoadAttentionListOfProductInquiry;
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

public class OnLoadAttentionListOfProductInquiryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAttentionListOfProductInquiryHandler.class);

	public static BaseCollection<BaseOnLoadAttentionListOfProductInquiry> executeQueryOnLoadAttentionListOfProductInquiry(ConditionOnLoadAttentionListOfProductInquiry c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttentionListOfProductInquiry dao = new QueryOnLoadAttentionListOfProductInquiry();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttentionListOfProductInquiry> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAttentionListOfProductInquiry c = new ConditionOnLoadAttentionListOfProductInquiry();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAttentionListOfProductInquiry> result = executeQueryOnLoadAttentionListOfProductInquiry(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAttentionListOfProductInquiry> result;
		ConditionOnLoadAttentionListOfProductInquiry c = new ConditionOnLoadAttentionListOfProductInquiry();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAttentionListOfProductInquiry dao = new QueryOnLoadAttentionListOfProductInquiry();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAttentionListOfProductInquiry.ALL_CAPTIONS);
			for(BaseOnLoadAttentionListOfProductInquiry b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


