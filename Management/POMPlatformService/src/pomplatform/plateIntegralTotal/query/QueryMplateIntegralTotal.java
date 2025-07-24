package pomplatform.plateIntegralTotal.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateIntegralTotal.bean.BaseMplateIntegralTotal;
import pomplatform.plateIntegralTotal.bean.ConditionMplateIntegralTotal;

public class QueryMplateIntegralTotal extends AbstractQuery<BaseMplateIntegralTotal, ConditionMplateIntegralTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryMplateIntegralTotal.class);

	public QueryMplateIntegralTotal() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.plate_id");
	}

	@Override
	public BaseCollection<BaseMplateIntegralTotal> executeQuery( KeyValuePair[] replacements, ConditionMplateIntegralTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId()
			);
	}

	@Override
	public BaseMplateIntegralTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMplateIntegralTotal __base = new BaseMplateIntegralTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setCostIntegral(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSalaryIntegral(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getLong(val));

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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
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

	private final static String __SQLText = "select abc.plate_id,sum(abc.reserve_integral) as reserve_integral,sum(abc.sure_integral) as sure_integral,sum(abc.cost_integral) as cost_integral,sum(abc.salary_integral) as salary_integral,sum(abc.achieve_integral) as achieve_integral from ( select a.plate_id,round(sum(a.project_integral)) as reserve_integral,round(sum((select sum(real_amount) from project_settlement_details where project_id = a.project_id group by project_id))) as sure_integral,round(sum((select sum(project_cost) from project_settlement_details where project_id = a.project_id group by project_id))) as cost_integral ,0 as salary_integral,0 as achieve_integral from projects a group by a.plate_id union all select aa.plate_id,aa.reserve_integral,aa.sure_integral,round(pcr.cost_integral) as cost_integral,round(pcr.salary_integral) as salary_integral,aa.achieve_integral from (select a.plate_id,round(sum(a.reserve_integral)) as reserve_integral ,round(sum((select sum(real_amount) from project_settlement_details where project_id = a.project_id group by project_id)/(case when a.project_integral = 0 then 1 else a.project_integral end)*(case when a.project_integral = 0 then 0 else a.reserve_integral end))) as sure_integral ,round(sum(((select sum(real_amount) from project_settlement_details where project_id = a.project_id group by project_id)/(case when a.project_integral = 0 then 1 else a.project_integral end)*(case when a.project_integral = 0 then 0 else a.reserve_integral end)))-(select round(cost_integral+salary_integral) from plate_cost_records where plate_id = a.plate_id)) as achieve_integral from projects a group by a.plate_id) as aa left join plate_cost_records pcr on aa.plate_id = pcr.plate_id ) abc where abc.plate_id = ?  group by abc.plate_id ORDER BY abc.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,reserve_integral,sure_integral,cost_integral,salary_integral,achieve_integral";
	private final static String[] fieldNames = { "plate_id"};
}
