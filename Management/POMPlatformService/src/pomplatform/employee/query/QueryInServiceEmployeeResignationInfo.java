package pomplatform.employee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employee.bean.BaseInServiceEmployeeResignationInfo;
import pomplatform.employee.bean.ConditionInServiceEmployeeResignationInfo;

public class QueryInServiceEmployeeResignationInfo extends AbstractQuery<BaseInServiceEmployeeResignationInfo, ConditionInServiceEmployeeResignationInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryInServiceEmployeeResignationInfo.class);

	public QueryInServiceEmployeeResignationInfo() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseInServiceEmployeeResignationInfo> executeQuery( KeyValuePair[] replacements, ConditionInServiceEmployeeResignationInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessStatus(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseInServiceEmployeeResignationInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseInServiceEmployeeResignationInfo __base = new BaseInServiceEmployeeResignationInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select a.employee_id, a.end_date from personnel_business a LEFT JOIN employees b on a.employee_id = b.employee_id LEFT JOIN system_process_instances c on a.process_type = c.process_type and a.personnel_business_id = c.business_id where a.process_type = 25 and a.delete_flag = 0 and c.process_status = ? and b.status = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,end_date";
	private final static String[] fieldNames = { "process_status", "status"};
}
