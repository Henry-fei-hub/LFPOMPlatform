package pomplatform.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseMprojectemployeeForQuery;
import pomplatform.operation.bean.ConditionMprojectemployeeForQuery;

public class QueryMprojectemployeeForQuery extends AbstractQuery<BaseMprojectemployeeForQuery, ConditionMprojectemployeeForQuery>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectemployeeForQuery.class);

	public QueryMprojectemployeeForQuery() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pe.project_id");
	}

	@Override
	public BaseCollection<BaseMprojectemployeeForQuery> executeQuery( KeyValuePair[] replacements, ConditionMprojectemployeeForQuery condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getProjectId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseMprojectemployeeForQuery generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectemployeeForQuery __base = new BaseMprojectemployeeForQuery();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSettlement(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAdvancedIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select pe.project_id, pe.employee_id, pe.plan_integral, ec.real_integral,ec.cost,ec.settlement,COALESCE ( pr.advanced_integral, 0 ) as advanced_integral from (SELECT employee_id,sum(COALESCE(plan_integral,0)) as plan_integral,project_id FROM project_employees WHERE status = ? GROUP BY employee_id,project_id) pe LEFT JOIN (SELECT project_id,employee_id,sum(COALESCE(real_amount,0)) as real_integral,sum(COALESCE(project_cost,0)) as cost,sum(COALESCE(final_amount,0)) as settlement FROM project_settlement_details WHERE settlement_status = 2 GROUP BY employee_id,project_id) ec on ec.project_id = pe.project_id AND ec.employee_id = pe.employee_id LEFT JOIN ( SELECT SUM ( COALESCE ( advanced_integral, 0 )) AS advanced_integral, project_id, employee_id FROM project_employee_advance_records GROUP BY project_id, employee_id ) pr ON pr.project_id = pe.project_id and pr.employee_id=pe.employee_id where pe.project_id = ? AND pe.employee_id = ? group by pe.employee_id,pe.project_id,ec.real_integral,ec.cost,ec.settlement,pe.plan_integral,pr.advanced_integral" ;
	private final static String RESULTSETFIELDLIST = "project_id,employee_id,plan_integral,real_integral,cost,settlement,advanced_integral";
	private final static String[] fieldNames = { "status", "project_id", "employee_id"};
}
