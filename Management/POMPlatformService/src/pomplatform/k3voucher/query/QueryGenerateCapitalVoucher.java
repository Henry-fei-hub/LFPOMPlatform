package pomplatform.k3voucher.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3voucher.bean.BaseGenerateCapitalVoucher;
import pomplatform.k3voucher.bean.ConditionGenerateCapitalVoucher;

public class QueryGenerateCapitalVoucher extends AbstractQuery<BaseGenerateCapitalVoucher, ConditionGenerateCapitalVoucher>
{

	private static final Logger __logger = Logger.getLogger(QueryGenerateCapitalVoucher.class);

	public QueryGenerateCapitalVoucher() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.capital_id");
	}

	@Override
	public BaseCollection<BaseGenerateCapitalVoucher> executeQuery( KeyValuePair[] replacements, ConditionGenerateCapitalVoucher condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMoneyAttribute(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getSelfName(), 
				condition.getHaveVoucher()
			);
	}

	@Override
	public BaseGenerateCapitalVoucher generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGenerateCapitalVoucher __base = new BaseGenerateCapitalVoucher();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHaveVoucher(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSelfBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSelfBankAccount(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLoanMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setExchangeRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOriginalCurrency(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[4]));
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

	private final static String __SQLText = "select c.capital_id, c.money_attribute, case when kv.link_id is null then false else true end as have_voucher, c.self_bank_name, c.self_bank_account, c.other_name, c.borrow_money, c.loan_money, c.exchange_rate, c.original_currency, st.contract_code, c.happen_date, c.create_date, e.employee_name, c.remark from capitals c left join employees e on c.operator=e.employee_id left join contracts st on st.contract_id=c.contract_id left join k3_vouchers kv on c.capital_id = kv.link_id and kv.voucher_type = 3 where c.money_attribute = ? and extract(year from c.happen_date) = ? and extract(month from c.happen_date) = ? and c.self_name = ? and c.capital_type = 1 group by c.capital_id, c.money_attribute, c.self_bank_name, c.self_bank_account, c.other_name, c.borrow_money, c.loan_money, c.exchange_rate, c.original_currency, st.contract_code, c.happen_date, c.create_date, e.employee_name, c.remark, kv.link_id having have_voucher = ? order by c.capital_id" ;
	private final static String RESULTSETFIELDLIST = "capital_id,money_attribute,have_voucher,self_bank_name,self_bank_account,other_name,borrow_money,loan_money,exchange_rate,original_currency,contract_code,happen_date,create_date,employee_name,remark";
	private final static String[] fieldNames = { "money_attribute", "year", "month", "self_name", "have_voucher"};
}
