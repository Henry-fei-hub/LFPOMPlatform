package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BaseCarApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionCarApply;
import pomplatform.workflow.personnelbusiness.query.QueryCarApply;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pomplatform.db.bean.BaseCarCostAllocation;
import com.pomplatform.db.dao.CarCostAllocation;
import delicacy.common.BaseCollection;

public class CarApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CarApplyHandler.class);

	public static BaseCollection<BaseCarApply> executeQueryCarApply(ConditionCarApply c, KeyValuePair[] replacements ) throws Exception {
		QueryCarApply dao = new QueryCarApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCarApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(c.isIncludeDetail() && result.getRecordNumber() > 0){
			CarCostAllocation daoCarCostAllocation = new CarCostAllocation();
			for(BaseCarApply bean : result.getCollections()){
				daoCarCostAllocation.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				bean.setDetailCarCostAllocation(daoCarCostAllocation.conditionalLoad(null));
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCarApply c = new ConditionCarApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCarApply> result = executeQueryCarApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCarApply> result;
		ConditionCarApply c = new ConditionCarApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCarApply dao = new QueryCarApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCarApply.ALL_CAPTIONS);
			for(BaseCarApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


