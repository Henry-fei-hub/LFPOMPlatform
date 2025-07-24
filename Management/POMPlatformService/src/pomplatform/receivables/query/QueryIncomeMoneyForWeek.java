package pomplatform.receivables.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.receivables.bean.BaseIncomeMoneyForWeek;
import pomplatform.receivables.bean.ConditionIncomeMoneyForWeek;

public class QueryIncomeMoneyForWeek extends AbstractQuery<BaseIncomeMoneyForWeek, ConditionIncomeMoneyForWeek>
{

	private static final Logger __logger = Logger.getLogger(QueryIncomeMoneyForWeek.class);

	public QueryIncomeMoneyForWeek() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.money_attribute");
	}

	@Override
	public BaseCollection<BaseIncomeMoneyForWeek> executeQuery( KeyValuePair[] replacements, ConditionIncomeMoneyForWeek condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseIncomeMoneyForWeek generateBase(Object[] __data) throws java.sql.SQLException {
		BaseIncomeMoneyForWeek __base = new BaseIncomeMoneyForWeek();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMoneyAttribute(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select * from (SELECT a.money_attribute,b.contract_id,b.contract_name,b.signing_money_sum, k.percent, CASE WHEN a.other_name is null THEN a.remark ELSE a.other_name END as other_name,CASE WHEN a.money_attribute IN (11, 13) and a.actual_receive_date BETWEEN ? and ? THEN COALESCE(a.actual_amount, 0) WHEN a.money_attribute IN (1, 2, 7, 12) and a.happen_date BETWEEN ? and ? THEN	COALESCE(a.borrow_money, 0) ELSE 0 end as borrow_money,a.remark,a.happen_date FROM capitals a LEFT JOIN contracts b ON a.contract_id = b.contract_id LEFT JOIN (select m.contract_id, case when n.signing_money_sum is not null and n.signing_money_sum != 0 then round(sum(COALESCE(m.borrow_money, 0))/n.signing_money_sum * 100, 2) else 0 end || '%' AS percent from (select contract_id, case when money_attribute in (11, 13) then sum(actual_amount) else SUM(borrow_money) end as borrow_money FROM capitals where contract_id > 0 group by contract_id, money_attribute) m LEFT JOIN contracts n on m.contract_id = n.contract_id group by m.contract_id, n.signing_money_sum) k on a.contract_id = k.contract_id WHERE ((a.happen_date BETWEEN ? AND ?) or (a.actual_receive_date BETWEEN ? AND ?)) AND a.money_attribute in(1,2,7,11,12,13) AND a.capital_type = 1 ORDER BY a.contract_id) x where x.borrow_money != 0" ;
	private final static String RESULTSETFIELDLIST = "money_attribute,contract_id,contract_name,signing_money_sum,percent,other_name,borrow_money,remark,happen_date";
	private final static String[] fieldNames = {"start_date", "end_date", "start_date", "end_date", "start_date", "end_date", "start_date", "end_date"};
}
