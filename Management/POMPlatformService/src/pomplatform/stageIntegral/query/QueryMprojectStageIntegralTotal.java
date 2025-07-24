package pomplatform.stageIntegral.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.stageIntegral.bean.BaseMprojectStageIntegralTotal;
import pomplatform.stageIntegral.bean.ConditionMprojectStageIntegralTotal;

public class QueryMprojectStageIntegralTotal extends AbstractQuery<BaseMprojectStageIntegralTotal, ConditionMprojectStageIntegralTotal>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectStageIntegralTotal.class);

	public QueryMprojectStageIntegralTotal() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.project_stage_record_id");
	}

	@Override
	public BaseCollection<BaseMprojectStageIntegralTotal> executeQuery( KeyValuePair[] replacements, ConditionMprojectStageIntegralTotal condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId()
			);
	}

	@Override
	public BaseMprojectStageIntegralTotal generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectStageIntegralTotal __base = new BaseMprojectStageIntegralTotal();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectStageRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageIntegral(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStageSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageFinalIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectFinalIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select abc.project_stage_record_id ,abc.project_id,abc.stage_id,abc.stage_integral,case when abc.stage_sure_integral is null then 0 else abc.stage_sure_integral end as stage_sure_integral ,abc.project_integral,case when abc.project_sure_integral is null then 0 else abc.project_sure_integral end as project_sure_integral ,(abc.stage_integral-(case when abc.stage_sure_integral is null then 0 else abc.stage_sure_integral end)) as stage_final_integral ,(abc.project_integral-(case when abc.project_sure_integral is null then 0 else abc.project_sure_integral end)) as project_final_integral from ( select a.*,round(b.project_amount) as stage_integral ,(select round(sum(case when sure_integral is null then 0 else sure_integral end)) from project_employee_integral_records where project_id = a.project_id and stage_id = a.stage_id group by project_id,stage_id) as stage_sure_integral ,round(c.project_integral) as project_integral ,(select round(sum(case when sure_integral is null then 0 else sure_integral end)) from project_employee_integral_records where project_id = a.project_id group by project_id) as project_sure_integral from project_stage_records a left join project_stages b on b.project_id = a.project_id and b.stage_id = a.stage_id left join projects c on c.project_id = a.project_id ) abc where abc.project_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_stage_record_id,project_id,stage_id,stage_integral,stage_sure_integral,project_integral,project_sure_integral,stage_final_integral,project_final_integral";
	private final static String[] fieldNames = { "project_id"};
}
