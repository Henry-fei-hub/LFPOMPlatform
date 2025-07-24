package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseCapitalLogDetail;
import pomplatform.capitaldistribution.bean.ConditionCapitalLogDetail;

public class QueryCapitalLogDetail extends AbstractQuery<BaseCapitalLogDetail, ConditionCapitalLogDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalLogDetail.class);

	public QueryCapitalLogDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_id");
	}

	@Override
	public BaseCollection<BaseCapitalLogDetail> executeQuery( KeyValuePair[] replacements, ConditionCapitalLogDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractName(), 
				condition.getContractCode(), 
				condition.getOperator(), 
				condition.getStartTime(), 
				condition.getEndTime()
			);
	}

	@Override
	public BaseCapitalLogDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalLogDetail __base = new BaseCapitalLogDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCapitalLogId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLogContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "select a.contract_id, a.contract_code, a.contract_name, c.borrow_money, cl.capital_log_id, cl.operator, cl.log_content, cl.create_time, cl.capital_id from capital_logs cl left join capitals c on cl.capital_id = c.capital_id left join contracts a on c.contract_id = a.contract_id where a.contract_name like ? and a.contract_code like ? and cl.operator = ? and cl.create_time >= ? and cl.create_time < ? order by cl.create_time desc, c.contract_id, c.capital_id" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,borrow_money,capital_log_id,operator,log_content,create_time,capital_id";
	private final static String[] fieldNames = { "contract_name", "contract_code", "operator", "start_time", "end_time"};
}
