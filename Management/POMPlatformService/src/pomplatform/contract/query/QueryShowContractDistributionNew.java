package pomplatform.contract.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseShowContractDistributionNew;
import pomplatform.contract.bean.ConditionShowContractDistributionNew;

public class QueryShowContractDistributionNew extends AbstractQuery<BaseShowContractDistributionNew, ConditionShowContractDistributionNew>
{

	private static final Logger __logger = Logger.getLogger(QueryShowContractDistributionNew.class);

	public QueryShowContractDistributionNew() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cd.contract_distribution_id");
	}

	@Override
	public BaseCollection<BaseShowContractDistributionNew> executeQuery( KeyValuePair[] replacements, ConditionShowContractDistributionNew condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getOrderId(), 
				condition.getPlateId(), 
				condition.getOperationManagerId()
			);
	}

	@Override
	public BaseShowContractDistributionNew generateBase(Object[] __data) throws java.sql.SQLException {
		BaseShowContractDistributionNew __base = new BaseShowContractDistributionNew();
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
		if((val = __data[count++]) != null) __base.setRateOfProgress(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOrderStatus(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT cd.contract_distribution_id, cd.contract_id, cd.plate_id, cd.business_type, cd.amount, cd.operator, cd.create_time, cd.update_time, cd.delete_flag, cd.contract_date, cd.actual_money, cd.order_id, cd.operation_manager_id, cd.rate_of_progress, C .contract_name, C .signing_money_sum, cd.order_status FROM contract_distributions cd LEFT JOIN contracts C ON cd.contract_id = C .contract_id WHERE cd.order_id IS NOT NULL AND C.contract_code LIKE ? AND C.contract_name LIKE ? AND cd.order_id LIKE ? AND cd.plate_id = ? AND cd.operation_manager_id = ? ORDER BY cd.contract_distribution_id" ;
	private final static String RESULTSETFIELDLIST = "contract_distribution_id,contract_id,plate_id,business_type,amount,operator,create_time,update_time,delete_flag,contract_date,actual_money,order_id,operation_manager_id,rate_of_progress,contract_name,signing_money_sum,order_status";
	private final static String[] fieldNames = { "contract_code", "contract_name", "order_id", "plate_id", "operation_manager_id"};
}
