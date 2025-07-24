package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseApplyListOfPreProjectReport;
import pomplatform.preProjects.bean.ConditionApplyListOfPreProjectReport;

public class QueryApplyListOfPreProjectReport extends AbstractQuery<BaseApplyListOfPreProjectReport, ConditionApplyListOfPreProjectReport>
{

	private static final Logger __logger = Logger.getLogger(QueryApplyListOfPreProjectReport.class);

	public QueryApplyListOfPreProjectReport() throws java.sql.SQLException 
	{
		setParameterNumber(15);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseApplyListOfPreProjectReport> executeQuery( KeyValuePair[] replacements, ConditionApplyListOfPreProjectReport condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getProjectName(), 
				condition.getProjectType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeId(),
				condition.getProcessStatus(),
				condition.getProjectSalesTeam(),
				condition.getCustomerName(),
				condition.getProvince(),
				condition.getCity(),
				condition.getProjectOrigination(),
				condition.getIsOperationDepartment(),
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd() 
			);
	}

	@Override
	public BaseApplyListOfPreProjectReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseApplyListOfPreProjectReport __base = new BaseApplyListOfPreProjectReport();
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
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setClientId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerContactId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time,spi.employee_id, mp.project_name,mp.province,mp.city,mp.project_type,mp.customer_name, mp.project_origination,mp.contact_name,mp.contact_phone,mp.detail_address,mp.total_building_areas,mp.client_id ,c.customer_type,c.is_warehous, c.is_apply_quote,mp.info_code,mp.customer_contact_id FROM system_process_instances spi LEFT JOIN pre_projects mp on spi.business_id = mp.pre_project_id LEFT JOIN customers c ON mp.client_id = c.customer_id WHERE spi.process_type = ? and spi.process_status in (0,1) and mp.project_name like ? AND mp.project_type = ? AND spi.create_time BETWEEN ? AND ? AND spi.employee_id = ? AND spi.process_status =? AND mp.project_sales_team =? AND mp.customer_name LIKE ? AND mp.province =? AND mp.city =? AND mp.project_origination =? AND mp.is_operation_department =? AND mp.create_time BETWEEN ? AND ? order by spi.create_time" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,employee_id,project_name,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,client_id,customer_type,is_warehous,is_apply_quote,info_code,customer_contact_id";
	private final static String[] fieldNames = { "process_type", "project_name", "project_type", "start_date", "end_date", "process_status","employee_id","project_sales_team","customer_name","province","city","project_origination","is_operation_department","create_time_start", "create_time_end"};
}
