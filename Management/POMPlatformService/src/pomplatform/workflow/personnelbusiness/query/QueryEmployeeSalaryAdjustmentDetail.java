package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeSalaryAdjustmentDetail;
import pomplatform.workflow.personnelbusiness.bean.ConditionEmployeeSalaryAdjustmentDetail;

public class QueryEmployeeSalaryAdjustmentDetail extends AbstractQuery<BaseEmployeeSalaryAdjustmentDetail, ConditionEmployeeSalaryAdjustmentDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeSalaryAdjustmentDetail.class);

	public QueryEmployeeSalaryAdjustmentDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeSalaryAdjustmentDetail> executeQuery( KeyValuePair[] replacements, ConditionEmployeeSalaryAdjustmentDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId(), 
				condition.getEmployeeId(),
				condition.getAuditor()
			);
	}

	@Override
	public BaseEmployeeSalaryAdjustmentDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeSalaryAdjustmentDetail __base = new BaseEmployeeSalaryAdjustmentDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTargetProvince(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setFee(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOriginalPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSeverance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMessageStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT b.employee_id, b.employee_no, b.target_province, b.department_id, b.start_date, b.end_date, b.fee, convert_from(decrypt(CAST(b.original_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as original_pay, b.severance, convert_from(decrypt(CAST(b.month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as month_pay, b.sub_type, b.personnel_business_id, a.process_type, a.process_id, a.process_instance_id, a.business_id, a.process_instance_activity_id, a.process_activity_id, a.activity_type, a.node_type, a.activity_id, a.next_activity_id, a.main_activity_id, a.status, a.delete_flag, a.message_status, a.business_name, a.back_view_name, a.instance_activity_create_time, a.instance_activity_start_time,b.remark from system_process_instance_activities a LEFT JOIN personnel_business b on a.process_type = b.process_type and a.business_id = b.personnel_business_id and b.delete_flag = 0 where a.delete_flag = 0 and a.process_type = 30 and a.status = 1 and a.activity_type in(2,3) and a.employee_id is not null and (extract(year from b.end_date)) = ? and (extract(month from b.end_date)) = ? and b.target_province = ? and b.employee_id = ? and a.employee_id = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,target_province,department_id,start_date,end_date,fee,original_pay,severance,month_pay,sub_type,personnel_business_id,process_type,process_id,process_instance_id, business_id, process_instance_activity_id, process_activity_id, activity_type, node_type, activity_id, next_activity_id, main_activity_id, status, delete_flag, message_status, business_name, back_view_name, instance_activity_create_time, instance_activity_start_time,remark ";
	private final static String[] fieldNames = { "year", "month", "plate_id", "employee_id", "auditor"};
}
