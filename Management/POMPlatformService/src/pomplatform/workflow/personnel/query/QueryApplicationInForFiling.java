package pomplatform.workflow.personnel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnel.bean.BaseApplicationInForFiling;
import pomplatform.workflow.personnel.bean.ConditionApplicationInForFiling;

public class QueryApplicationInForFiling extends AbstractQuery<BaseApplicationInForFiling, ConditionApplicationInForFiling>
{

	private static final Logger __logger = Logger.getLogger(QueryApplicationInForFiling.class);

	public QueryApplicationInForFiling() throws java.sql.SQLException
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseApplicationInForFiling> executeQuery( KeyValuePair[] replacements, ConditionApplicationInForFiling condition ) throws java.sql.SQLException {
		return executeQuery(replacements,
				condition.getEmployeeId(),
				condition.getDrafter(),
				condition.getCompanyId(),
				condition.getEmployeeName(),
				condition.getEmployeeNo(),
				condition.getDepartmentId()
		);
	}

	@Override
	public BaseApplicationInForFiling generateBase(Object[] __data) throws java.sql.SQLException {
		BaseApplicationInForFiling __base = new BaseApplicationInForFiling();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalary1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalary2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUnit(GenericBase.__getString(val));
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
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.complete_time, A.personnel_business_id, A.process_type, A.employee_id, A.employee_no, A.department_id, A.company_id, A.attachment, A.salary_1, A.salary_2, A.unit, b.status AS emp_status FROM system_process_instances spi LEFT JOIN personnel_business A ON spi.business_id = A.personnel_business_id AND spi.process_type = A.process_type LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spi.process_status IN ( 0, 1 ) AND A.employee_id =? AND A.drafter =? AND A.company_id =? AND b.employee_name LIKE ? AND A.employee_no LIKE ? AND A.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) AND A.delete_flag = 0 AND spi.delete_flag = 0 AND A.process_type = 72" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,complete_time,personnel_business_id,process_type,employee_id,employee_no,department_id,company_id,attachment,salary_1,salary_2,unit,emp_status";
	private final static String[] fieldNames = { "employee_id", "drafter", "company_id", "employee_name", "employee_no", "department_id"};
}
