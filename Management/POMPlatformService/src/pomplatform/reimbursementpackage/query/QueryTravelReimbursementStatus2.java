package pomplatform.reimbursementpackage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.reimbursementpackage.bean.BaseTravelReimbursementStatus2;
import pomplatform.reimbursementpackage.bean.ConditionTravelReimbursementStatus2;

public class QueryTravelReimbursementStatus2 extends AbstractQuery<BaseTravelReimbursementStatus2, ConditionTravelReimbursementStatus2>
{

	private static final Logger __logger = Logger.getLogger(QueryTravelReimbursementStatus2.class);

	public QueryTravelReimbursementStatus2() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spia.process_type");
	}

	@Override
	public BaseCollection<BaseTravelReimbursementStatus2> executeQuery( KeyValuePair[] replacements, ConditionTravelReimbursementStatus2 condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getDepartmentId(), 
				condition.getCode()
			);
	}

	@Override
	public BaseTravelReimbursementStatus2 generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTravelReimbursementStatus2 __base = new BaseTravelReimbursementStatus2();
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

	private final static String __SQLText = "select spia.process_type, spia.business_id, spia.process_activity_id, spia.process_id , spia.process_instance_id, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.process_comment, spia.status , a.code, a.applicant as employee_id, a.department_id , a.amount,a.company_id , spia.operate_time, spia.activity_type from system_process_instance_activities spia left join travel_reimbursements a on spia.business_id = a.travel_reimbursement_id LEFT JOIN system_process_instances spi ON spia.process_instance_id = spi.process_instance_id where spi.process_status NOT IN (3) and spia.process_type= ? and spia.status = 2 and spia.employee_id = ? and spia.activity_type in(2,3) and a.be_packed = false and a.company_id = ? and a.department_id in(select child_id from department_ids where department_id = ?) and a.code like ? and spia.delete_flag = 0 and spia.back_view_name like '财务经理' and a.delete_flag = 0" ;
	private final static String RESULTSETFIELDLIST = "process_type,business_id,process_activity_id,process_id,process_instance_id,activity_id,next_activity_id,main_activity_id,process_comment,status,code,employee_id,department_id,amount,company_id,operate_time,activity_type";
	private final static String[] fieldNames = { "process_type", "employee_id", "company_id", "department", "code"};
}
