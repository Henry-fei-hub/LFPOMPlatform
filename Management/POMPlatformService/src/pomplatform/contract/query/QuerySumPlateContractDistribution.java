package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseSumPlateContractDistribution;
import pomplatform.contract.bean.ConditionSumPlateContractDistribution;

public class QuerySumPlateContractDistribution extends AbstractQuery<BaseSumPlateContractDistribution, ConditionSumPlateContractDistribution>
{

	private static final Logger __logger = Logger.getLogger(QuerySumPlateContractDistribution.class);

	public QuerySumPlateContractDistribution() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sum(amount) as amount");
	}

	@Override
	public BaseCollection<BaseSumPlateContractDistribution> executeQuery( KeyValuePair[] replacements, ConditionSumPlateContractDistribution condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getPlateId(),
				condition.getBusinessType()
			);
	}

	@Override
	public BaseSumPlateContractDistribution generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSumPlateContractDistribution __base = new BaseSumPlateContractDistribution();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT sum(a.actual_money) as amount from contract_distributions a where a.contract_id in (select contract_id from contracts where extract(year from contract_date) = (select extract(year from contract_date) from contracts where contract_id = ?)) and a.plate_id = ? and a.business_type = ? and a.delete_flag = 0" ;
	private final static String RESULTSETFIELDLIST = "amount";
	private final static String[] fieldNames = { "contract_id", "plate_id", "business_type"};
}
