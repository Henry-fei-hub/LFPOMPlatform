package pomplatform.account.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.account.bean.BaseOnLoadProjectSettlementDetailOfPlateAccount;
import pomplatform.account.bean.ConditionOnLoadProjectSettlementDetailOfPlateAccount;

public class QueryOnLoadProjectSettlementDetailOfPlateAccount extends AbstractQuery<BaseOnLoadProjectSettlementDetailOfPlateAccount, ConditionOnLoadProjectSettlementDetailOfPlateAccount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProjectSettlementDetailOfPlateAccount.class);

	public QueryOnLoadProjectSettlementDetailOfPlateAccount() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProjectSettlementDetailOfPlateAccount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProjectSettlementDetailOfPlateAccount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getBusinessTypeId(), 
				condition.getSheetCode(), 
				condition.getSheetName(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnLoadProjectSettlementDetailOfPlateAccount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProjectSettlementDetailOfPlateAccount __base = new BaseOnLoadProjectSettlementDetailOfPlateAccount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "select a.plate_id,c.contract_code as sheet_code,c.project_name as sheet_name,a.integral,a.record_date,a.remark from plate_account_records a left join plate_project_account_records b on a.business_id = b.plate_project_account_record_id left join projects c on b.project_id = c.project_id where a.plate_id = ? and a.business_type_id = ? and c.contract_code like ? and c.project_name like ? and EXTRACT(YEAR from a.record_date) =? and EXTRACT(MONTH from a.record_date) =? ORDER BY b.project_id,a.integral desc" ;
	private final static String RESULTSETFIELDLIST = "plate_id,sheet_code,sheet_name,integral,record_date,remark";
	private final static String[] fieldNames = { "plate_id", "business_type_id", "sheet_code", "sheet_name", "year", "month"};
}
