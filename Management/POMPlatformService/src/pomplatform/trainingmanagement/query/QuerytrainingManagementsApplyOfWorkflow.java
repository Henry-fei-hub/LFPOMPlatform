package pomplatform.trainingmanagement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.trainingmanagement.bean.BasetrainingManagementsApplyOfWorkflow;
import pomplatform.trainingmanagement.bean.ConditiontrainingManagementsApplyOfWorkflow;

public class QuerytrainingManagementsApplyOfWorkflow extends AbstractQuery<BasetrainingManagementsApplyOfWorkflow, ConditiontrainingManagementsApplyOfWorkflow>
{

	private static final Logger __logger = Logger.getLogger(QuerytrainingManagementsApplyOfWorkflow.class);

	public QuerytrainingManagementsApplyOfWorkflow() throws java.sql.SQLException 
	{
		setParameterNumber(18);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BasetrainingManagementsApplyOfWorkflow> executeQuery( KeyValuePair[] replacements, ConditiontrainingManagementsApplyOfWorkflow condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getTrainingManagementId(), 
				condition.getSubject(), 
				condition.getCompereType(), 
				condition.getCompere(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getSignInDelay(), 
				condition.getSignOutDelay(), 
				condition.getDetail(), 
				condition.getCreatePersonId(), 
				condition.getFileManageId(), 
				condition.getStatus(), 
				condition.getSite(), 
				condition.getPlateId(), 
				condition.getIsSite(), 
				condition.getTrainingType(), 
				condition.getFileId(), 
				condition.getIsSend()
			);
	}

	@Override
	public BasetrainingManagementsApplyOfWorkflow generateBase(Object[] __data) throws java.sql.SQLException {
		BasetrainingManagementsApplyOfWorkflow __base = new BasetrainingManagementsApplyOfWorkflow();
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
		if((val = __data[count++]) != null) __base.setDetail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreatePersonId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setInt(count++, GenericBase.__getInt(args[13]));
		if(args[14] != null) __statement.setInt(count++, GenericBase.__getInt(args[14]));
		if(args[15] != null) __statement.setInt(count++, GenericBase.__getInt(args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
		if(args[17] != null) __statement.setInt(count++, GenericBase.__getInt(args[17]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, tm.training_management_id, tm.subject, tm.start_time, tm.end_time, tm.compere_type, tm.compere, tm.employee_id, tm.department_id, tm.sign_in_delay, tm.sign_out_delay, tm.course_score, tm.detail, tm.create_person_id, tm.file_manage_id, tm.status, tm.site, tm.plate_id, tm.is_site, tm.training_type, tm.training_fee, tm.file_id, tm.file_url, tm.is_send, tm.plateids FROM system_process_instances spi LEFT JOIN training_managements tm ON spi.business_id = tm.training_management_id WHERE spi.process_type = 59 AND spi.process_status IN ( 0, 1 ) AND spi.delete_flag = 0 AND tm.training_management_id =? AND tm.subject like ? AND tm.compere_type =? AND tm.compere like ? AND tm.employee_id =? AND tm.department_id =? AND tm.sign_in_delay =? AND tm.sign_out_delay =? AND tm.detail like ? AND tm.create_person_id =? AND tm.file_manage_id =? AND tm.status =? AND tm.site =? AND tm.plate_id =? AND tm.is_site =? AND tm.training_type =? AND tm.file_id =? AND tm.is_send =? ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,training_management_id,subject,start_time,end_time,compere_type,compere,employee_id,department_id,sign_in_delay,sign_out_delay,course_score,detail,create_person_id,file_manage_id,status,site,plate_id,is_site,training_type,training_fee,file_id,file_url,is_send,plateids";
	private final static String[] fieldNames = { "training_management_id", "subject", "compere_type", "compere", "employee_id", "department_id", "sign_in_delay", "sign_out_delay", "detail", "create_person_id", "file_manage_id", "status", "site", "plate_id", "is_site", "training_type", "file_id", "is_send"};
}
