package pomplatform.sureIntegrl.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.sureIntegrl.bean.BaseMprojectEmployeeSureIntegrl;
import pomplatform.sureIntegrl.bean.ConditionMprojectEmployeeSureIntegrl;

public class QueryMprojectEmployeeSureIntegrl extends AbstractQuery<BaseMprojectEmployeeSureIntegrl, ConditionMprojectEmployeeSureIntegrl>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectEmployeeSureIntegrl.class);

	public QueryMprojectEmployeeSureIntegrl() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseMprojectEmployeeSureIntegrl> executeQuery( KeyValuePair[] replacements, ConditionMprojectEmployeeSureIntegrl condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStageId(), 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMprojectEmployeeSureIntegrl generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectEmployeeSureIntegrl __base = new BaseMprojectEmployeeSureIntegrl();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAssignSureIntegral(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageSureIntegral(GenericBase.__getString(val));
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

	private final static String __SQLText = "select a.project_id,a.employee_id,a.plan_integral,0 as assign_sure_integral ,(select round(sum(case when sure_integral is null then 0 else sure_integral end )) from project_employee_integral_records where project_id = a.project_id and employee_id = a.employee_id and stage_id = ? group by project_id,employee_id,stage_id) as stage_sure_integral ,(select round(sum(case when sure_integral is null then 0 else sure_integral end )) from project_employee_integral_records where project_id = a.project_id and employee_id = a.employee_id group by project_id,employee_id) as sure_integral from project_employees a where a.project_id = ? order by plan_integral desc" ;
	private final static String RESULTSETFIELDLIST = "project_id,employee_id,plan_integral,assign_sure_integral,stage_sure_integral,sure_integral";
	private final static String[] fieldNames = { "stage_id", "project_id"};
}
