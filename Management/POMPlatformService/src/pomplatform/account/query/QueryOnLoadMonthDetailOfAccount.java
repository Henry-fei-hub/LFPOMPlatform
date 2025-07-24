package pomplatform.account.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadMonthDetailOfAccount;
import pomplatform.account.bean.ConditionOnLoadMonthDetailOfAccount;

public class QueryOnLoadMonthDetailOfAccount extends AbstractQuery<BaseOnLoadMonthDetailOfAccount, ConditionOnLoadMonthDetailOfAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadMonthDetailOfAccount.class);

	public QueryOnLoadMonthDetailOfAccount() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("account_type_id");
	}

	@Override
	public BaseCollection<BaseOnLoadMonthDetailOfAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadMonthDetailOfAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountTypeId(), 
				condition.getAccountId(), 
				condition.getBusinessTypeId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnLoadMonthDetailOfAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadMonthDetailOfAccount __base = new BaseOnLoadMonthDetailOfAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAccountTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPayIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select account_type_id,account_id,business_type_id,achieve_integral,pay_integral,record_date,operate_employee_id,operate_time,remark from account_records where account_type_id = ? and account_id = ? and business_type_id = ? and EXTRACT(YEAR from record_date) = ? and EXTRACT(MONTH from record_date) = ? ORDER BY record_date" ;
	private final static String RESULTSETFIELDLIST = "account_type_id,account_id,business_type_id,achieve_integral,pay_integral,record_date,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "account_type_id", "account_id", "business_type_id", "year", "month"};
}
