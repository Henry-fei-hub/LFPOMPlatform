package pomplatform.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.purchase.bean.BaseOnLoadTaskListOfProductInquiry;
import pomplatform.purchase.bean.ConditionOnLoadTaskListOfProductInquiry;
import pomplatform.purchase.query.QueryOnLoadTaskListOfProductInquiry;
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

public class OnLoadTaskListOfProductInquiryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadTaskListOfProductInquiryHandler.class);

	public static BaseCollection<BaseOnLoadTaskListOfProductInquiry> executeQueryOnLoadTaskListOfProductInquiry(ConditionOnLoadTaskListOfProductInquiry c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadTaskListOfProductInquiry dao = new QueryOnLoadTaskListOfProductInquiry();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadTaskListOfProductInquiry> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadTaskListOfProductInquiry c = new ConditionOnLoadTaskListOfProductInquiry();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadTaskListOfProductInquiry> result = executeQueryOnLoadTaskListOfProductInquiry(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadTaskListOfProductInquiry> result;
		ConditionOnLoadTaskListOfProductInquiry c = new ConditionOnLoadTaskListOfProductInquiry();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadTaskListOfProductInquiry dao = new QueryOnLoadTaskListOfProductInquiry();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadTaskListOfProductInquiry.ALL_CAPTIONS);
			for(BaseOnLoadTaskListOfProductInquiry b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


