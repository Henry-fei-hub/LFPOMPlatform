package pomplatform.account.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseonLoadAccountInfoOfPlateAccount;
import pomplatform.account.bean.ConditiononLoadAccountInfoOfPlateAccount;

public class QueryonLoadAccountInfoOfPlateAccount extends AbstractQuery<BaseonLoadAccountInfoOfPlateAccount, ConditiononLoadAccountInfoOfPlateAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryonLoadAccountInfoOfPlateAccount.class);

	public QueryonLoadAccountInfoOfPlateAccount() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.plate_id");
	}

	@Override
	public BaseCollection<BaseonLoadAccountInfoOfPlateAccount> executeQuery( KeyValuePair[] replacements, ConditiononLoadAccountInfoOfPlateAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getParentId(), 
				condition.getPlateId() 
			);
	}

	@Override
	public BaseonLoadAccountInfoOfPlateAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseonLoadAccountInfoOfPlateAccount __base = new BaseonLoadAccountInfoOfPlateAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTypeParentId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select abc.plate_id,abc.business_type_id,abc.dic_type_value as business_type_name,sum(abc.integral) as integral,abc.type_parent_id FROM ( select a.plate_id,a.parent_id,b.business_type_id,c.dic_type_value,c.parent_id as type_parent_id,b.integral,b.record_date,b.operate_employee_id ,b.operate_time,b.remark from plate_records a LEFT JOIN plate_account_records b on a.plate_id = b.plate_id and b.record_date BETWEEN ? AND ? LEFT JOIN system_dictionary c on c.dic_type_id = 65 and b.business_type_id = c.dic_type_value_id where a.parent_id = ? and a.plate_id = ? ) as abc GROUP BY abc.plate_id,abc.business_type_id,abc.dic_type_value,abc.type_parent_id ORDER BY abc.plate_id,abc.type_parent_id,abc.business_type_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,business_type_id,business_type_name,integral,type_parent_id";
	private final static String[] fieldNames = { "start_date", "end_date","parent_id", "plate_id"};
}
