package pomplatform.capital.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capital.bean.BaseCapitalVoucher;
import pomplatform.capital.bean.ConditionCapitalVoucher;

public class QueryCapitalVoucher extends AbstractQuery<BaseCapitalVoucher, ConditionCapitalVoucher>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalVoucher.class);

	public QueryCapitalVoucher() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.capital_id");
	}

	@Override
	public BaseCollection<BaseCapitalVoucher> executeQuery( KeyValuePair[] replacements, ConditionCapitalVoucher condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCapitalId()
			);
	}

	@Override
	public BaseCapitalVoucher generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalVoucher __base = new BaseCapitalVoucher();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCardManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT a.capital_id, a.money_attribute, a.self_name as company_id, b.contract_name, b.customer_id, c.customer_name, d.card_manage_id, a.borrow_money, a.happen_date, a.remark from capitals a LEFT JOIN contracts b on a.contract_id = b.contract_id LEFT JOIN customers c on b.customer_id = c.customer_id LEFT JOIN card_manages d on a.self_bank_account = d.bank_account and d.object_type = 2 where a.capital_type = 1 and a.capital_id = ?" ;
	private final static String RESULTSETFIELDLIST = "capital_id,money_attribute,company_id,contract_name,customer_id,customer_name,card_manage_id,borrow_money,happen_date,remark";
	private final static String[] fieldNames = { "capital_id"};
}
