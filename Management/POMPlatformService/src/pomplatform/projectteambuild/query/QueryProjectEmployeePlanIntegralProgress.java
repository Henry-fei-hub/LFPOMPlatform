package pomplatform.projectteambuild.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectteambuild.bean.BaseProjectEmployeePlanIntegralProgress;
import pomplatform.projectteambuild.bean.ConditionProjectEmployeePlanIntegralProgress;

public class QueryProjectEmployeePlanIntegralProgress extends AbstractQuery<BaseProjectEmployeePlanIntegralProgress, ConditionProjectEmployeePlanIntegralProgress>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectEmployeePlanIntegralProgress.class);

	public QueryProjectEmployeePlanIntegralProgress() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_code");
	}

	@Override
	public BaseCollection<BaseProjectEmployeePlanIntegralProgress> executeQuery( KeyValuePair[] replacements, ConditionProjectEmployeePlanIntegralProgress condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseProjectEmployeePlanIntegralProgress generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectEmployeePlanIntegralProgress __base = new BaseProjectEmployeePlanIntegralProgress();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
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

	private final static String __SQLText = "select a.project_code , a.contract_code, a.project_name, b.employee_id, b.stage_id, b.plan_integral, b.real_integral, b.alternate_field1, b.alternate_field2 from project_employees b left join projects a on a.project_id = b.project_id where a.project_id =?" ;
	private final static String RESULTSETFIELDLIST = "project_code,contract_code,project_name,employee_id,stage_id,plan_integral,real_integral,alternate_field1,alternate_field2";
	private final static String[] fieldNames = { "project_id"};
}
