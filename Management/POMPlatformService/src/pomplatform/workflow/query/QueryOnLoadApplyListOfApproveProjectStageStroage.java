package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseOnLoadApplyListOfApproveProjectStageStroage;
import pomplatform.workflow.bean.ConditionOnLoadApplyListOfApproveProjectStageStroage;

public class QueryOnLoadApplyListOfApproveProjectStageStroage extends AbstractQuery<BaseOnLoadApplyListOfApproveProjectStageStroage, ConditionOnLoadApplyListOfApproveProjectStageStroage>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfApproveProjectStageStroage.class);

	public QueryOnLoadApplyListOfApproveProjectStageStroage() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.*");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfApproveProjectStageStroage> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfApproveProjectStageStroage condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getProcessType(), 
				condition.getProjectId(), 
				condition.getDepartmentManagerId(), 
				condition.getProjectManageId(), 
				condition.getPlateId(), 
				condition.getProjectName(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo()
			);
	}

	@Override
	public BaseOnLoadApplyListOfApproveProjectStageStroage generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfApproveProjectStageStroage __base = new BaseOnLoadApplyListOfApproveProjectStageStroage();
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
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApproveProjectStageStorageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
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

	private final static String __SQLText = "SELECT spi.*, A.*, b.status AS emp_status FROM system_process_instances spi LEFT JOIN approve_project_stage_storages A ON spi.business_id = A.approve_project_stage_storage_id  LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spi.employee_id =? AND spi.process_type =? AND A.project_id =? AND A.department_manager_id =? AND A.project_manage_id =? AND A.plate_id =? AND A.project_name LIKE ? AND b.employee_name LIKE ? AND b.employee_no LIKE ? AND spi.process_status IN ( 0, 1 ) AND A.delete_flag =0 AND spi.delete_flag =0 ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,employee_id,create_time,complete_time,delete_flag,other_operation,project_id,contract_code,project_code,project_name,project_type,plate_id,project_manage_id,plate_manager_id,department_manager_id,approve_project_stage_storage_id,process_type,delete_flag,create_time,employee_id,emp_status";
	private final static String[] fieldNames = { "employee_id", "process_type", "project_id", "department_manager_id", "project_manage_id", "plate_id", "project_name", "employee_name", "employee_no"};
}
