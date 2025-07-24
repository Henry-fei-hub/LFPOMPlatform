package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseOnLoadTaskListOfProductInquiry;
import pomplatform.purchase.bean.ConditionOnLoadTaskListOfProductInquiry;

public class QueryOnLoadTaskListOfProductInquiry extends AbstractQuery<BaseOnLoadTaskListOfProductInquiry, ConditionOnLoadTaskListOfProductInquiry>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadTaskListOfProductInquiry.class);

	public QueryOnLoadTaskListOfProductInquiry() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sppt.process_pooled_task_id");
	}

	@Override
	public BaseCollection<BaseOnLoadTaskListOfProductInquiry> executeQuery( KeyValuePair[] replacements, ConditionOnLoadTaskListOfProductInquiry condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCreateEmployeeId(), 
				condition.getMajorTitle(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadTaskListOfProductInquiry generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadTaskListOfProductInquiry __base = new BaseOnLoadTaskListOfProductInquiry();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessPooledTaskId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmpStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductInquiryTotalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMajorTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "SELECT sppt.process_pooled_task_id, sppt.business_id, sppt.business_name, sppt.process_activity_id, sppt.process_id, sppt.process_instance_id, sppt.back_view_name, sppt.node_type, sppt.activity_id, sppt.instance_activity_create_time, sppt.instance_activity_start_time, sppt.status, sppt.operate_time, sppt.process_comment, sppt.activity_type, b.status AS emp_status, pit.product_inquiry_total_id, pit.major_title, pit.process_type, pit.reason, pit.employee_no, pit.department_id, pit.create_employee_id, pit.create_time, pit.delete_flag, pit.remark FROM system_process_pooled_tasks sppt LEFT JOIN product_inquiry_totals pit ON sppt.business_id = pit.product_inquiry_total_id LEFT JOIN employees b ON pit.create_employee_id = b.employee_id AND sppt.process_type = pit.process_type WHERE sppt.status = ? AND sppt.process_type = ? AND sppt.employee_id = ? AND pit.create_employee_id = ? AND pit.major_title like ? AND pit.employee_no LIKE ? AND b.employee_name LIKE ? AND pit.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) AND pit.delete_flag = 0 ORDER BY sppt.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_pooled_task_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,node_type,activity_id,instance_activity_create_time,instance_activity_start_time,status,operate_time,process_comment,activity_type,emp_status,product_inquiry_total_id,major_title,process_type,reason,employee_no,department_id,create_employee_id,create_time,delete_flag,remark";
	private final static String[] fieldNames = { "status", "process_type", "employee_id", "create_employee_id", "major_title", "employee_no", "employee_name", "department_id"};
}
