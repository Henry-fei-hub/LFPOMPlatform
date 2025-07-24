package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseCollaborativeFeeDetailOfPlateAccount;
import pomplatform.account.bean.ConditionCollaborativeFeeDetailOfPlateAccount;

public class QueryCollaborativeFeeDetailOfPlateAccount extends AbstractQuery<BaseCollaborativeFeeDetailOfPlateAccount, ConditionCollaborativeFeeDetailOfPlateAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryCollaborativeFeeDetailOfPlateAccount.class);

	public QueryCollaborativeFeeDetailOfPlateAccount() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.from_plate_id");
	}

	@Override
	public BaseCollection<BaseCollaborativeFeeDetailOfPlateAccount> executeQuery( KeyValuePair[] replacements, ConditionCollaborativeFeeDetailOfPlateAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getBusinessTypeId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseCollaborativeFeeDetailOfPlateAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCollaborativeFeeDetailOfPlateAccount __base = new BaseCollaborativeFeeDetailOfPlateAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFromPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setToPlateId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select b.from_plate_id, b.to_plate_id, a.integral, a.record_date, a.remark from plate_account_records a LEFT JOIN plate_integral_achieves b on a.business_id = b.plate_integral_achieve_id where a.plate_id = ? and a.business_type_id = ? and extract(year from a.record_date) = ? and extract(month from a.record_date) = ? order by a.record_date" ;
	private final static String RESULTSETFIELDLIST = "from_plate_id,to_plate_id,integral,record_date,remark";
	private final static String[] fieldNames = { "plate_id", "business_type_id", "year", "month"};
}
