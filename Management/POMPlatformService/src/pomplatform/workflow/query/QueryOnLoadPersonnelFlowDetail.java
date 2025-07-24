package pomplatform.workflow.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.bean.BaseOnLoadPersonnelFlowDetail;
import pomplatform.workflow.bean.ConditionOnLoadPersonnelFlowDetail;

public class QueryOnLoadPersonnelFlowDetail extends AbstractQuery<BaseOnLoadPersonnelFlowDetail, ConditionOnLoadPersonnelFlowDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadPersonnelFlowDetail.class);

	public QueryOnLoadPersonnelFlowDetail() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("aa.activity_type");
	}

	@Override
	public BaseCollection<BaseOnLoadPersonnelFlowDetail> executeQuery( KeyValuePair[] replacements, ConditionOnLoadPersonnelFlowDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getEmployeeId(), 
				condition.getParentProcessTypeId(), 
				condition.getActivityType(), 
				condition.getProcessType(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadPersonnelFlowDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadPersonnelFlowDetail __base = new BaseOnLoadPersonnelFlowDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlan(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTransportation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFee(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
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
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "select aa.activity_type,aa.business_name,aa.business_id,aa.process_instance_id,aa.process_id,d.employee_name,d.status,c.* from ( select case when a.display_type = 1 and a.status = 0 then 1 when a.display_type = 1 and a.status = 1 then 2 when a.display_type = 1 and a.status = 2 then 3 when a.display_type = 2 and a.status = 1 then 4 when a.display_type = 2 and a.status = 2 then 7 when a.display_type = 3 and a.status = 1 then 5 when a.display_type = 3 and a.status = 2 then 8 when a.display_type = 4 and a.status = 1 then 6 when a.display_type = 4 and a.status = 2 then 9 end as activity_type,a.process_type,a.business_id,a.process_instance_id,a.process_id,a.status, b.process_type_name as business_name from ( select 1 as display_type, process_type, case when process_status = 0 or process_status = 1 then 0 when process_status = 5 then 1 when process_status = 3 then 2 end as status,business_id,process_instance_id,process_id from system_process_instances where delete_flag = 0 and employee_id = ? union select 2 as display_type,process_type, status,business_id,process_instance_id,process_id from system_process_instance_activities where activity_type in (2,3) and status in (1,2) and delete_flag = 0 and employee_id = ? union select 3 as display_type,process_type, status,business_id,process_instance_id,process_id from system_process_attentions where status in (1,2) and delete_flag = 0 and employee_id = ? union select 4 as display_type,process_type, status,business_id,process_instance_id,process_id from system_process_pooled_tasks where status in (1,2) and delete_flag = 0 and employee_id = ? ) as a left join system_process_types b on a.process_type = b.process_type_id where b.parent_process_type_id = ? ) as aa left join personnel_business c on aa.process_type = c.process_type and aa.business_id = c.personnel_business_id left join employees d on c.employee_id = d.employee_id where aa.activity_type = ? and aa.process_type =? and d.employee_name like ? and c.employee_no like ? and c.department_id in(select child_id from department_ids where department_id = ?) order by aa.activity_type, aa.process_type,aa.status,c.create_time desc" ;
	private final static String RESULTSETFIELDLIST = "activity_type,business_name,business_id,process_instance_id,process_id,employee_name,status,personnel_business_id,process_type,employee_id,employee_no,department_id,company_id,type,start_date,start_date_detail,end_date,end_date_detail,days,reason,remark,address,plan,transportation,fee,unit,contact_person,create_time,delete_flag";
	private final static String[] fieldNames = { "employee_id", "employee_id", "employee_id", "employee_id", "parent_process_type_id", "activity_type", "process_type", "employee_name", "employee_no", "department_id"};
}
