package pomplatform.projectStageTemplate.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectStageTemplate.bean.BaseSprojectstagetemplatepor;
import pomplatform.projectStageTemplate.bean.ConditionSprojectstagetemplatepor;

public class QuerySprojectstagetemplatepor extends AbstractQuery<BaseSprojectstagetemplatepor, ConditionSprojectstagetemplatepor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectstagetemplatepor.class);

	public QuerySprojectstagetemplatepor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BaseSprojectstagetemplatepor> executeQuery( KeyValuePair[] replacements, ConditionSprojectstagetemplatepor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectTemplateId()
			);
	}

	@Override
	public BaseSprojectstagetemplatepor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectstagetemplatepor __base = new BaseSprojectstagetemplatepor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectStageTemplateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectTemplateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectTemplateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select * from project_stage_templates where project_template_id =? order by stage_id asc" ;
	private final static String RESULTSETFIELDLIST = "project_stage_template_id,stage_id,percent,stage_name,project_template_name,project_template_id,project_amount";
	private final static String[] fieldNames = { "project_template_id"};
}
