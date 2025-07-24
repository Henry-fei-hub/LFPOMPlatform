package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BasePayMoneyApplyOfWorkflow;
import pomplatform.workflow.bean.ConditionPayMoneyApplyOfWorkflow;

public class QueryPayMoneyApplyOfWorkflow extends AbstractQuery<BasePayMoneyApplyOfWorkflow, ConditionPayMoneyApplyOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QueryPayMoneyApplyOfWorkflow.class);

	public QueryPayMoneyApplyOfWorkflow() throws java.sql.SQLException
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BasePayMoneyApplyOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditionPayMoneyApplyOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements,
				condition.getEmployeeId(),
				condition.getCompanyId(),
				condition.getDepartmentId(),
				condition.getCode(),
				condition.getReason()
		);
	}

	@Override
	public BasePayMoneyApplyOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BasePayMoneyApplyOfWorkflow __base = new BasePayMoneyApplyOfWorkflow();
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
		if((val = __data[count++]) != null) __base.setPayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayMoneyManageId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, A.department_id, A.employee_id, A.pay_amount, A.code, A.company_id, A.reason, A.pay_money_manage_id FROM system_process_instances spi LEFT JOIN pay_money_manages A ON spi.business_id = A.pay_money_manage_id WHERE process_type = 7 AND spi.process_status IN ( 0, 1 ) AND A.employee_id = ? AND A.company_id = ? AND A.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) AND A.code LIKE ? AND spi.delete_flag = 0 AND A.reason LIKE ? ORDER BY create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,department_id,employee_id,pay_amount,code,company_id,reason,pay_money_manage_id";
	private final static String[] fieldNames = { "employee_id", "company_id", "department_id", "code", "reason"};
}
