package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BaseRefuseListOfPreProjectReport;
import pomplatform.preProjects.bean.ConditionRefuseListOfPreProjectReport;

public class QueryRefuseListOfPreProjectReport extends AbstractQuery<BaseRefuseListOfPreProjectReport, ConditionRefuseListOfPreProjectReport>
{

	private static final Logger __logger = Logger.getLogger(QueryRefuseListOfPreProjectReport.class);

	public QueryRefuseListOfPreProjectReport() throws java.sql.SQLException
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseRefuseListOfPreProjectReport> executeQuery( KeyValuePair[] replacements, ConditionRefuseListOfPreProjectReport condition ) throws java.sql.SQLException {
		return executeQuery(replacements,
				condition.getProcessType(),
				condition.getProcessStatus(),
				condition.getProjectName(),
				condition.getProjectType(),
				condition.getStartDate(),
				condition.getEndDate(),
				condition.getEmployeeId()
		);
	}

	@Override
	public BaseRefuseListOfPreProjectReport generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRefuseListOfPreProjectReport __base = new BaseRefuseListOfPreProjectReport();
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
		if((val = __data[count++]) != null) __base.setProjectNameOne(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.employee_id, mp.project_name, case when mp.project_name=mp.project_name_one then '' else mp.project_name_one end project_name_one, mp.province, mp.city, mp.project_type, mp.customer_name, mp.project_origination, mp.contact_name, mp.contact_phone, mp.detail_address, mp.total_building_areas, C.customer_type, C.is_warehous, C.is_apply_quote, mp.info_code FROM system_process_instances spi LEFT JOIN pre_projects mp ON spi.business_id = mp.pre_project_id LEFT JOIN customers C ON mp.client_id = C.customer_id WHERE spi.process_type = ? AND spi.process_status = ? AND spi.delete_flag = 0 AND mp.project_name LIKE ? AND mp.project_type = ? AND spi.create_time BETWEEN ? AND ? AND spi.employee_id = ? ORDER BY spi.create_time desc" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,employee_id,project_name,project_name_one,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,customer_type,is_warehous,is_apply_quote,info_code";
	private final static String[] fieldNames = { "process_type", "process_status", "project_name", "project_type", "start_date", "end_date", "employee_id"};
}
