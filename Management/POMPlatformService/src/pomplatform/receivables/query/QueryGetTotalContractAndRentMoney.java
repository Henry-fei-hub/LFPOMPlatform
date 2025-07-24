package pomplatform.receivables.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.receivables.bean.BaseGetTotalContractAndRentMoney;
import pomplatform.receivables.bean.ConditionGetTotalContractAndRentMoney;

public class QueryGetTotalContractAndRentMoney extends AbstractQuery<BaseGetTotalContractAndRentMoney, ConditionGetTotalContractAndRentMoney>
{

	private static final Logger __logger = Logger.getLogger(QueryGetTotalContractAndRentMoney.class);

	public QueryGetTotalContractAndRentMoney() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT (SELECT sum(borrow_money) FROM capitals WHERE money_attribute = 1 AND happen_date BETWEEN :first_date AND :end_date AND capital_type = 1) as contract_money");
	}

	@Override
	public BaseCollection<BaseGetTotalContractAndRentMoney> executeQuery( KeyValuePair[] replacements, ConditionGetTotalContractAndRentMoney condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getFirstDate(), 
				condition.getEndDate(), 
				condition.getFirstDate(), 
				condition.getEndDate(), 
				condition.getFirstDate(), 
				condition.getEndDate(), 
				condition.getFirstDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseGetTotalContractAndRentMoney generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetTotalContractAndRentMoney __base = new BaseGetTotalContractAndRentMoney();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRentMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSubsidyMoney(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
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

	private final static String __SQLText = "select (COALESCE(m.contract_money_1, 0) + COALESCE(m.contract_money_2, 0)) as contract_money, m.rent_money, m.subsidy_money from (SELECT DISTINCT (SELECT sum(COALESCE(borrow_money, 0)) FROM capitals WHERE money_attribute in (1,12) AND happen_date BETWEEN ? AND ? AND capital_type = 1) as contract_money_1, (SELECT sum(COALESCE(actual_amount, 0)) FROM capitals WHERE money_attribute in (11,13) AND actual_receive_date BETWEEN ? AND ? AND capital_type = 1) as contract_money_2, (SELECT sum(COALESCE(borrow_money, 0)) FROM capitals WHERE money_attribute = 2 AND happen_date BETWEEN ? AND ? AND capital_type = 1) as rent_money, (SELECT sum(COALESCE(borrow_money, 0)) FROM capitals WHERE money_attribute = 7 AND happen_date BETWEEN ? AND ? AND capital_type = 1) as subsidy_money FROM capitals) m" ;
	private final static String RESULTSETFIELDLIST = "contract_money,rent_money,subsidy_money";
	private final static String[] fieldNames = { "first_date", "end_date", "first_date", "end_date", "first_date", "end_date", "first_date", "end_date"};
}
