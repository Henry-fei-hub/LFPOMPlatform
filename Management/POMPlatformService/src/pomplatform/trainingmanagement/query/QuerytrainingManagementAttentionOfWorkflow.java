package pomplatform.trainingmanagement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.trainingmanagement.bean.BasetrainingManagementAttentionOfWorkflow;
import pomplatform.trainingmanagement.bean.ConditiontrainingManagementAttentionOfWorkflow;

public class QuerytrainingManagementAttentionOfWorkflow extends AbstractQuery<BasetrainingManagementAttentionOfWorkflow, ConditiontrainingManagementAttentionOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QuerytrainingManagementAttentionOfWorkflow.class);

	public QuerytrainingManagementAttentionOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(12);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BasetrainingManagementAttentionOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditiontrainingManagementAttentionOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getTrainingManagementId(), 
				condition.getSubject(), 
				condition.getCompereType(), 
				condition.getCompere(), 
				condition.getDepartmentId(), 
				condition.getSite(), 
				condition.getPlateId(), 
				condition.getIsSite(), 
				condition.getTrainingType(), 
				condition.getIsSend()
			);
	}

	@Override
	public BasetrainingManagementAttentionOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BasetrainingManagementAttentionOfWorkflow __base = new BasetrainingManagementAttentionOfWorkflow();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSystemProcessAttentionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrainingManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubject(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompereType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompere(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignInDelay(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignOutDelay(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCourseScore(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreatePersonId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSite(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsSite(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTrainingType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTrainingFee(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsSend(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateids(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.process_type, spa.operate_time, spa.process_comment, tm.training_management_id, tm.subject, tm.start_time, tm.end_time, tm.compere_type, tm.compere, tm.employee_id, tm.department_id, tm.sign_in_delay, tm.sign_out_delay, tm.course_score, tm.create_person_id, tm.file_manage_id, tm.site, tm.plate_id, tm.is_site, tm.training_type, tm.training_fee, tm.file_id, tm.file_url, tm.is_send, tm.plateids FROM system_process_attentions spa LEFT JOIN training_managements tm ON spa.business_id = tm.training_management_id WHERE spa.status =? AND spa.process_type = 59 AND spa.employee_id =? AND spa.delete_flag = 0 AND tm.training_management_id =? AND tm.subject LIKE ? AND tm.compere_type =? AND tm.compere LIKE ? AND tm.department_id =? AND tm.site =? AND tm.plate_id =? AND tm.is_site =? AND tm.training_type =? AND tm.is_send =? ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,process_type,operate_time,process_comment,training_management_id,subject,start_time,end_time,compere_type,compere,employee_id,department_id,sign_in_delay,sign_out_delay,course_score,create_person_id,file_manage_id,site,plate_id,is_site,training_type,training_fee,file_id,file_url,is_send,plateids";
	private final static String[] fieldNames = { "status", "employee_id", "training_management_id", "subject", "compere_type", "compere", "department_id", "site", "plate_id", "is_site", "training_type", "is_send"};
}
