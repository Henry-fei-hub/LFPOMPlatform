package pomplatform.specialDeduction.handler;

import org.apache.log4j.Logger;
import pomplatform.specialDeduction.bean.BaseSpecialDeductionRecordsApplyOfWorkflow;
import pomplatform.specialDeduction.bean.ConditionSpecialDeductionRecordsApplyOfWorkflow;
import pomplatform.specialDeduction.query.QuerySpecialDeductionRecordsApplyOfWorkflow;
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

public class SpecialDeductionRecordsApplyOfWorkflowHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SpecialDeductionRecordsApplyOfWorkflowHandler.class);

	public static BaseCollection<BaseSpecialDeductionRecordsApplyOfWorkflow> executeQuerySpecialDeductionRecordsApplyOfWorkflow(ConditionSpecialDeductionRecordsApplyOfWorkflow c, KeyValuePair[] replacements ) throws Exception {
		QuerySpecialDeductionRecordsApplyOfWorkflow dao = new QuerySpecialDeductionRecordsApplyOfWorkflow();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSpecialDeductionRecordsApplyOfWorkflow> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSpecialDeductionRecordsApplyOfWorkflow c = new ConditionSpecialDeductionRecordsApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSpecialDeductionRecordsApplyOfWorkflow> result = executeQuerySpecialDeductionRecordsApplyOfWorkflow(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSpecialDeductionRecordsApplyOfWorkflow> result;
		ConditionSpecialDeductionRecordsApplyOfWorkflow c = new ConditionSpecialDeductionRecordsApplyOfWorkflow();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySpecialDeductionRecordsApplyOfWorkflow dao = new QuerySpecialDeductionRecordsApplyOfWorkflow();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSpecialDeductionRecordsApplyOfWorkflow.ALL_CAPTIONS);
			for(BaseSpecialDeductionRecordsApplyOfWorkflow b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


