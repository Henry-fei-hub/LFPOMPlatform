package pomplatform.projectCost.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectCost.bean.BaseAllCapitalDistributionInfo;
import pomplatform.projectCost.bean.ConditionAllCapitalDistributionInfo;

public class QueryAllCapitalDistributionInfo extends AbstractQuery<BaseAllCapitalDistributionInfo, ConditionAllCapitalDistributionInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryAllCapitalDistributionInfo.class);

	public QueryAllCapitalDistributionInfo() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("m.*");
	}

	@Override
	public BaseCollection<BaseAllCapitalDistributionInfo> executeQuery( KeyValuePair[] replacements, ConditionAllCapitalDistributionInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getStartHappenDate(), 
				condition.getEndHappenDate(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getLocked(), 
				condition.getStartDistributeTime(), 
				condition.getEndDistributeTime(), 
				condition.getProjectManageId()
			);
	}

	@Override
	public BaseAllCapitalDistributionInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAllCapitalDistributionInfo __base = new BaseAllCapitalDistributionInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "SELECT m.*, n.operator, n.create_time from (SELECT a.capital_id, a.contract_id, c.contract_code, c.contract_name, coalesce(a.borrow_money, 0) as borrow_money, a.happen_date, a.remark, coalesce(b.locked, false) as locked, sum(coalesce(b.distribution_amount, 0)) as distribution_amount, (coalesce(a.borrow_money, 0) - sum(coalesce(b.distribution_amount, 0))) as left_amount from capitals a LEFT JOIN capital_distributions b on a.capital_id = b.capital_id and b.delete_flag = 0 LEFT JOIN contracts c on a.contract_id = c.contract_id WHERE c.contract_code like ? and c.contract_name like ? and a.happen_date >= ? and a.happen_date < ? and a.money_attribute in (1, 11, 13) GROUP BY a.capital_id, a.remark, b.locked, c.contract_code, c.contract_name) m LEFT JOIN (SELECT y.capital_id, y.operator, y.create_time from (SELECT a.capital_id, max(a.create_time) as create_time from capital_distributions a LEFT JOIN contracts b on a.contract_id = b.contract_id where b.contract_code like ? and b.contract_name like ? and a.delete_flag = 0 group by a.capital_id) x LEFT JOIN capital_distributions y on x.capital_id = y.capital_id and x.create_time = y.create_time and y.delete_flag = 0 group by y.capital_id, y.operator, y.create_time) n on m.capital_id = n.capital_id WHERE m.locked = ? and n.create_time >= ? and n.create_time < ? and m.contract_id in (select contract_id from projects where project_manage_id = ? and contract_id >0) ORDER BY m.happen_date desc" ;
	private final static String RESULTSETFIELDLIST = "capital_id,contract_id,contract_code,contract_name,borrow_money,happen_date,remark,locked,distribution_amount,left_amount,operator,create_time";
	private final static String[] fieldNames = { "contract_code", "contract_name", "start_happen_date", "end_happen_date", "contract_code", "contract_name", "locked", "start_distribute_time", "end_distribute_time", "project_manage_id"};
}
