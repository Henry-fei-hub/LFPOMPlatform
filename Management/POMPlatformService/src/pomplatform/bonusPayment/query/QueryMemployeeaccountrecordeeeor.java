package pomplatform.bonusPayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.bonusPayment.bean.BaseMemployeeaccountrecordeeeor;
import pomplatform.bonusPayment.bean.ConditionMemployeeaccountrecordeeeor;

public class QueryMemployeeaccountrecordeeeor extends AbstractQuery<BaseMemployeeaccountrecordeeeor, ConditionMemployeeaccountrecordeeeor>
{

	private static final Logger __logger = Logger.getLogger(QueryMemployeeaccountrecordeeeor.class);

	public QueryMemployeeaccountrecordeeeor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BaseMemployeeaccountrecordeeeor> executeQuery( KeyValuePair[] replacements, ConditionMemployeeaccountrecordeeeor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseMemployeeaccountrecordeeeor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMemployeeaccountrecordeeeor __base = new BaseMemployeeaccountrecordeeeor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeAccountRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsLock(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = " SELECT * FROM employee_account_records WHERE employee_id =? AND record_date NOT IN ( SELECT record_date FROM employee_day_plate_records WHERE employee_id =? )" ;
	private final static String RESULTSETFIELDLIST = "employee_account_record_id,employee_id,plate_id,business_id,business_type_id,integral,record_date,is_lock,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "employee_id", "employee_id"};
}
