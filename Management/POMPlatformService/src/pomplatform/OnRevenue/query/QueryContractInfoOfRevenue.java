package pomplatform.OnRevenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnRevenue.bean.BaseContractInfoOfRevenue;
import pomplatform.OnRevenue.bean.ConditionContractInfoOfRevenue;

public class QueryContractInfoOfRevenue extends AbstractQuery<BaseContractInfoOfRevenue, ConditionContractInfoOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryContractInfoOfRevenue.class);

	public QueryContractInfoOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_id");
	}

	@Override
	public BaseCollection<BaseContractInfoOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionContractInfoOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEndDate(), 
				condition.getEndDate(), 
				condition.getSigningCompany(), 
				condition.getIsFinish()
			);
	}

	@Override
	public BaseContractInfoOfRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractInfoOfRevenue __base = new BaseContractInfoOfRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSigningCompanyName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsFinish(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setInvoiceAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[3]));
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

	private final static String __SQLText = "select a.contract_id,a.contract_code,a.contract_name,a.signing_money_sum,a.signing_company_name,a.is_finish ,(select sum(invoice_amount) from invoices where contract_id = a.contract_id and registration_date < ?) as invoice_amount ,(select sum(borrow_money) from capitals where contract_id = a.contract_id and money_attribute = 1 and create_date < ?) as borrow_money from contracts a where a.signing_company_name =? and a.is_finish = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,signing_money_sum,signing_company_name,is_finish,invoice_amount,borrow_money";
	private final static String[] fieldNames = { "end_date", "end_date", "signing_company", "is_finish"};
}
