package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseSimpleCapitalList;
import pomplatform.capitaldistribution.bean.ConditionSimpleCapitalList;

public class QuerySimpleCapitalList extends AbstractQuery<BaseSimpleCapitalList, ConditionSimpleCapitalList>
{

	private static final Logger __logger = Logger.getLogger(QuerySimpleCapitalList.class);

	public QuerySimpleCapitalList() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.capital_id");
	}

	@Override
	public BaseCollection<BaseSimpleCapitalList> executeQuery( KeyValuePair[] replacements, ConditionSimpleCapitalList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(),
				condition.getContractId()
			);
	}

	@Override
	public BaseSimpleCapitalList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSimpleCapitalList __base = new BaseSimpleCapitalList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT m.*, n.operator, n.create_time from (SELECT a.capital_id, a.contract_id, a.borrow_money, a.happen_date, a.remark, b.locked, sum(b.distribution_amount) as distribution_amount from capitals a LEFT JOIN capital_distributions b on a.capital_id = b.capital_id and b.delete_flag = 0 WHERE a.contract_id = ? and a.money_attribute in (1, 11, 13) GROUP BY a.capital_id, a.remark, b.locked) m LEFT JOIN (SELECT y.capital_id, y.operator, y.create_time  from (SELECT capital_id, max(create_time) as create_time from capital_distributions where contract_id = ? and delete_flag = 0 group by capital_id) x LEFT JOIN capital_distributions y on x.capital_id = y.capital_id and x.create_time = y.create_time and y.delete_flag = 0 group by y.capital_id, y.operator, y.create_time) n on m.capital_id = n.capital_id ORDER BY m.happen_date desc" ;
	private final static String RESULTSETFIELDLIST = "capital_id,contract_id,borrow_money,happen_date,remark,locked,distribution_amount,operator,create_time";
	private final static String[] fieldNames = { "contract_id", "contract_id"};
}
