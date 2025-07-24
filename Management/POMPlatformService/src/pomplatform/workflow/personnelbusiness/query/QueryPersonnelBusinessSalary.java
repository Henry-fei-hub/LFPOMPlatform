package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinessSalary;
import pomplatform.workflow.personnelbusiness.bean.ConditionPersonnelBusinessSalary;

public class QueryPersonnelBusinessSalary extends AbstractQuery<BasePersonnelBusinessSalary, ConditionPersonnelBusinessSalary>
{

	private static final Logger __logger = Logger.getLogger(QueryPersonnelBusinessSalary.class);

	public QueryPersonnelBusinessSalary() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.employee_id");
	}

	@Override
	public BaseCollection<BasePersonnelBusinessSalary> executeQuery( KeyValuePair[] replacements, ConditionPersonnelBusinessSalary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEndDate()
			);
	}

	@Override
	public BasePersonnelBusinessSalary generateBase(Object[] __data) throws java.sql.SQLException {
		BasePersonnelBusinessSalary __base = new BasePersonnelBusinessSalary();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT b.employee_id, b.end_date, cast (convert_from(decrypt(CAST(b.month_pay as bytea),CAST((select image_path from system_config where system_config_id = 2) as bytea),'aes'),'SQL_ASCII') as numeric(16,2)) as month_pay, b.type, b.personnel_business_id from system_process_instances a LEFT JOIN personnel_business b on a.process_type = 30 and a.process_type = b.process_type and a.business_id = b.personnel_business_id where a.process_status = 3 and b.is_completed = false and a.process_type = 30 and a.delete_flag = 0 and b.end_date < ?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,end_date,month_pay,type,personnel_business_id";
	private final static String[] fieldNames = { "end_date"};
}
