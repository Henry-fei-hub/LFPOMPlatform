package pomplatform.supplierworkflow.handler;

import org.apache.log4j.Logger;
import pomplatform.supplierworkflow.bean.BaseSupplierWorkflow;
import pomplatform.supplierworkflow.bean.ConditionSupplierWorkflow;
import pomplatform.supplierworkflow.query.QuerySupplierWorkflow;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseSupplier;
import com.pomplatform.db.dao.Supplier;
import delicacy.common.BaseCollection;

public class SupplierWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SupplierWorkflowHandler.class);

	public static BaseCollection<BaseSupplierWorkflow> executeQuerySupplierWorkflow(ConditionSupplierWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QuerySupplierWorkflow dao = new QuerySupplierWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSupplierWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			Supplier daoSupplier = new Supplier();
			for(BaseSupplierWorkflow bean : result.getCollections()){
				daoSupplier.setConditionReceiveUnitManageId("=", bean.getReceiveUnitManageId());
				bean.setDetailSupplier(daoSupplier.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSupplierWorkflow c = new ConditionSupplierWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSupplierWorkflow> result = executeQuerySupplierWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSupplierWorkflow> result;
		ConditionSupplierWorkflow c = new ConditionSupplierWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySupplierWorkflow dao = new QuerySupplierWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSupplierWorkflow.ALL_CAPTIONS);
			for(BaseSupplierWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


