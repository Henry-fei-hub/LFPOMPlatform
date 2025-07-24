package pomplatform.attachment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.attachment.bean.BaseMpersonnelbusinessdddemmpor;
import pomplatform.attachment.bean.ConditionMpersonnelbusinessdddemmpor;

public class QueryMpersonnelbusinessdddemmpor extends AbstractQuery<BaseMpersonnelbusinessdddemmpor, ConditionMpersonnelbusinessdddemmpor>
{

	private static final Logger __logger = Logger.getLogger(QueryMpersonnelbusinessdddemmpor.class);

	public QueryMpersonnelbusinessdddemmpor() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.personnel_business_id");
	}

	@Override
	public BaseCollection<BaseMpersonnelbusinessdddemmpor> executeQuery( KeyValuePair[] replacements, ConditionMpersonnelbusinessdddemmpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDeleteFlag(), 
				condition.getDrafter(), 
				condition.getDepartmentId(), 
				condition.getEmployeeNo(), 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getProcessStatus()
			);
	}

	@Override
	public BaseMpersonnelbusinessdddemmpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMpersonnelbusinessdddemmpor __base = new BaseMpersonnelbusinessdddemmpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFee(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlan(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsRemoteCity(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOtherOperation(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
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

	private final static String __SQLText = " SELECT pb.personnel_business_id, pb.drafter, pb.employee_id, pb.employee_no, pb.department_id, pb.company_id, pb.reason, pb.attachment, pb.project_id, pb.fee, pb.remark, pb.plan, pb.is_remote_city, pb.project_code, pb.project_name, pb.create_time, spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.complete_time, spi.delete_flag, spi.other_operation FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.process_type = pb.process_type AND pb.personnel_business_id = spi.business_id WHERE pb.process_type = 27 AND spi.delete_flag = ? AND pb.drafter = ? AND pb.department_id = ? AND pb.employee_no LIKE ? AND pb.create_time BETWEEN ? AND ? AND spi.process_status = ?" ;
	private final static String RESULTSETFIELDLIST = "personnel_business_id,drafter,employee_id,employee_no,department_id,company_id,reason,attachment,project_id,fee,remark,plan,is_remote_city,project_code,project_name,create_time,process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,complete_time,delete_flag,other_operation";
	private final static String[] fieldNames = { "delete_flag", "drafter", "department_id", "employee_no", "min_create_time", "max_create_time", "process_status"};
}
