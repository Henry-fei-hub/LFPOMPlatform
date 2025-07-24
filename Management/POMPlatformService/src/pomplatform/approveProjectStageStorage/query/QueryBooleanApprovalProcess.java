package pomplatform.approveProjectStageStorage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.approveProjectStageStorage.bean.BaseBooleanApprovalProcess;
import pomplatform.approveProjectStageStorage.bean.ConditionBooleanApprovalProcess;

public class QueryBooleanApprovalProcess extends AbstractQuery<BaseBooleanApprovalProcess, ConditionBooleanApprovalProcess>
{

	private static final Logger __logger = Logger.getLogger(QueryBooleanApprovalProcess.class);

	public QueryBooleanApprovalProcess() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.*");
	}

	@Override
	public BaseCollection<BaseBooleanApprovalProcess> executeQuery( KeyValuePair[] replacements, ConditionBooleanApprovalProcess condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getProjectId(), 
				condition.getEmployeeNo()
			);
	}

	@Override
	public BaseBooleanApprovalProcess generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBooleanApprovalProcess __base = new BaseBooleanApprovalProcess();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "SELECT spi.* FROM system_process_instances spi LEFT JOIN approve_project_stage_storages A ON spi.business_id = A.approve_project_stage_storage_id AND spi.process_type = A.process_type LEFT JOIN employees b ON A.employee_id = b.employee_id where spi.process_type =? AND A.project_id=? AND b.employee_no like ? AND A.delete_flag = 0 AND spi.delete_flag = 0  ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,employee_id,create_time,complete_time,delete_flag,other_operation";
	private final static String[] fieldNames = { "process_type", "project_id", "employee_no"};
}
