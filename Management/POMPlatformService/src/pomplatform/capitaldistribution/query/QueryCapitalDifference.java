package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseCapitalDifference;
import pomplatform.capitaldistribution.bean.ConditionCapitalDifference;

public class QueryCapitalDifference extends AbstractQuery<BaseCapitalDifference, ConditionCapitalDifference>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalDifference.class);

	public QueryCapitalDifference() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.capital_id");
	}

	@Override
	public BaseCollection<BaseCapitalDifference> executeQuery( KeyValuePair[] replacements, ConditionCapitalDifference condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMoneyAttribute(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseCapitalDifference generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalDifference __base = new BaseCapitalDifference();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectNum(GenericBase.__getLong(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
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

	private final static String __SQLText = "select abc.* from (select d.*, count(e.project_id) as project_num from (select a.capital_id, a.happen_date, a.borrow_money, (a.borrow_money - COALESCE(sum(c.distribution_amount),0)) as left_amount, a.remark, a.contract_id, b.contract_code, b.contract_name from capitals a LEFT JOIN contracts b on a.contract_id = b.contract_id LEFT JOIN capital_distributions c on a.capital_id = c.capital_id and c.delete_flag = 0 where a.money_attribute = ? and a.happen_date >= ? and a.happen_date < ? group by a.capital_id, a.happen_date, a.borrow_money, a.remark, a.contract_id, b.contract_code, b.contract_name) d LEFT JOIN projects e on d.contract_id = e.contract_id and d.contract_id > 0 where d.left_amount is null or d.left_amount != 0 group by d.capital_id, d.happen_date, d.borrow_money, d.left_amount, d.remark, d.contract_id, d.contract_code, d.contract_name ) abc" ;
	private final static String RESULTSETFIELDLIST = "capital_id,happen_date,borrow_money,left_amount,remark,contract_id,contract_code,contract_name,project_num";
	private final static String[] fieldNames = { "money_attribute", "start_date", "end_date"};
}
