package pomplatform.plateproductionvalue.handler;

import com.pomplatform.db.dao.ProductionValueCoefficient;
import org.apache.log4j.Logger;
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
import pomplatform.plateproductionvalue.bean.BaseSproductionvaluecoefficienttypepor;
import pomplatform.plateproductionvalue.bean.ConditionSproductionvaluecoefficienttypepor;
import pomplatform.plateproductionvalue.query.QuerySproductionvaluecoefficienttypepor;

public class SproductionvaluecoefficienttypeporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SproductionvaluecoefficienttypeporHandler.class);

	public static BaseCollection<BaseSproductionvaluecoefficienttypepor> executeQuerySproductionvaluecoefficienttypepor(ConditionSproductionvaluecoefficienttypepor c, KeyValuePair[] replacements ) throws Exception {
		QuerySproductionvaluecoefficienttypepor dao = new QuerySproductionvaluecoefficienttypepor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSproductionvaluecoefficienttypepor> result = dao.execute( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			ProductionValueCoefficient daoProductionValueCoefficient = new ProductionValueCoefficient();
			for(BaseSproductionvaluecoefficienttypepor bean : result.getCollections()){
				daoProductionValueCoefficient.setConditionProductionValueCoefficientTypeId("=", bean.getProductionValueCoefficientTypeId());
				bean.setDetailProductionValueCoefficient(daoProductionValueCoefficient.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSproductionvaluecoefficienttypepor c = new ConditionSproductionvaluecoefficienttypepor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSproductionvaluecoefficienttypepor> result = executeQuerySproductionvaluecoefficienttypepor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSproductionvaluecoefficienttypepor> result;
		ConditionSproductionvaluecoefficienttypepor c = new ConditionSproductionvaluecoefficienttypepor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySproductionvaluecoefficienttypepor dao = new QuerySproductionvaluecoefficienttypepor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSproductionvaluecoefficienttypepor.ALL_CAPTIONS);
			for(BaseSproductionvaluecoefficienttypepor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


