package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseGetContractActualMoneyByPlateIdAndBusinessType;
import pomplatform.contract.bean.ConditionGetContractActualMoneyByPlateIdAndBusinessType;

public class QueryGetContractActualMoneyByPlateIdAndBusinessType extends AbstractQuery<BaseGetContractActualMoneyByPlateIdAndBusinessType, ConditionGetContractActualMoneyByPlateIdAndBusinessType>
{

	private static final Logger __logger = Logger.getLogger(QueryGetContractActualMoneyByPlateIdAndBusinessType.class);

	public QueryGetContractActualMoneyByPlateIdAndBusinessType() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_id");
	}

	@Override
	public BaseCollection<BaseGetContractActualMoneyByPlateIdAndBusinessType> executeQuery( KeyValuePair[] replacements, ConditionGetContractActualMoneyByPlateIdAndBusinessType condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getBusinessType()
			);
	}

	@Override
	public BaseGetContractActualMoneyByPlateIdAndBusinessType generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetContractActualMoneyByPlateIdAndBusinessType __base = new BaseGetContractActualMoneyByPlateIdAndBusinessType();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setActualMoney(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.contract_id, a.signing_money_sum, b.actual_money from contracts a LEFT JOIN contract_distributions b on a.contract_id = b.contract_id where b.contract_distribution_id in (SELECT max(contract_distribution_id) from contract_distributions where plate_id = ? and business_type = ? GROUP BY contract_id, plate_id)" ;
	private final static String RESULTSETFIELDLIST = "contract_id,signing_money_sum,actual_money";
	private final static String[] fieldNames = { "plate_id", "business_type"};
}
