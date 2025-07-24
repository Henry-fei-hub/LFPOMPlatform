package pomplatform.workflow.personnel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnel.bean.BaseApplyOfEmployeeOnboard;
import pomplatform.workflow.personnel.bean.ConditionApplyOfEmployeeOnboard;

public class QueryApplyOfEmployeeOnboard extends AbstractQuery<BaseApplyOfEmployeeOnboard, ConditionApplyOfEmployeeOnboard>
{

	private static final Logger __logger = Logger.getLogger(QueryApplyOfEmployeeOnboard.class);

	public QueryApplyOfEmployeeOnboard() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseApplyOfEmployeeOnboard> executeQuery( KeyValuePair[] replacements, ConditionApplyOfEmployeeOnboard condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getOnboardDate(), 
				condition.getOwnedCompany(), 
				condition.getDutyId(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId(), 
				condition.getEmployeeName(), 
				condition.getApplyEmployeeId()
			);
	}

	@Override
	public BaseApplyOfEmployeeOnboard generateBase(Object[] __data) throws java.sql.SQLException {
		BaseApplyOfEmployeeOnboard __base = new BaseApplyOfEmployeeOnboard();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOwnedCompany(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id,spi.process_type,spi.business_id,spi.business_name, spi.process_id,spi.process_instance_activity_id,spi.process_status,spi.create_time, spi.complete_time,A.department_id,A.employee_no,A.employee_name,A.onboard_date, A.owned_company,A.duty_id,A.apply_employee_id FROM system_process_instances spi LEFT JOIN employees A ON spi.business_id = A.employee_id WHERE spi.process_type = ? AND spi.process_status IN (0,1) AND spi.delete_flag = 0 AND A.onboard_date =? AND A.owned_company = ? AND A.duty_id = ? AND A.employee_no = ? AND A.department_id IN (SELECT child_id FROM department_ids WHERE department_id =?) AND A.employee_name LIKE ? and A.apply_employee_id = ? ORDER BY create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,department_id,employee_no,employee_name,onboard_date,owned_company,duty_id,apply_employee_id";
	private final static String[] fieldNames = { "process_type", "onboard_date", "owned_company", "duty_id", "employee_no", "department_id", "employee_name", "apply_employee_id"};
}
