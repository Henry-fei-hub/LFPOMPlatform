package pomplatform.cwd.softoperate.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.cwd.softoperate.bean.BaseMsoftwareoperationlogeoseedor;
import pomplatform.cwd.softoperate.bean.ConditionMsoftwareoperationlogeoseedor;

public class QueryMsoftwareoperationlogeoseedor extends AbstractQuery<BaseMsoftwareoperationlogeoseedor, ConditionMsoftwareoperationlogeoseedor>
{

	private static final Logger __logger = Logger.getLogger(QueryMsoftwareoperationlogeoseedor.class);

	public QueryMsoftwareoperationlogeoseedor() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("em.employee_no");
	}

	@Override
	public BaseCollection<BaseMsoftwareoperationlogeoseedor> executeQuery( KeyValuePair[] replacements, ConditionMsoftwareoperationlogeoseedor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getOperationType(), 
				condition.getSoftwareType(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseMsoftwareoperationlogeoseedor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMsoftwareoperationlogeoseedor __base = new BaseMsoftwareoperationlogeoseedor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSoftwareOperationLogId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperationType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMacAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIpAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMachineName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSoftwareType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLocalOperationTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLocalRequestTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCurrentVersionNo(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOriVersionNo(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT em.employee_no, em.employee_name, em.department_id, sol.software_operation_log_id, sol.operation_type, sol.mac_address, sol.ip_address, sol.machine_name, sol.software_type, sol.local_operation_time, sol.local_request_time, sol.create_time, sol.current_version_no, sol.operator, sol.ori_version_no FROM software_operation_logs sol left join employees em on sol.operator = em.employee_id WHERE sol.operation_type = ? and sol.software_type = ? and em.employee_no like ? and em.employee_name like ? and em.department_id = ? and em.status = 0 ORDER BY create_time" ;
	private final static String RESULTSETFIELDLIST = "employee_no,employee_name,department_id,software_operation_log_id,operation_type,mac_address,ip_address,machine_name,software_type,local_operation_time,local_request_time,create_time,current_version_no,operator,ori_version_no";
	private final static String[] fieldNames = { "operation_type", "software_type", "employee_no", "employee_name", "department_id"};
}
