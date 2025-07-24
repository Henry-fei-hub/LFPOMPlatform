package pomplatform.workflow.personnel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnel.bean.BaseRefuseOfEmployeeOnboard;
import pomplatform.workflow.personnel.bean.ConditionRefuseOfEmployeeOnboard;

public class QueryRefuseOfEmployeeOnboard extends AbstractQuery<BaseRefuseOfEmployeeOnboard, ConditionRefuseOfEmployeeOnboard>
{

	private static final Logger __logger = Logger.getLogger(QueryRefuseOfEmployeeOnboard.class);

	public QueryRefuseOfEmployeeOnboard() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseRefuseOfEmployeeOnboard> executeQuery( KeyValuePair[] replacements, ConditionRefuseOfEmployeeOnboard condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getOwnedCompany(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseRefuseOfEmployeeOnboard generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRefuseOfEmployeeOnboard __base = new BaseRefuseOfEmployeeOnboard();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOwnedCompany(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmpStatus(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id,spi.business_id,spi.business_name,spi.process_id,spi.process_instance_activity_id,spi.create_time, spi.process_status,spi.complete_time,A.department_id,A.employee_no,A.employee_name,A.onboard_date,A.owned_company, A.duty_id,A.apply_employee_id,A.status AS emp_status FROM system_process_instances spi LEFT JOIN employees A ON spi.business_id = A.employee_id WHERE spi.process_type = ? AND spi.process_status IN (3, 5) AND spi.process_status = ? AND A.apply_employee_id = ? AND A.owned_company = ? AND A.employee_name LIKE ? AND A.employee_no LIKE ? AND A.department_id IN (SELECT child_id FROM department_ids WHERE department_id = ?) ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,create_time,process_status,complete_time,department_id,employee_no,employee_name,onboard_date,owned_company,duty_id,apply_employee_id,emp_status";
	private final static String[] fieldNames = { "process_type", "status", "employee_id", "owned_company", "employee_name", "employee_no", "department_id"};
}
