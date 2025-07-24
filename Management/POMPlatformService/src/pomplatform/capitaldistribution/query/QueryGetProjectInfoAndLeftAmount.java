package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseGetProjectInfoAndLeftAmount;
import pomplatform.capitaldistribution.bean.ConditionGetProjectInfoAndLeftAmount;

public class QueryGetProjectInfoAndLeftAmount extends AbstractQuery<BaseGetProjectInfoAndLeftAmount, ConditionGetProjectInfoAndLeftAmount>
{

	private static final Logger __logger = Logger.getLogger(QueryGetProjectInfoAndLeftAmount.class);

	public QueryGetProjectInfoAndLeftAmount() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseGetProjectInfoAndLeftAmount> executeQuery( KeyValuePair[] replacements, ConditionGetProjectInfoAndLeftAmount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseGetProjectInfoAndLeftAmount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetProjectInfoAndLeftAmount __base = new BaseGetProjectInfoAndLeftAmount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDistributedAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT x.*, y.sure_integral from (SELECT a.project_id, a.contract_code, a.contract_id, a.revenue_plate_id as plate_id, a.sheet_amount, case when sum(distribution_amount) is null then 0 else sum(distribution_amount) end as distributed_amount, (a.sheet_amount - (case when sum(distribution_amount) is null then 0 else sum(distribution_amount) end )) as left_amount, a.project_integral from projects a LEFT JOIN capital_distributions b on a.project_id = b.project_id and b.type = 2 and b.delete_flag = 0 and a.contract_id = b.contract_id where a.contract_id = ? group by a.project_id, a.contract_code, a.contract_id, a.revenue_plate_id, a.sheet_amount ) x LEFT JOIN (SELECT c.project_id, sum(d.total_amount) as sure_integral from projects c LEFT JOIN project_settlements d on c.project_id = d.project_id where c.contract_id = ? group by c.project_id) y on x.project_id = y.project_id order by x.sheet_amount" ;
	private final static String RESULTSETFIELDLIST = "project_id,contract_code,contract_id, plate_id , sheet_amount, distributed_amount, left_amount, project_integral, sure_integral";
	private final static String[] fieldNames = { "contract_id", "contract_id"};
}
