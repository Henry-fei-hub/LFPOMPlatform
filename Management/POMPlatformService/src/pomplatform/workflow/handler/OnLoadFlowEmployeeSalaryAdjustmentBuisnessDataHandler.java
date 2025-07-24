package pomplatform.workflow.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import pomplatform.workflow.bean.BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData;
import pomplatform.workflow.bean.ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData;
import pomplatform.workflow.query.QueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData;

public class OnLoadFlowEmployeeSalaryAdjustmentBuisnessDataHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadFlowEmployeeSalaryAdjustmentBuisnessDataHandler.class);

	public static BaseCollection<BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData> executeQueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData(ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData dao = new QueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData c = new ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData> result = executeQueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData> result;
		ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData c = new ConditionOnLoadFlowEmployeeSalaryAdjustmentBuisnessData();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData dao = new QueryOnLoadFlowEmployeeSalaryAdjustmentBuisnessData();
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
			ps.println(BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData.EXPORT_CAPTIONS);
			Set<Integer> set = new HashSet<>();
			for(BaseOnLoadFlowEmployeeSalaryAdjustmentBuisnessData b : result.getCollections()){
				if(set.contains(b.getEmployeeId())) {
					continue;
				}else {
					set.add(b.getEmployeeId());
					ps.println(b.toCSVString());
				}
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


