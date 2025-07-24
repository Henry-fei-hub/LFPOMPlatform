package pomplatform.reimbursementpackage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursementpackage.bean.BaseMnewReimbursementPackagepecdcbor;
import pomplatform.reimbursementpackage.bean.ConditionMnewReimbursementPackagepecdcbor;

public class QueryMnewReimbursementPackagepecdcbor extends AbstractQuery<BaseMnewReimbursementPackagepecdcbor, ConditionMnewReimbursementPackagepecdcbor>
{

	private static final Logger __logger = Logger.getLogger(QueryMnewReimbursementPackagepecdcbor.class);

	public QueryMnewReimbursementPackagepecdcbor() throws java.sql.SQLException 
	{
		setParameterNumber(24);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spia.process_type");
	}

	@Override
	public BaseCollection<BaseMnewReimbursementPackagepecdcbor> executeQuery( KeyValuePair[] replacements, ConditionMnewReimbursementPackagepecdcbor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getCode(), 
				condition.getBackViewName(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getCode(), 
				condition.getBackViewName(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getCode(), 
				condition.getBackViewName(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getCode(), 
				condition.getBackViewName()
			);
	}

	@Override
	public BaseMnewReimbursementPackagepecdcbor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMnewReimbursementPackagepecdcbor __base = new BaseMnewReimbursementPackagepecdcbor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setString(count++, GenericBase.__getString(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setInt(count++, GenericBase.__getInt(args[18]));
		if(args[19] != null) __statement.setInt(count++, GenericBase.__getInt(args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setString(count++, GenericBase.__getString(args[22]));
		if(args[23] != null) __statement.setString(count++, GenericBase.__getString(args[23]));
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
	
	private final static String __SQLText = "SELECT spia.process_type, spia.business_id, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.process_comment, spia.status, a.code, a.employee_id, a.department_id, a.amount, a.company_id, spia.operate_time, spia.activity_type FROM system_process_instance_activities spia LEFT JOIN project_normal_reimbursements A ON spia.business_id = a.project_normal_reimbursement_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id WHERE spi.process_status = 1 AND spia.employee_id IN (SELECT employee_id FROM employee_roles WHERE role_id = 37) AND spia.process_type IN (2, 3, 8, 10) AND spia.process_type = ? AND spia.status = 1 AND spia.employee_id = ? AND spia.activity_type IN (2, 3) AND a.be_packed = FALSE AND a.company_id = ? AND a.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) AND a.code LIKE ? AND spia.delete_flag = 0 AND spia.back_view_name LIKE ? AND a.delete_flag = 0 UNION ALL SELECT spia.process_type, spia.business_id, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.process_comment, spia.status, a.code, a.employee_id, a.department_id, a.borrow_money AS amount, a.company_id, spia.operate_time, spia.activity_type FROM system_process_instance_activities spia LEFT JOIN employee_money_manages A ON spia.business_id = a.employee_money_manage_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id WHERE spi.process_status = 1 AND spia.employee_id IN (SELECT employee_id FROM employee_roles WHERE role_id = 37) AND spia.process_type = ? AND spia.process_type = 6 AND spia.status = 1 AND spia.employee_id = ? AND spia.activity_type IN (2, 3) AND a.be_packed = FALSE AND a.company_id = ? AND a.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) AND a.code LIKE ? AND spia.delete_flag = 0 AND spia.back_view_name LIKE ? UNION ALL SELECT spia.process_type, spia.business_id, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.process_comment, spia.status, a.code, a.employee_id, a.department_id, a.pay_amount AS amount, a.company_id, spia.operate_time, spia.activity_type FROM system_process_instance_activities spia LEFT JOIN pay_money_manages A ON spia.business_id = a.pay_money_manage_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id WHERE spi.process_status = 1 AND spia.employee_id IN (SELECT employee_id FROM employee_roles WHERE role_id = 37) AND spia.process_type = ? AND spia.process_type = 7 AND spia.status = 1 AND spia.employee_id = ? AND spia.activity_type IN (2, 3) AND a.be_packed = FALSE AND a.company_id = ? AND a.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) AND a.code LIKE ? AND spia.delete_flag = 0 AND spia.back_view_name LIKE ? AND a.delete_flag = 0 UNION ALL SELECT spia.process_type, spia.business_id, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.process_comment, spia.status, a.code, a.applicant AS employee_id, a.department_id, a.amount, a.company_id, spia.operate_time, spia.activity_type FROM system_process_instance_activities spia LEFT JOIN travel_reimbursements A ON spia.business_id = a.travel_reimbursement_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id WHERE spi.process_status = 1 AND spia.employee_id IN (SELECT employee_id FROM employee_roles WHERE role_id = 37) AND spia.process_type = ? AND spia.process_type IN (4,5,9) AND spia.status = 1 AND spia.employee_id = ? AND spia.activity_type IN (2, 3) AND a.be_packed = FALSE AND a.company_id = ? AND a.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) AND a.code LIKE ? AND spia.delete_flag = 0 AND spia.back_view_name LIKE ? AND a.delete_flag = 0" ;
	private final static String RESULTSETFIELDLIST = "process_type,business_id,process_activity_id,process_id,process_instance_id,activity_id,next_activity_id,main_activity_id,process_comment,status,code,employee_id,department_id,amount,company_id,operate_time,activity_type";
	private final static String[] fieldNames = { "process_type", "employee_id", "company_id", "department_id", "code", "back_view_name", "process_type", "employee_id", "company_id", "department_id", "code", "back_view_name", "process_type", "employee_id", "company_id", "department_id", "code", "back_view_name", "process_type", "employee_id", "company_id", "department_id", "code", "back_view_name"};
}
