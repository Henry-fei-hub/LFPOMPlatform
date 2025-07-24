package pomplatform.budgetmanagementapplywork.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.budgetmanagementapplywork.bean.BaseBudgetManagementApplyWork;
import pomplatform.budgetmanagementapplywork.bean.ConditionBudgetManagementApplyWork;

public class QueryBudgetManagementApplyWork extends AbstractQuery<BaseBudgetManagementApplyWork, ConditionBudgetManagementApplyWork>
{

	private static final Logger __logger = Logger.getLogger(QueryBudgetManagementApplyWork.class);

	public QueryBudgetManagementApplyWork() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseBudgetManagementApplyWork> executeQuery( KeyValuePair[] replacements, ConditionBudgetManagementApplyWork condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getBdType(), 
				condition.getBdCode(), 
				condition.getCompanyId(), 
				condition.getBdApplyEmployeeId(), 
				condition.getBdApplyTime(), 
				condition.getProjectId(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseBudgetManagementApplyWork generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBudgetManagementApplyWork __base = new BaseBudgetManagementApplyWork();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setInputTaxInvoiceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostBearIng(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.complete_time,spi.process_type, A.* FROM system_process_instances spi LEFT JOIN budget_management A ON spi.business_id =A.budget_management_id WHERE spi.process_type =? AND spi.process_status IN (0, 1) AND A.bd_type=? AND A.bd_code =? AND A.company_id =? AND A.bd_apply_employee_id=? AND A.bd_apply_time=? AND A.project_id=? AND A.department_id=? AND spi.delete_flag = 0 ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,complete_time,process_type,budget_management_id,bd_code,bd_type,bd_total_amount,bd_use_amount,bd_rest_amount,bd_apply_employee_id,bd_apply_time,bd_estimateclose_time,bd_status,project_id,bd_remark,input_tax_invoice_id,department_id,company_id,cost_bearing";
	private final static String[] fieldNames = { "process_type", "bd_type", "bd_code", "company_id", "bd_apply_employee_id", "bd_apply_time", "project_id", "department_id"};
}
