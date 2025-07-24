package pomplatform.supplierworkflow.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.SupplierCooperation;
import com.pomplatform.db.dao.SupplierDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.supplierworkflow.bean.BaseSupplierComeIn;
import pomplatform.supplierworkflow.bean.ConditionSupplierComeIn;
import pomplatform.supplierworkflow.query.QuerySupplierComeIn;

public class SupplierComeInHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SupplierComeInHandler.class);

	public static BaseCollection<BaseSupplierComeIn> executeQuerySupplierComeIn(ConditionSupplierComeIn c, KeyValuePair[] replacements ) throws Exception {
		QuerySupplierComeIn dao = new QuerySupplierComeIn();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSupplierComeIn> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			SupplierDetail daoSupplierDetail = new SupplierDetail();
			SupplierCooperation daoSupplierCooperation = new SupplierCooperation();
			for(BaseSupplierComeIn bean : result.getCollections()){
				daoSupplierDetail.setConditionSupplierId("=", bean.getSupplierId());
				bean.setDetailSupplierDetail(daoSupplierDetail.conditionalLoad(null));
				daoSupplierCooperation.setConditionSupplierId("=", bean.getSupplierId());
				bean.setDetailSupplierCooperation(daoSupplierCooperation.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSupplierComeIn c = new ConditionSupplierComeIn();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSupplierComeIn> result = executeQuerySupplierComeIn(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSupplierComeIn> result;
		ConditionSupplierComeIn c = new ConditionSupplierComeIn();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySupplierComeIn dao = new QuerySupplierComeIn();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSupplierComeIn.ALL_CAPTIONS);
			for(BaseSupplierComeIn b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


