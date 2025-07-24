package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseShowContractDistribution;
import pomplatform.contract.bean.ConditionShowContractDistribution;

public class QueryShowContractDistribution extends AbstractQuery<BaseShowContractDistribution, ConditionShowContractDistribution>
{

	private static final Logger __logger = Logger.getLogger(QueryShowContractDistribution.class);

	public QueryShowContractDistribution() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cd.*");
	}

	@Override
	public BaseCollection<BaseShowContractDistribution> executeQuery( KeyValuePair[] replacements, ConditionShowContractDistribution condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getOrderId(), 
				condition.getPlateId(), 
				condition.getOperationManagerId()
			);
	}

	@Override
	public BaseShowContractDistribution generateBase(Object[] __data) throws java.sql.SQLException {
		BaseShowContractDistribution __base = new BaseShowContractDistribution();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setActualMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOrderId(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperationManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT cd.*, c.contract_name, c.signing_money_sum FROM contract_distributions cd LEFT JOIN contracts C ON cd.contract_id = C .contract_id where cd.order_id is NOT NULL AND c.contract_code like ? AND c.contract_name like ? AND cd.order_id like ? AND cd.plate_id = ? AND cd.operation_manager_id = ? ORDER BY cd.contract_distribution_id" ;
	private final static String RESULTSETFIELDLIST = "contract_distribution_id,contract_id,plate_id,business_type,amount,operator,create_time,update_time,delete_flag,contract_date,actual_money,order_id,operation_manager_id,contract_name,signing_money_sum";
	private final static String[] fieldNames = { "contract_code", "contract_name", "order_id", "plate_id", "operation_manager_id"};
}
