package pomplatform.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.personnelbusiness.bean.BaseEmployeeContract;
import pomplatform.personnelbusiness.bean.ConditionEmployeeContract;

public class QueryEmployeeContract extends AbstractQuery<BaseEmployeeContract, ConditionEmployeeContract>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeContract.class);

	public QueryEmployeeContract() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("eca.employee_contract_attachment_id");
	}

	@Override
	public BaseCollection<BaseEmployeeContract> executeQuery( KeyValuePair[] replacements, ConditionEmployeeContract condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getStartDate()
			);
	}

	@Override
	public BaseEmployeeContract generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeContract __base = new BaseEmployeeContract();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeContractAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWillEnd(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
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

	private final static String __SQLText = "SELECT eca.employee_contract_attachment_id, eca.employee_id, eca.attachment_name, eca.attachment_url, eca.operate_employee_id, eca.operate_time, eca.contract_type, eca.sign_type, eca.start_date, eca.end_date, eca.will_end, eca.attachment_id, eca.employee_no, eca.department_id, eca.plate_id, eca.onboard_date, eca.employee_status, A.process_instance_id, A.process_type, A.business_id, A.business_name, A.process_id, A.process_instance_activity_id, A.process_status, A.create_time, A.complete_time FROM employee_contract_attachments eca LEFT JOIN system_process_instances A ON A.business_id = eca.employee_contract_attachment_id WHERE A.delete_flag = 0 AND A.process_type = 62 AND A.process_status IN ( 0, 1 ) AND eca.employee_id =? AND eca.start_date >?" ;
	private final static String RESULTSETFIELDLIST = "employee_contract_attachment_id,employee_id,attachment_name,attachment_url,operate_employee_id,operate_time,contract_type,sign_type,start_date,end_date,will_end,attachment_id,employee_no,department_id,plate_id,onboard_date,employee_status,process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time";
	private final static String[] fieldNames = { "employee_id", "start_date"};
}
