package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseSearchProjectCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionSearchProjectCapitalDistribution;

public class QuerySearchProjectCapitalDistribution extends AbstractQuery<BaseSearchProjectCapitalDistribution, ConditionSearchProjectCapitalDistribution>
{

	private static final Logger __logger = Logger.getLogger(QuerySearchProjectCapitalDistribution.class);

	public QuerySearchProjectCapitalDistribution() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
	}

	@Override
	public BaseCollection<BaseSearchProjectCapitalDistribution> executeQuery( KeyValuePair[] replacements, ConditionSearchProjectCapitalDistribution condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseSearchProjectCapitalDistribution generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSearchProjectCapitalDistribution __base = new BaseSearchProjectCapitalDistribution();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDistributionAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "(SELECT a.project_id, a.capital_id, a.distribution_amount, b.happen_date from capital_distributions a LEFT JOIN capitals b on a.capital_id = b.capital_id where a.type =2 and a.project_id is not null and b.money_attribute in (1, 11, 13) and b.contract_id = ? and a.delete_flag = 0) union all (SELECT c.project_id as id, 0 as capital_id, ((case when c.sheet_amount is null then 0 else c.sheet_amount end)-sum(case when a.distribution_amount is null then 0 else a.distribution_amount end)) as distribution_amount, now() as happen_date from projects c LEFT JOIN capitals b on c.contract_id = b.contract_id and b.money_attribute in (1, 11, 13) LEFT JOIN capital_distributions a on c.project_id = a.project_id and a.type = 2 and b.capital_id = a.capital_id and a.delete_flag = 0 WHERE c.contract_id = ? group by c.project_id, c.sheet_amount) order by happen_date desc, project_id" ;
	private final static String RESULTSETFIELDLIST = "project_id,capital_id,distribution_amount,happen_date";
	private final static String[] fieldNames = { "contract_id", "contract_id"};
}
