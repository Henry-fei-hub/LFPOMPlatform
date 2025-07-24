package pomplatform.trainingmanagement.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.trainingmanagement.bean.BaseTrainingManagementInformation;
import pomplatform.trainingmanagement.bean.ConditionTrainingManagementInformation;

public class QueryTrainingManagementInformation extends AbstractQuery<BaseTrainingManagementInformation, ConditionTrainingManagementInformation>
{

	private static final Logger __logger = Logger.getLogger(QueryTrainingManagementInformation.class);

	public QueryTrainingManagementInformation() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("tm.training_management_id");
	}

	@Override
	public BaseCollection<BaseTrainingManagementInformation> executeQuery( KeyValuePair[] replacements, ConditionTrainingManagementInformation condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSubject(), 
				condition.getTrainingManagementId(), 
				condition.getCompereType(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getCreatePersonId(), 
				condition.getStatus(), 
				condition.getPlateId(), 
				condition.getIsSite(), 
				condition.getTrainingType(), 
				condition.getIsSend()
			);
	}

	@Override
	public BaseTrainingManagementInformation generateBase(Object[] __data) throws java.sql.SQLException {
		BaseTrainingManagementInformation __base = new BaseTrainingManagementInformation();
		int count = 0;
		Object val;
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
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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
		if((val = __data[count++]) != null) __base.setDepartmentids(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
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

	private final static String __SQLText = "select tm.training_management_id, tm.subject, tm.start_time, tm.end_time, tm.compere_type, tm.compere, tm.employee_id, tm.department_id, tm.sign_in_delay, tm.sign_out_delay, tm.course_score, tm.detail, tm.create_person_id, tm.create_time, tm.file_manage_id, tm.status, tm.site, tm.plate_id, tm.is_site, tm.training_type, tm.training_fee, tm.file_id, tm.file_url, tm.is_send, tm.plateids, tm.departmentids from training_managements tm where tm.subject like ? and tm.training_management_id = ? and tm.compere_type = ? and tm.employee_id = ? and tm.department_id = ? and tm.create_person_id = ? and tm.status = ? and tm.plate_id = ? and tm.is_site = ? and tm.training_type = ? and tm.is_send = ?" ;
	private final static String RESULTSETFIELDLIST = "training_management_id,subject,start_time,end_time,compere_type,compere,employee_id,department_id,sign_in_delay,sign_out_delay,course_score,detail,create_person_id,create_time,file_manage_id,status,site,plate_id,is_site,training_type,training_fee,file_id,file_url,is_send,plateids,departmentids";
	private final static String[] fieldNames = { "subject", "training_management_id", "compere_type", "employee_id", "department_id", "create_person_id", "status", "plate_id", "is_site", "training_type", "is_send"};
}
