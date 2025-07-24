package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseEmployeeMoneyApplyOfWorkflow;
import pomplatform.workflow.bean.ConditionEmployeeMoneyApplyOfWorkflow;

public class QueryEmployeeMoneyApplyOfWorkflow extends AbstractQuery<BaseEmployeeMoneyApplyOfWorkflow, ConditionEmployeeMoneyApplyOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeMoneyApplyOfWorkflow.class);

	public QueryEmployeeMoneyApplyOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseEmployeeMoneyApplyOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionEmployeeMoneyApplyOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getCode()
			);
	}

	@Override
	public BaseEmployeeMoneyApplyOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeMoneyApplyOfWorkflow __base = new BaseEmployeeMoneyApplyOfWorkflow();
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
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
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

	private final static String __SQLText = "select spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id ,spi.process_status, spi.create_time, spi.complete_time,a.department_id,a.employee_id,a.borrow_money,a.code,a.company_id, a.reason from system_process_instances spi left join employee_money_manages a on spi.business_id = a.employee_money_manage_id where process_type=6 and spi.process_status in(0,1) and a.employee_id = ? and a.company_id = ? and a.department_id in(select child_id from department_ids where department_id = ?) and a.code like ? and spi.delete_flag = 0 order by create_time desc" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,department_id,employee_id,borrow_money,code,company_id,reason";
	private final static String[] fieldNames = { "employee_id", "company_id", "department_id", "code"};
}
