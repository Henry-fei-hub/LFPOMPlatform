package pomplatform.k3voucher.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3voucher.bean.BaseGetCompanyBankAccountK3Code;
import pomplatform.k3voucher.bean.ConditionGetCompanyBankAccountK3Code;

public class QueryGetCompanyBankAccountK3Code extends AbstractQuery<BaseGetCompanyBankAccountK3Code, ConditionGetCompanyBankAccountK3Code>
{

	private static final Logger __logger = Logger.getLogger(QueryGetCompanyBankAccountK3Code.class);

	public QueryGetCompanyBankAccountK3Code() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.bank_account");
	}

	@Override
	public BaseCollection<BaseGetCompanyBankAccountK3Code> executeQuery( KeyValuePair[] replacements, ConditionGetCompanyBankAccountK3Code condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBankAccount()
			);
	}

	@Override
	public BaseGetCompanyBankAccountK3Code generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetCompanyBankAccountK3Code __base = new BaseGetCompanyBankAccountK3Code();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setObjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setK3CodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setK3Code(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setK3Name(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "select b.bank_account, b.object_id, a.type, a.k3_code_id, a.k3_code, a.k3_name from k3_codes a LEFT JOIN card_manages b on a.business_id = b.card_manage_id and a.type = 5 and b.object_type = 2 where a.type = 5 and b.bank_account = ?" ;
	private final static String RESULTSETFIELDLIST = "bank_account,object_id,type,k3_code_id,k3_code,k3_name";
	private final static String[] fieldNames = { "bank_account"};
}
