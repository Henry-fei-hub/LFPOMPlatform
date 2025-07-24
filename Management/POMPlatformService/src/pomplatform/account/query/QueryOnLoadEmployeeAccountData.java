package pomplatform.account.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadEmployeeAccountData;
import pomplatform.account.bean.ConditionOnLoadEmployeeAccountData;

public class QueryOnLoadEmployeeAccountData extends AbstractQuery<BaseOnLoadEmployeeAccountData, ConditionOnLoadEmployeeAccountData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadEmployeeAccountData.class);

	public QueryOnLoadEmployeeAccountData() throws java.sql.SQLException 
	{
		setParameterNumber(9);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseOnLoadEmployeeAccountData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadEmployeeAccountData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getBusinessTypeId(),
				condition.getPlateId(),
				condition.getStatus()
			);
	}

	@Override
	public BaseOnLoadEmployeeAccountData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadEmployeeAccountData __base = new BaseOnLoadEmployeeAccountData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "select b.employee_id,a.business_id,c.plate_id,b.employee_no,b.employee_name,a.business_type_id,a.integral,a.record_date,b.status,d.dic_type_value as business_type_name,b.grade_id from employees b LEFT JOIN employee_account_records A ON b.employee_id = A.employee_id AND A.record_date BETWEEN ? and ? LEFT JOIN employee_day_plate_records C ON b.employee_id = C.employee_id AND A.record_date = C.record_date left join system_dictionary d on dic_type_id = 66 and a.business_type_id = d.dic_type_value_id where b.employee_no like ? and b.employee_name like ? and c.plate_id =? and b.employee_id =? and a.business_type_id = ? and b.plate_id = ? and b.status = ? and b.employee_id > 0 ORDER BY c.plate_id,b.employee_id,a.business_type_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,business_id,plate_id,employee_no,employee_name,business_type_id,integral,record_date,status,business_type_name,grade_id";
	private final static String[] fieldNames = { "start_date", "end_date", "employee_no", "employee_name", "plate_id", "employee_id", "business_type_id","plate_id","status"};
}
