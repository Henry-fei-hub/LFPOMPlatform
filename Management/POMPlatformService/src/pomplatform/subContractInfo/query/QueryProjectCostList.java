package pomplatform.subContractInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.subContractInfo.bean.BaseProjectCostList;
import pomplatform.subContractInfo.bean.ConditionProjectCostList;

public class QueryProjectCostList extends AbstractQuery<BaseProjectCostList, ConditionProjectCostList>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectCostList.class);

	public QueryProjectCostList() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pc.project_cost_id");
	}

	@Override
	public BaseCollection<BaseProjectCostList> executeQuery( KeyValuePair[] replacements, ConditionProjectCostList condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getCostType()
			);
	}

	@Override
	public BaseProjectCostList generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectCostList __base = new BaseProjectCostList();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectCostId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCostDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSettlementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select pc.project_cost_id, pc.project_id, pc.employee_id, pc.cost_type, pc.cost_date, pc.settlement_id, pc.status, pc.amount from project_cost pc left join projects p on p.project_id = pc.project_id where pc.status = ? and pc.cost_type = ?" ;
	private final static String RESULTSETFIELDLIST = "project_cost_id,project_id,employee_id,cost_type,cost_date,settlement_id,status,amount";
	private final static String[] fieldNames = { "status", "cost_type"};
}
