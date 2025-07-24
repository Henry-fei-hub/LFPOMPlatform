package pomplatform.workflow.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.operation.bean.BaseOnLoadApplyListOfCostAllocationNew;
import pomplatform.workflow.operation.bean.ConditionOnLoadApplyListOfCostAllocationNew;

public class QueryOnLoadApplyListOfCostAllocationNew extends AbstractQuery<BaseOnLoadApplyListOfCostAllocationNew, ConditionOnLoadApplyListOfCostAllocationNew>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfCostAllocationNew.class);

	public QueryOnLoadApplyListOfCostAllocationNew() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("P .customer_name");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfCostAllocationNew> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfCostAllocationNew condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadApplyListOfCostAllocationNew generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfCostAllocationNew __base = new BaseOnLoadApplyListOfCostAllocationNew();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTransferEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreProjectTransferRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT P .customer_name, P .project_name, P .province, P .city, spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, ppr.employee_id, ppr.transfer_employee_id, ppr.pre_project_id, ppr.pre_project_transfer_record_id, ppr.operate_time FROM system_process_instances spi LEFT JOIN pre_project_transfer_records ppr ON spi.business_id = ppr.pre_project_transfer_record_id LEFT JOIN pre_projects P ON P .pre_project_id = ppr.pre_project_id WHERE spi.process_type = ? AND spi.process_status IN (0, 1) AND spi.delete_flag = 0 AND spi.employee_id = ? ORDER BY spi.create_time" ;
	private final static String RESULTSETFIELDLIST = "customer_name,project_name,province,city,process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,employee_id,transfer_employee_id,pre_project_id,pre_project_transfer_record_id,operate_time";
	private final static String[] fieldNames = { "process_type", "employee_id"};
}
