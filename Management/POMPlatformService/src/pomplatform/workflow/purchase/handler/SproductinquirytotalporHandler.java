package pomplatform.workflow.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.purchase.bean.BaseSproductinquirytotalpor;
import pomplatform.workflow.purchase.bean.ConditionSproductinquirytotalpor;
import pomplatform.workflow.purchase.query.QuerySproductinquirytotalpor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseProductInquiryDetail;
import com.pomplatform.db.dao.ProductInquiryDetail;
import delicacy.common.BaseCollection;

public class SproductinquirytotalporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SproductinquirytotalporHandler.class);

	public static BaseCollection<BaseSproductinquirytotalpor> executeQuerySproductinquirytotalpor(ConditionSproductinquirytotalpor c, KeyValuePair[] replacements ) throws Exception {
		QuerySproductinquirytotalpor dao = new QuerySproductinquirytotalpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSproductinquirytotalpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProductInquiryDetail daoProductInquiryDetail = new ProductInquiryDetail();
			for(BaseSproductinquirytotalpor bean : result.getCollections()){
				daoProductInquiryDetail.setConditionProductInquiryTotalId("=", bean.getProductInquiryTotalId());
				bean.setDetailProductInquiryDetail(daoProductInquiryDetail.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSproductinquirytotalpor c = new ConditionSproductinquirytotalpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSproductinquirytotalpor> result = executeQuerySproductinquirytotalpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSproductinquirytotalpor> result;
		ConditionSproductinquirytotalpor c = new ConditionSproductinquirytotalpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySproductinquirytotalpor dao = new QuerySproductinquirytotalpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSproductinquirytotalpor.ALL_CAPTIONS);
			for(BaseSproductinquirytotalpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


