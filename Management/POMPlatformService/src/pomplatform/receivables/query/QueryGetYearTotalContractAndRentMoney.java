package pomplatform.receivables.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.receivables.bean.BaseGetYearTotalContractAndRentMoney;
import pomplatform.receivables.bean.ConditionGetYearTotalContractAndRentMoney;

public class QueryGetYearTotalContractAndRentMoney extends AbstractQuery<BaseGetYearTotalContractAndRentMoney, ConditionGetYearTotalContractAndRentMoney>
{

	private static final Logger __logger = Logger.getLogger(QueryGetYearTotalContractAndRentMoney.class);

	public QueryGetYearTotalContractAndRentMoney() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT (SELECT sum(borrow_money) FROM capitals WHERE money_attribute = 1 AND 1 = :year AND 1 <= :month AND capital_type = 1) as year_contract_money");
	}

	@Override
	public BaseCollection<BaseGetYearTotalContractAndRentMoney> executeQuery( KeyValuePair[] replacements, ConditionGetYearTotalContractAndRentMoney condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseGetYearTotalContractAndRentMoney generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetYearTotalContractAndRentMoney __base = new BaseGetYearTotalContractAndRentMoney();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setYearContractMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYearRentMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setYearSubsidyMoney(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT DISTINCT (SELECT sum(borrow_money) FROM capitals WHERE money_attribute = 1 AND extract(year from happen_date) = ? AND extract(month from happen_date) <= ? AND capital_type = 1) as year_contract_money, (SELECT sum(borrow_money) FROM capitals WHERE money_attribute = 2 AND extract(year from happen_date) = ? AND extract(month from happen_date) <= ? AND capital_type = 1) as year_rent_money, (SELECT sum(borrow_money) FROM capitals WHERE money_attribute = 7 AND extract(year from happen_date) = ? AND extract(month from happen_date) <= ? AND capital_type = 1) as year_subsidy_money FROM capitals" ;
	private final static String RESULTSETFIELDLIST = "year_contract_money,year_rent_money,year_subsidy_money";
	private final static String[] fieldNames = { "year", "month", "year", "month", "year", "month"};
}
