package pomplatform.workflow.personnelbusiness.handler;

import org.apache.log4j.Logger;
import pomplatform.workflow.personnelbusiness.bean.BasePlateSalaryAdjustmentSummary;
import pomplatform.workflow.personnelbusiness.bean.ConditionPlateSalaryAdjustmentSummary;
import pomplatform.workflow.personnelbusiness.query.QueryPlateSalaryAdjustmentSummary;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class PlateSalaryAdjustmentSummaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(PlateSalaryAdjustmentSummaryHandler.class);

	public static BaseCollection<BasePlateSalaryAdjustmentSummary> executeQueryPlateSalaryAdjustmentSummary(ConditionPlateSalaryAdjustmentSummary c, KeyValuePair[] replacements ) throws Exception {
		QueryPlateSalaryAdjustmentSummary dao = new QueryPlateSalaryAdjustmentSummary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BasePlateSalaryAdjustmentSummary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionPlateSalaryAdjustmentSummary c = new ConditionPlateSalaryAdjustmentSummary();
		c.setDataFromJSON(creteria);
		BaseCollection<BasePlateSalaryAdjustmentSummary> result = executeQueryPlateSalaryAdjustmentSummary(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BasePlateSalaryAdjustmentSummary> result;
		ConditionPlateSalaryAdjustmentSummary c = new ConditionPlateSalaryAdjustmentSummary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryPlateSalaryAdjustmentSummary dao = new QueryPlateSalaryAdjustmentSummary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BasePlateSalaryAdjustmentSummary.ALL_CAPTIONS);
			for(BasePlateSalaryAdjustmentSummary b : result.getCollections()){
				ps.println(b.toCSVString());
			}
			//部门审批人
			String auditPerson = params.get("auditPerson")+"";
			//申请人
			String payPerson = params.get("payPerson")+"";
			//运营审批
			String operatePerson = params.get("operatePerson")+"";
			//人资审批
			String hrPerson = params.get("hrPerson")+"";
			String str = "总经理:"+","+"部门审批人:"+auditPerson+","+"运营审批:"+operatePerson+","+"人资审批:"+hrPerson+","+"申请人:"+payPerson;
			BaseEmployee d = new BaseEmployee();
			d.setEmployeeNo(str);
			ps.println(d.toCSVString());
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


