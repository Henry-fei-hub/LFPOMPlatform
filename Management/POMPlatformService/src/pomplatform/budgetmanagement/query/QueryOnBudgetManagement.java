package pomplatform.budgetmanagement.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.budgetmanagement.bean.BaseOnBudgetManagement;
import pomplatform.budgetmanagement.bean.ConditionOnBudgetManagement;

public class QueryOnBudgetManagement extends AbstractQuery<BaseOnBudgetManagement, ConditionOnBudgetManagement>
{

	private static final Logger __logger = Logger.getLogger(QueryOnBudgetManagement.class);

	public QueryOnBudgetManagement() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("bm.budget_management_id");
	}

	@Override
	public BaseCollection<BaseOnBudgetManagement> executeQuery( KeyValuePair[] replacements, ConditionOnBudgetManagement condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBdCode(), 
				condition.getBdType(), 
				condition.getBdTotalAmount(), 
				condition.getBdApplyEmployeeId(), 
				condition.getBdApplyTime(), 
				condition.getBdEstimatecloseTime(), 
				condition.getBdStatus(), 
				condition.getProjectId(), 
				condition.getBdRemark(), 
				condition.getProcessStatus(),
				condition.getProjectName(),
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnBudgetManagement generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnBudgetManagement __base = new BaseOnBudgetManagement();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setWarnImg(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBdType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBdUseAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBdRestAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBdApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdApplyTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBdEstimatecloseTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBdStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostBearing(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOutSourceType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBdSupplierCompany(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBdSupplierPerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

	private final static String __SQLText = "select CASE WHEN to_char(bd_estimateclose_time,'YYYYMMDD')<=to_char(current_date,'YYYYMMDD') THEN 'project_warn_red.png' ELSE 'project_warn_green.png' END as warn_img,bm.budget_management_id, bm.bd_code, bm.bd_type, bm.bd_total_amount, bm.bd_use_amount,bm.bd_rest_amount,bm.bd_apply_employee_id, bm.bd_apply_time, bm.bd_estimateclose_time, bm.bd_status, bm.project_id, bm.bd_remark,a.process_status,bm.department_id,bm.cost_bearing,p.project_name,a.process_instance_id,a.process_type,a.process_id,bm.out_source_type,bm.bd_supplier_person,bm.bd_supplier_company,p.contract_code as project_code,c.contract_code,c.contract_name from budget_management bm left join system_process_instances a on bm.budget_management_id=a.business_id and a.process_type=52 LEFT JOIN projects p ON bm.project_id=p.project_id LEFT JOIN contracts c on p.contract_id=c.contract_id where bm.bd_code = ? and bm.bd_type = ? and bm.bd_total_amount = ? and bm.bd_apply_employee_id = ? and bm.bd_apply_time = ? and bm.bd_estimateclose_time = ? and bm.bd_status = ? and bm.project_id = ? and bm.bd_remark = ? and a.process_status=? and p.project_name like ? or bm.department_id=? order by bm.budget_management_id desc" ;
	private final static String RESULTSETFIELDLIST = "warn_img,budget_management_id,bd_code,bd_type,bd_total_amount,bd_use_amount,bd_rest_amount,bd_apply_employee_id,bd_apply_time,bd_estimateclose_time,bd_status,project_id,bd_remark,process_status,department_id,cost_bearing,project_name,process_instance_id,process_type,process_id,out_source_type,bd_supplier_person,bd_supplier_company,project_code,contract_code,contract_name";
	private final static String[] fieldNames = { "bd_code", "bd_type", "bd_total_amount", "bd_apply_employee_id", "bd_apply_time", "bd_estimateclose_time", "bd_status", "project_id", "bd_remark", "process_status","project_name"};
}
