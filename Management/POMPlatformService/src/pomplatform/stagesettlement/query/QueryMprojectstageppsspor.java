package pomplatform.stagesettlement.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.stagesettlement.bean.BaseMprojectstageppsspor;
import pomplatform.stagesettlement.bean.ConditionMprojectstageppsspor;

public class QueryMprojectstageppsspor extends AbstractQuery<BaseMprojectstageppsspor, ConditionMprojectstageppsspor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectstageppsspor.class);

	public QueryMprojectstageppsspor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("p.project_id");
	}

	@Override
	public BaseCollection<BaseMprojectstageppsspor> executeQuery( KeyValuePair[] replacements, ConditionMprojectstageppsspor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getStageId()
			);
	}

	@Override
	public BaseMprojectstageppsspor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectstageppsspor __base = new BaseMprojectstageppsspor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalcount(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCostIds(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
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

	private final static String __SQLText = "select a.*, sum(b.amount) as final_amount, array_to_string(ARRAY(SELECT UNNEST (ARRAY_AGG (DISTINCT b.project_cost_id))), ',') as cost_ids from (select p.project_id, p.stage_id, round(p.project_amount,2) as project_amount, sum(COALESCE(ps.total_amount,0.0))-sum(COALESCE(ps.total_cost,0.0)) as total_amount, sum(COALESCE(ps.total_cost,0.0)) as total_cost,count(ps.total_amount) as totalcount, round(p.project_amount,2)-sum(COALESCE(ps.total_amount,0.0)) as left_amount from project_stages p left join project_settlements ps on p.project_id = ps.project_id and p.stage_id = ps.stage_id AND ps.settlement_status <> 3 where p.project_id = ? and p.stage_id = ? group by p.project_id, p.stage_id, p.project_amount) a LEFT JOIN project_cost b on a.project_id = b.project_id and b.status = 0 and b.settlement_status is null group by a.project_id, a.stage_id, a.project_amount, a.total_amount, a.total_cost, a.totalcount, a.left_amount" ;
	private final static String RESULTSETFIELDLIST = "project_id,stage_id,project_amount,total_amount,total_cost,totalcount,left_amount,final_amount,cost_ids";
	private final static String[] fieldNames = { "project_id", "stage_id"};
}
