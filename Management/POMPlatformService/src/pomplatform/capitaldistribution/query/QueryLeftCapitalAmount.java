package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseLeftCapitalAmount;
import pomplatform.capitaldistribution.bean.ConditionLeftCapitalAmount;

public class QueryLeftCapitalAmount extends AbstractQuery<BaseLeftCapitalAmount, ConditionLeftCapitalAmount>
{

	private static final Logger __logger = Logger.getLogger(QueryLeftCapitalAmount.class);

	public QueryLeftCapitalAmount() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.capital_id");
	}

	@Override
	public BaseCollection<BaseLeftCapitalAmount> executeQuery( KeyValuePair[] replacements, ConditionLeftCapitalAmount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCapitalId()
			);
	}

	@Override
	public BaseLeftCapitalAmount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseLeftCapitalAmount __base = new BaseLeftCapitalAmount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.capital_id, a.contract_id, a.borrow_money, a.happen_date, a.remark, (COALESCE(a.borrow_money, 0) - COALESCE(sum(b.distribution_amount), 0)) as left_amount from capitals a LEFT JOIN capital_distributions b on a.capital_id = b.capital_id and b.delete_flag = 0 where a.capital_id = ? group by a.capital_id, a.contract_id, a.borrow_money, a.happen_date, a.remark" ;
	private final static String RESULTSETFIELDLIST = "capital_id,contract_id,borrow_money,happen_date,remark,left_amount";
	private final static String[] fieldNames = { "capital_id"};
}
