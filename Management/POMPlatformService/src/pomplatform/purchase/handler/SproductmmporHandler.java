package pomplatform.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.purchase.bean.BaseSproductmmpor;
import pomplatform.purchase.bean.ConditionSproductmmpor;
import pomplatform.purchase.query.QuerySproductmmpor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseProductAttribute;
import com.pomplatform.db.dao.ProductAttribute;
import delicacy.common.BaseCollection;

public class SproductmmporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SproductmmporHandler.class);

	public static BaseCollection<BaseSproductmmpor> executeQuerySproductmmpor(ConditionSproductmmpor c, KeyValuePair[] replacements ) throws Exception {
		QuerySproductmmpor dao = new QuerySproductmmpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSproductmmpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProductAttribute daoProductAttribute = new ProductAttribute();
			for(BaseSproductmmpor bean : result.getCollections()){
				daoProductAttribute.setConditionProductId("=", bean.getProductId());
				bean.setDetailProductAttribute(daoProductAttribute.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSproductmmpor c = new ConditionSproductmmpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSproductmmpor> result = executeQuerySproductmmpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSproductmmpor> result;
		ConditionSproductmmpor c = new ConditionSproductmmpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySproductmmpor dao = new QuerySproductmmpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSproductmmpor.ALL_CAPTIONS);
			for(BaseSproductmmpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


