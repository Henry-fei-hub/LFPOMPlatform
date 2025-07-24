package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseOnLoadApplyListOfProductInquiry;
import pomplatform.purchase.bean.ConditionOnLoadApplyListOfProductInquiry;

public class QueryOnLoadApplyListOfProductInquiry extends AbstractQuery<BaseOnLoadApplyListOfProductInquiry, ConditionOnLoadApplyListOfProductInquiry>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfProductInquiry.class);

	public QueryOnLoadApplyListOfProductInquiry() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfProductInquiry> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfProductInquiry condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getCreateEmployeeId(), 
				condition.getMajorTitle(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadApplyListOfProductInquiry generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfProductInquiry __base = new BaseOnLoadApplyListOfProductInquiry();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.complete_time, pit.product_inquiry_total_id, pit.major_title, pit.process_type, pit.reason, pit.employee_no, pit.department_id, pit.create_employee_id, pit.create_time, pit.delete_flag, pit.remark FROM system_process_instances spi LEFT JOIN product_inquiry_totals pit ON spi.business_id = pit.product_inquiry_total_id LEFT JOIN employees b ON pit.create_employee_id = b.employee_id AND spi.process_type = pit.process_type WHERE spi.process_type = ? AND spi.process_status IN (0, 1) AND pit.create_employee_id = ? AND pit.major_title like ? AND pit.employee_no LIKE ? AND b.employee_name LIKE ? AND pit.department_id IN ( SELECT child_id FROM department_ids WHERE department_id = ? ) AND pit.delete_flag = 0 AND spi.delete_flag = 0 ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,complete_time,product_inquiry_total_id,major_title,process_type,reason,employee_no,department_id,create_employee_id,create_time,delete_flag,remark";
	private final static String[] fieldNames = { "process_type", "create_employee_id", "major_title", "employee_no", "employee_name", "department_id"};
}
