package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseGetResignationIntegral;
import pomplatform.workflow.personnelbusiness.bean.ConditionGetResignationIntegral;

public class QueryGetResignationIntegral extends AbstractQuery<BaseGetResignationIntegral, ConditionGetResignationIntegral>
{

	private static final Logger __logger = Logger.getLogger(QueryGetResignationIntegral.class);

	public QueryGetResignationIntegral() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseGetResignationIntegral> executeQuery( KeyValuePair[] replacements, ConditionGetResignationIntegral condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartMonth(),
				condition.getEndMonth(),
				condition.getPlateId(), 
				condition.getStartDate(),
				condition.getEndDate()
			);
	}

	@Override
	public BaseGetResignationIntegral generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetResignationIntegral __base = new BaseGetResignationIntegral();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setFee(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "SELECT aa.employee_id, aa.end_date, case when aa.num = 0 then aa.fee else 0 end as fee from (SELECT a.employee_id, a.fee, a.end_date, count(d.employee_account_record_id) as num from personnel_business a LEFT JOIN departments b on a.department_id = b.department_id LEFT JOIN system_process_instances c on a.personnel_business_id = c.business_id LEFT JOIN employee_account_records d on a.employee_id = d.employee_id and d.business_type_id = 8 and extract(year from a.end_date) = extract(year from d.record_date) and extract(month from d.record_date) >= ? and extract(month from d.record_date) < ? where c.process_type = 25 and c.delete_flag = 0 and c.process_status = 3 and b.plate_id = ? and a.end_date >= ? and a.end_date < ? group by a.employee_id, a.fee, a.end_date) aa order by aa.employee_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,end_date,fee";
	private final static String[] fieldNames = { "start_month", "end_month", "plate_id", "start_date", "end_date"};
}
