package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BasePlateOrProjectCapitalDistribution;
import pomplatform.capitaldistribution.bean.ConditionPlateOrProjectCapitalDistribution;

public class QueryPlateOrProjectCapitalDistribution extends AbstractQuery<BasePlateOrProjectCapitalDistribution, ConditionPlateOrProjectCapitalDistribution>
{

	private static final Logger __logger = Logger.getLogger(QueryPlateOrProjectCapitalDistribution.class);

	public QueryPlateOrProjectCapitalDistribution() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("* from ( (SELECT a.capital_distribution_id");
	}

	@Override
	public BaseCollection<BasePlateOrProjectCapitalDistribution> executeQuery( KeyValuePair[] replacements, ConditionPlateOrProjectCapitalDistribution condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getType(), 
				condition.getCapitalId(), 
				condition.getType(), 
				condition.getCapitalId()
			);
	}

	@Override
	public BasePlateOrProjectCapitalDistribution generateBase(Object[] __data) throws java.sql.SQLException {
		BasePlateOrProjectCapitalDistribution __base = new BasePlateOrProjectCapitalDistribution();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setBorrowMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "SELECT * from ( (SELECT a.capital_distribution_id, b.happen_date, b.borrow_money, a.type, a.capital_id, a.id, null as code, a.distribution_amount, a.operator, a.create_time, b.remark, 0 as plate_id from capital_distributions a LEFT JOIN capitals b on a.capital_id = b.capital_id where a.type = 1 and a.type = ? and a.capital_id = ? and a.delete_flag = 0) union all(SELECT a.capital_distribution_id, b.happen_date, b.borrow_money, a.type, a.capital_id, a.id, c.contract_code as code, a.distribution_amount, a.operator, a.create_time, b.remark, c.plate_id as plate_id from capital_distributions a LEFT JOIN capitals b on a.capital_id = b.capital_id LEFT JOIN projects c on a.id = c.project_id where a.type = 2 and a.type = ? and a.capital_id = ? and a.delete_flag = 0)) a ORDER BY a.id" ;
	private final static String RESULTSETFIELDLIST = "capital_distribution_id,happen_date,borrow_money,type,capital_id,id,code,distribution_amount,operator,create_time,remark,plate_id";
	private final static String[] fieldNames = { "type", "capital_id", "type", "capital_id"};
}
