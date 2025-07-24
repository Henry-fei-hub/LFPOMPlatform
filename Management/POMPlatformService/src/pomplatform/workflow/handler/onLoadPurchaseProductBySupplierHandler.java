package pomplatform.workflow.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.bean.BaseonLoadPurchaseProductBySupplier;
import pomplatform.workflow.bean.ConditiononLoadPurchaseProductBySupplier;
import pomplatform.workflow.query.QueryonLoadPurchaseProductBySupplier;
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

public class onLoadPurchaseProductBySupplierHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(onLoadPurchaseProductBySupplierHandler.class);

	public static BaseCollection<BaseonLoadPurchaseProductBySupplier> executeQueryonLoadPurchaseProductBySupplier(ConditiononLoadPurchaseProductBySupplier c, KeyValuePair[] replacements ) throws Exception {
		QueryonLoadPurchaseProductBySupplier dao = new QueryonLoadPurchaseProductBySupplier();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseonLoadPurchaseProductBySupplier> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditiononLoadPurchaseProductBySupplier c = new ConditiononLoadPurchaseProductBySupplier();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseonLoadPurchaseProductBySupplier> result = executeQueryonLoadPurchaseProductBySupplier(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseonLoadPurchaseProductBySupplier> result;
		ConditiononLoadPurchaseProductBySupplier c = new ConditiononLoadPurchaseProductBySupplier();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryonLoadPurchaseProductBySupplier dao = new QueryonLoadPurchaseProductBySupplier();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseonLoadPurchaseProductBySupplier.ALL_CAPTIONS);
			for(BaseonLoadPurchaseProductBySupplier b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


