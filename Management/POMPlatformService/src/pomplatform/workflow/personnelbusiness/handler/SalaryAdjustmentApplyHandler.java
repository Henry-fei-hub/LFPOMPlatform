package pomplatform.workflow.personnelbusiness.handler;

import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import pomplatform.workflow.personnelbusiness.bean.BaseRegularEmployeeApply;
import pomplatform.workflow.personnelbusiness.bean.BaseSalaryAdjustmentApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionRegularEmployeeApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionSalaryAdjustmentApply;
import pomplatform.workflow.personnelbusiness.query.QueryRegularEmployeeApply;
import pomplatform.workflow.personnelbusiness.query.QuerySalaryAdjustmentApply;

public class SalaryAdjustmentApplyHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SalaryAdjustmentApplyHandler.class);

	public static BaseCollection<BaseSalaryAdjustmentApply> executeQuerySalaryAdjustmentApply(ConditionSalaryAdjustmentApply c, KeyValuePair[] replacements ) throws Exception {
		QuerySalaryAdjustmentApply dao = new QuerySalaryAdjustmentApply();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSalaryAdjustmentApply> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSalaryAdjustmentApply c = new ConditionSalaryAdjustmentApply();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSalaryAdjustmentApply> result = executeQuerySalaryAdjustmentApply(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSalaryAdjustmentApply> result;
		ConditionSalaryAdjustmentApply c = new ConditionSalaryAdjustmentApply();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySalaryAdjustmentApply dao = new QuerySalaryAdjustmentApply();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSalaryAdjustmentApply.ALL_CAPTIONS);
			for(BaseSalaryAdjustmentApply b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


