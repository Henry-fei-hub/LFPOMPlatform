package pomplatform.receivables.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.receivables.bean.BaseMcapitalhyhor;
import pomplatform.receivables.bean.ConditionMcapitalhyhor;

public class QueryMcapitalhyhor extends AbstractQuery<BaseMcapitalhyhor, ConditionMcapitalhyhor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcapitalhyhor.class);

	public QueryMcapitalhyhor() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("SUM ( CASE WHEN money_attribute = 1 THEN borrow_money ELSE 0 END ) AS year_contract_money");
	}

	@Override
	public BaseCollection<BaseMcapitalhyhor> executeQuery( KeyValuePair[] replacements, ConditionMcapitalhyhor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getHappenDate(),
				condition.getYear(), 
				condition.getHappenDate(),
				condition.getYear(), 
				condition.getHappenDate(),
				condition.getYear(), 
				condition.getHappenDate()
			);
	}

	@Override
	public BaseMcapitalhyhor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcapitalhyhor __base = new BaseMcapitalhyhor();
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
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "select (COALESCE(m.contract_money_1, 0) + COALESCE(m.contract_money_2, 0)) as year_contract_money, m.year_rent_money, m.year_subsidy_money from (SELECT DISTINCT (SELECT sum(COALESCE(borrow_money, 0)) FROM capitals WHERE money_attribute in (1,12) AND extract(year from happen_date) = ? AND happen_date <= ? AND capital_type = 1) as contract_money_1, (SELECT sum(COALESCE(actual_amount, 0)) FROM capitals WHERE money_attribute in (11,13) AND extract(year from actual_receive_date) = ? AND actual_receive_date <= ? AND capital_type = 1) as contract_money_2, (SELECT sum(COALESCE(borrow_money, 0)) FROM capitals WHERE money_attribute = 2 AND extract(year from happen_date) = ? AND happen_date <= ? AND capital_type = 1) as year_rent_money, (SELECT sum(COALESCE(borrow_money, 0)) FROM capitals WHERE money_attribute = 7 AND extract(year from happen_date) = ? AND happen_date <= ? AND capital_type = 1) as year_subsidy_money FROM capitals) m" ;
	private final static String RESULTSETFIELDLIST = "year_contract_money,year_rent_money,year_subsidy_money";
	private final static String[] fieldNames = { "year", "happen_date", "year", "happen_date", "year", "happen_date", "year", "happen_date"};
}
