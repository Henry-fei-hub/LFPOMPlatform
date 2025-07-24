package pomplatform.capitalDsitributionemployee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitalDsitributionemployee.bean.BaseMemployeeaccountrecordespemmor;
import pomplatform.capitalDsitributionemployee.bean.ConditionMemployeeaccountrecordespemmor;

public class QueryMemployeeaccountrecordespemmor extends AbstractQuery<BaseMemployeeaccountrecordespemmor, ConditionMemployeeaccountrecordespemmor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeaccountrecordespemmor.class);

	public QueryMemployeeaccountrecordespemmor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.employee_id");
	}

	@Override
	public BaseCollection<BaseMemployeeaccountrecordespemmor> executeQuery( KeyValuePair[] replacements, ConditionMemployeeaccountrecordespemmor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getMinRecordDate(), 
				condition.getMaxRecordDate()
			);
	}

	@Override
	public BaseMemployeeaccountrecordespemmor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeaccountrecordespemmor __base = new BaseMemployeeaccountrecordespemmor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDicTypeValue(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
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

	private final static String __SQLText = "select a.employee_id,a.business_type_id,c.dic_type_value, case when c.parent_id = -1 then 2 else 1 end as type ,case when c.parent_id = -1 then -sum(a.integral) else sum(a.integral) end as integral from employee_account_records a left join employee_change_plate_records b on a.employee_id = b.employee_id and EXTRACT(YEAR from a.record_date) = b.year and EXTRACT(MONTH from a.record_date) = b.month left join system_dictionary c on a.business_type_id = c.dic_type_value_id and dic_type_id = 65 where b.plate_id = ? and a.employee_id = ? AND a.record_date BETWEEN ? AND ? GROUP BY a.employee_id,a.business_type_id,c.dic_type_value,c.parent_id ORDER BY a.employee_id,a.business_type_id" ;
	private final static String RESULTSETFIELDLIST = "employee_id,business_type_id,dic_type_value,type,integral";
	private final static String[] fieldNames = { "plate_id", "employee_id", "min_record_date", "max_record_date"};
}
