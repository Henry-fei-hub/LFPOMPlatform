package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadCommonOneDetailOfPlateAccount;
import pomplatform.account.bean.ConditionOnLoadCommonOneDetailOfPlateAccount;

public class QueryOnLoadCommonOneDetailOfPlateAccount extends AbstractQuery<BaseOnLoadCommonOneDetailOfPlateAccount, ConditionOnLoadCommonOneDetailOfPlateAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadCommonOneDetailOfPlateAccount.class);

	public QueryOnLoadCommonOneDetailOfPlateAccount() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("plate_id");
	}

	@Override
	public BaseCollection<BaseOnLoadCommonOneDetailOfPlateAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadCommonOneDetailOfPlateAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getBusinessTypeId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnLoadCommonOneDetailOfPlateAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadCommonOneDetailOfPlateAccount __base = new BaseOnLoadCommonOneDetailOfPlateAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT plate_id, business_id, integral, record_date, remark FROM plate_account_records WHERE plate_id = ? and business_type_id = ? and EXTRACT ( YEAR FROM record_date ) = ? and EXTRACT ( MONTH FROM record_date ) = ? ORDER BY record_date, integral DESC" ;
	private final static String RESULTSETFIELDLIST = "plate_id,integral,record_date,remark";
	private final static String[] fieldNames = { "plate_id", "business_type_id", "year", "month"};
}
